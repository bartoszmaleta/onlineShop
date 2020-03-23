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
            System.out.println("Error! Cannot connect with the database." );
        } catch (ClassNotFoundException e) {
            System.out.println("Error! Cannot find JDBC Driver!");
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

    public void updateQuery(String sql) {
        DatabaseSqlite databaseSqlite = new DatabaseSqlite();
        this.con = databaseSqlite.getConnection();
        try {
            stmt = con.createStatement();
            stmt.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("Error! Cannot update query!");
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            con.close();
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error! Cannot close connection!");
            e.printStackTrace();
        }
    }
}
