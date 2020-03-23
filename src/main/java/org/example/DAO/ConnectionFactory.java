package org.example.DAO;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static final String URL = "/home/acer/PROGRAMMING/Java Repositories/onlineShop/AllteregoDB";

    public static Connection getConnection() {
        try {
//            Connection conn = null;
//            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.out.println("Error connection to db!");
            e.printStackTrace();
        }

        return null;
    }


}
