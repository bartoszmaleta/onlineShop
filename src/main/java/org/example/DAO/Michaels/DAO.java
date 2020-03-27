package org.example.DAO.Michaels;

import org.example.model.user.SqlConnector;

import java.sql.*;

public abstract class DAO {

    protected String databaseUrl;
    protected String jdbcDriver;
    protected Connection c;
    protected Statement st;
    protected Connection con;
    protected Statement stmt = null;
    protected ResultSet rs = null;

    public void DatabaseSqlite() {
        this.databaseUrl = "/Users/mzi/Desktop/zADANIA/onlineShop/src/main/resources/shopDatabase";
        this.jdbcDriver = "org.sqlite.JDBC";
    }




    public void getConnection() {
        this.databaseUrl = databaseUrl;
        this.jdbcDriver = jdbcDriver;

        try {
            Class.forName(jdbcDriver);
            con = DriverManager.getConnection(databaseUrl);
        } catch (SQLException e) {
            System.out.println("Error! Can't connect with the database." );
        } catch (ClassNotFoundException e) {
            System.out.println("Error! JDBC Driver cannot be found!");
        }

    }

    public void connect() throws  SQLException {
        SqlConnector sqlConnector = new SqlConnector();
        sqlConnector.connectToDatabase();

        this.c = sqlConnector.getC();
        this.st = sqlConnector.getSt();
        System.out.println("Connection is successful !!!!!");
    }

    public void close() throws SQLException {
        st.close();
        c.close();
    }
}


