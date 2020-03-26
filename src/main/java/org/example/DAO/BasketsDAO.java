package org.example.DAO;

import org.example.model.Product;
import org.example.model.user.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

// Does not work

public class BasketsDAO {

    private int userId;

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

    public void create(int userId, Product product, int amount) {
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



}
