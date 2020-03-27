package org.example.DAO;

import org.example.DAO.Michaels.DAO;
import org.example.model.Product;
import org.example.model.user.RoleIdException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductsDAO extends DAO {

    private int id;
    private String name;
    private double price;
    private int amount;
    private boolean isAvailable;
    private int category;
    private boolean isInStorage;
    private int rating;


    public void viewProductTable() throws SQLException {
        connect();
        System.out.println("---------- PRODUCT TABLE ------------------");


        String SELECT_SQL = "SELECT * FROM products;";

        try {
            ResultSet rs = st.executeQuery(SELECT_SQL);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                float price = rs.getFloat("price");
                int isAvailable = rs.getInt("IsAvailable");
                int categoryId = rs.getInt("categoryId");
                int isOnStorage = rs.getInt("isOnStorage");
                int rating = rs.getInt("rating");



                String format = "|%1$-3s|%2$-18s|%3$-16s|%4$-30s|%5$-9s|%6$-6s|%7$-6s|\n";
                System.out.printf(format, id, name, price, isAvailable, categoryId, isOnStorage, rating);
            }
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void write(Product product) {
        try (Connection c = new DatabaseSqlite().getConnection()) {
            String query = "INSERT INTO Products (Name, Price, Amount, IsAvailable, CategoryId, IsInStorage, Rating)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStmt = c.prepareStatement(query);
            preparedStmt.setString(1, product.getName());
            preparedStmt.setDouble(2, product.getPrice());
            preparedStmt.setInt(3, product.getAmount());
            preparedStmt.setInt(4, product.isAvailable() ? 1 : 0);
            preparedStmt.setInt(5, product.getCategory());
            preparedStmt.setInt(6, product.isInStorage() ? 1 : 0);
            preparedStmt.setInt(7, product.getRating());
            preparedStmt.execute();

        } catch (SQLException e) {
            System.err.println("Error! Addidng product to DB failed!");
            e.printStackTrace();
        }
    }

    public ArrayList<Product> readAllProducts() {
        ArrayList<Product> listOfProdcuts = new ArrayList<>();

        try {
            ResultSet rs = new DatabaseSqlite().executeQuery("SELECT * FROM Products;");
            while (rs.next()) {
                int id = rs.getInt("Id");
                String name = rs.getString("Name");
                double price = rs.getDouble("Price");
                int amount = rs.getInt("Amount");
                boolean isAvailable = (rs.getInt("IsAvailable") != 0);
                int category = (rs.getInt("CategoryId"));
                boolean isInStorage = (rs.getInt("IsInStorage") != 0);
                int rating = rs.getInt("Rating");

                Product product = new Product(name, price, amount, isAvailable, category, isInStorage, rating);
                product.setId(id);
                listOfProdcuts.add(product);
            }
        } catch (Exception e) {
            System.err.println("Error! Reading all products from DB failed! ");
            e.printStackTrace();
        }

        return listOfProdcuts;
    }

    public void update(Product product) {

        ArrayList<Product> list = new ArrayList<Product>();
        int available = product.isAvailable() ?  1 : 0;
        int inStorage = product.isInStorage() ? 1 : 0;
        try (Connection c = new DatabaseSqlite().getConnection())
        {
            String query = "UPDATE Products SET Name = ?, Price = ?, Amount= ? , IsAvailable = ? , CategoryId = ?, IsInStorage = ?, Rating = ? WHERE id = ?";
            PreparedStatement preparedStmt = c.prepareStatement(query);

            preparedStmt.setString(1, product.getName());
            preparedStmt.setDouble(2, product.getPrice());
            preparedStmt.setInt(3, product.getAmount());
            preparedStmt.setInt(4, available);
            preparedStmt.setInt(5, product.getCategory());
            preparedStmt.setInt(6, inStorage);
            preparedStmt.setInt(7, product.getRating());
            preparedStmt.setInt(8, product.getId());

            preparedStmt.executeUpdate();

        }
        catch (SQLException e)
        {
            System.err.println("Error! Updating product failed!");
            e.printStackTrace();
        }
    }

    public void delete(Product product) {
        try {
            Connection c = new DatabaseSqlite().getConnection();
            PreparedStatement st = c.prepareStatement("DELETE FROM Products WHERE Id = " + product.getId() + ";");
            st.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error! Deleting product failed!");
            e.printStackTrace();
        }
    }
}
