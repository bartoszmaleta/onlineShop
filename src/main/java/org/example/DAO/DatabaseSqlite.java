package org.example.DAO;

import java.sql.*;

public class DatabaseSqlite {
    private String databaseUrl;
    private String jdbcDriver;

    public DatabaseSqlite() {
        this.databaseUrl = "/Users/mzi/Desktop/zADANIA/onlineShop/src/main/resources/shopDatabase";
        this.jdbcDriver = "org.sqlite.JDBC";
    }

    protected Connection con;
    protected Statement stmt = null;
    protected ResultSet rs = null;

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

    public void close() throws SQLException {
        try {
            stmt.close();
            con.close();
        }catch (SQLException e) {
            System.out.println("Error! Can't connect with the database." );
        }
    }

}
