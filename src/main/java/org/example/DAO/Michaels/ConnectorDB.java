package org.example.DAO.Michaels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectorDB {
    public static void connect() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:/Users/mzi/Desktop/zADANIA/onlineShop/src/main/resources/shopDatabase";
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

    public static void disconnect() {

    }
}
