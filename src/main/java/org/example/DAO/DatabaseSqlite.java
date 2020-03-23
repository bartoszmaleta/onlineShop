package org.example.DAO;

import java.sql.*;

public class DatabaseSqlite {
    private String databaseUrl;
    private String jdbcDriver;

    public DatabaseSqlite() {
        this.databaseUrl = "src/main/resources/AllteregoDB";
        this.jdbcDriver = "org.sqlite.JDBC";
    }

    private Connection con;
    private Statement stmt = null;
    private ResultSet rs = null;

    public Connection getConnection() {
        try {
            Class.forName(jdbcDriver);
            con = DriverManager.getConnection(databaseUrl);
        } catch (SQLException e) {
            System.out.println("Error! Can't connect with the database." );
        } catch (ClassNotFoundException e) {
            System.out.println("Error! JDBC Driver cannot be found!");
        }

        return con;
    }

    public ResultSet executeQuery(String sql) {
        DatabaseSqlite dbsqlite = new DatabaseSqlite();
        this.con = dbsqlite.getConnection();
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("Error! Cannot execute query!");
            e.printStackTrace();
        }
        return rs;
    }
}
