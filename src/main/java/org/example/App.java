package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        connectWithDB();

    }

    private static void connectWithDB() {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:AllteregoDB");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Users");

            while (rs.next()) {
                String name = rs.getString("name");
                int basketId = rs.getInt("BasketId");
                System.out.println("name = " + name + "\nBasketId = " + basketId);

            }

            rs.close();
            stmt.close();
            c.close();

        } catch (Exception e) {
            System.err.print(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Imported data from database successfully");
    }


}
