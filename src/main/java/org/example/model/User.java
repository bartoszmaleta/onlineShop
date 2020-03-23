package org.example.model;

import org.example.DAO.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User {
    private int UserId;
    private String name;
    private Basket Basket;
    private String UserRank;

    public User(int userId, String name, String userRank) {
        UserId = userId;
        this.name = name;
        UserRank = userRank;
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public org.example.model.Basket getBasket() {
        return Basket;
    }

    public void setBasket(org.example.model.Basket basket) {
        Basket = basket;
    }

    public String getUserRank() {
        return UserRank;
    }

    public void setUserRank(String userRank) {
        UserRank = userRank;
    }

    public User getUser(int id) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Users;");

            if (rs.next()) {
                User user = new User();

                user.setName(rs.getString("name"));
                user.setUserRank(rs.getString("UserRankId"));

                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
