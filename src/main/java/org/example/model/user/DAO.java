package org.example.model.user;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DAO {
    protected Connection c;
    protected Statement st;

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
