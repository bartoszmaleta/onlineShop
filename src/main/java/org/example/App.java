package org.example;

import org.example.model.User;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App
{
    private static User user;

    public static void main( String[] args )
    {
        System.out.println();
//        connectWithDB();
        connect();

    }

    private static void connectWithDB() {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:/home/acer/PROGRAMMING/Java Repositories/onlineShop/AllteregoDB");
            c.setAutoCommit(false);
            stmt = c.createStatement();

//            String query  = "INSERT INTO Users(Name, BasketId, UserRankId)" +  "VALUES ('Bill', '0', '1');";
            String query  = "INSERT INTO Users(Name, BasketId, UserRankId)" +  "VALUES (?, ?, ?);";

            PreparedStatement preparedStmt = c.prepareStatement(query);
            preparedStmt.setString(1, "Bill");
            preparedStmt.setString(2, "0");
            preparedStmt.setString(3, "1");
            preparedStmt.execute();

            ResultSet rs = stmt.executeQuery("SELECT * FROM Users;");

            while (rs.next()) {
                int userId = rs.getInt("Id");
                String name = rs.getString("Name");
                int basketId = rs.getInt("BasketId");
                String userRankId = rs.getString("UserRankId");
                System.out.println("id = " + userId + "\nname = " + name + "\nBasketId = " + basketId + "\nuserRankId = " + userRankId + "\n\n");

                user = new User(userId, name, userRankId);
            }

            rs.close();
            stmt.close();
            c.close();

        } catch (Exception e) {
            System.err.print(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("\nImported data from database successfully");
        System.out.println("User name = " + user.getName());
    }

    public static void connect() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:/home/acer/PROGRAMMING/Java Repositories/onlineShop/AllteregoDB";
            conn = DriverManager.getConnection(url);

            String query  = "INSERT INTO Users(Name, BasketId, UserRankId)" +  "VALUES (?, ?, ?);";

            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, "Bill");
            preparedStmt.setString(2, "0");
            preparedStmt.setString(3, "1");
            preparedStmt.execute();



        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
