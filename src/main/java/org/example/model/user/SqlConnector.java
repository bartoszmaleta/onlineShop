package org.example.model.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlConnector {

    private Connection c;
    private Statement st;

    public SqlConnector() {
        c = null;
        st = null;
    }

    public void connectToDatabase() {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("/Users/mzi/Desktop/zADANIA/onlineShop/src/main/resources/shopDatabase");
            st = c.createStatement();

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void disconnectFromDatabase() throws SQLException {
        st.close();
        c.close();
    }

    public Connection getC() {
        return c;
    }

    public Statement getSt() {
        return st;
    }

}
