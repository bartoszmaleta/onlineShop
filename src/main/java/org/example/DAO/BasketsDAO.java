package org.example.DAO;

import org.example.model.Product;
import org.example.model.user.SqlConnector;
import org.example.model.user.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

// Does not work

public class BasketsDAO {

    private int userId;

    public void write(int userId, Product product, int amount) {
        try (Connection c = new DatabaseSqlite().getConnection())
        {
            String query = " INSERT INTO Baskets (UserId, ProductId, Amount)"
                    + " values (?, ?, ?)";

            PreparedStatement preparedStmt = c.prepareStatement(query);

            preparedStmt.setInt(1, userId);
            preparedStmt.setInt(2, product.getId());
            preparedStmt.setInt(3, amount);

            preparedStmt.execute();

        }
        catch (SQLException e)
        {
            System.err.println("Error! Writing Basket to DB failed! ");
            System.err.println(e.getMessage());
        }
    }

    public ArrayList<HashMap<Product, Integer>> readAllBasketsFromDB() {
        HashMap<Product, Integer> mapOfBasket = new HashMap<>();
        ArrayList<HashMap<Product, Integer>> listOfBaskets = new ArrayList<>();
        try {
            DatabaseSqlite ds = new DatabaseSqlite();
            ResultSet res = ds.executeQuery("SELECT UserId, ProductId, Amount FROM Baskets WHERE UserId=" + this.userId + ";");

            while (res.next()) {

                int amountB = res.getInt("Amount");
                int productID = res.getInt("ProductId");

                ResultSet rs = ds.executeQuery("SELECT * FROM PRODUCTS WHERE Id=" + productID + ";");

                while (rs.next()) {
                    int id = rs.getInt("Id");
                    String name = rs.getString("Name");
                    float price = rs.getFloat("Price");
                    int amount = rs.getInt("Amount");
                    boolean isAvailable = (rs.getInt("IsAvailable") != 0);
                    int category = (rs.getInt("CategoryId"));
                    boolean isInStorage = (rs.getInt("IsInStorage") != 0);
                    int rating = rs.getInt("Rating");
                    Product product = new Product(name, price, amount, isAvailable, category, isInStorage, rating);
                    product.setId(id);
                    mapOfBasket.put(product,amountB);
                }
                listOfBaskets.add(mapOfBasket);
                ds.close();
            }

        } catch (Exception e) {
            System.err.println("Error! Reading all baskets from DB failed! ");
            System.exit(0);
        }
        return listOfBaskets;
    }

    public void delete(User user) {
        try (Connection c = new DatabaseSqlite().getConnection())
        {

            PreparedStatement st = c.prepareStatement("DELETE FROM Baskets WHERE UserId = " + user.getId() + ";");
            st.executeUpdate();
        }
        catch(SQLException e)
        {

            System.err.println("Error! Deleting Basket from DB failed!");
            System.out.println(e);
        }
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public static class ConnectionFactory {
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


        public abstract static class DAO {

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


    }
}
