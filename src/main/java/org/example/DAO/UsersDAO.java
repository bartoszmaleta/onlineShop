package org.example.DAO;

import org.example.model.user.RoleEnum;
import org.example.model.user.RoleIdException;
import org.example.model.user.User;
import org.example.model.user.UserInterface;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDAO extends ConnectionFactory.DAO implements UserInterface {

    @Override
    public void viewUserTable() throws SQLException {
        System.out.println("------------ USER TABLE ------------------");

        connect();
        String SELECT_SQL = "SELECT * FROM users;";

        try {
            ResultSet rs = st.executeQuery(SELECT_SQL);

            while (rs.next()) {
                int id = rs.getInt("id");
                String login = rs.getString("login");
                String password = rs.getString("password");
                String email = rs.getString("email");
                int roleId = rs.getInt("idrole");
                String role;
                switch (roleId) {
                    case 1:
                        role = "Admin";
                        break;
                    case 2:
                        role = "Customer";
                        break;
                    default:
                        throw new RoleIdException("No role with id " + roleId);
                }

                //                    case 1 -> "Admin";
//                    case 2 -> "Customer";
//                    default -> throw new RoleIdException("No role with id " + roleId);
//                };

                String format = "|%1$-3s|%2$-18s|%3$-16s|%4$-30s|%5$-9s|\n";
                System.out.printf(format, id, login, password, email, role);
            }
            close();
        } catch (SQLException | RoleIdException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addUser(User user) throws Exception {
        connect();
        String INSERT_SQL = "INSERT INTO Users (login, password, email, idROle) " +
                "VALUES (?, ?, ?, ?);";

        String login = user.getLogin();
        String password = user.getPassword();
        String email = user.getEmail();
        RoleEnum role = user.getRole();
        int idRole;
        switch (role) {
            case ADMIN:
                idRole = 1;
                break;
            case CUSTOMER :
                idRole = 2;
                break;
            default:
                throw new Exception("Something went wrong");
        }

        PreparedStatement ps = null;

        try {
            ps = this.c.prepareStatement(INSERT_SQL);
            ps.setString(1, login);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setInt(4, idRole);
            ps.executeUpdate();
            ps.close();
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isLoginTaken(String loginToCheck) throws SQLException {
        connect();
        String SELECT_SQL = "SELECT * FROM Users WHERE login = '" + loginToCheck + "';";

        try {
            ResultSet rs = st.executeQuery(SELECT_SQL);

            while (rs.next()) {
                String login = rs.getString("login");
                if (loginToCheck.equals(login)) {
                    return true;
                }
            }

            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean isEmailTaken(String emailToCheck) throws SQLException {
        connect();
        String SELECT_SQL = "SELECT * FROM Users WHERE email = '" + emailToCheck + "';";

        try {
            ResultSet rs = st.executeQuery(SELECT_SQL);

            while (rs.next()) {
                String email = rs.getString("email");
                if (emailToCheck.equals(email)) {
                    return true;
                }
            }
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}

