package org.example.DAO;

import org.example.model.Basket;
import org.example.model.Order;
import org.example.model.Product;
import org.example.model.ProductOrder;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class ProductsOrdersDAO {

    public void write(Basket basket, Order order) {
        HashMap<Product, Integer> mapOfBasket = basket.getProducts();

        for (Product product : mapOfBasket.keySet()) {
            try {
                Connection c = new DatabaseSqlite().getConnection();
                String queryToExecute = "INSERT INTO Products_Orders (OrderId, ProductId, Amount, Price)"
                        + " VALUES (?, ?, ?, ?)";

                PreparedStatement ps = c.prepareStatement(queryToExecute);
                ps.setInt(1, order.getId());
                ps.setInt(2, product.getId());
                ps.setInt(3, mapOfBasket.get(product));
                ps.setDouble(4, product.getPrice());

                ps.execute();

                c.close();

            } catch (SQLException e) {
                System.err.println("Error! Writing Basket to DB failed!");
                e.printStackTrace();
            }
        }
    }

    public ArrayList<ProductOrder> readProductsOfOrder() {
        return null;
    }

    public ArrayList<ProductOrder> readProductsOfOrder(Order order) {
        ArrayList<ProductOrder> listOfProductOrders = new ArrayList<>();

        try {
            DatabaseSqlite ds = new DatabaseSqlite();
            ResultSet rs = ds.executeQuery("SELECT * FROM Products_Orders WHERE \"OrderId\" LIKE '"+order.getId()+"';");

            while (rs.next()) {
                int id = rs.getInt("Id");
                int orderId = rs.getInt("OrderId");
                int productId = rs.getInt("ProductId");
                int amount = rs.getInt("Amount");
                double price = rs.getDouble("Price");

                listOfProductOrders.add(new ProductOrder(id, orderId, productId, amount, price));
            }
            rs.close();

        } catch (SQLException e) {
            System.err.println("Error! Reading ProductsOrders by Order failed!");
            e.printStackTrace();
        }
        return listOfProductOrders;
    }
}
