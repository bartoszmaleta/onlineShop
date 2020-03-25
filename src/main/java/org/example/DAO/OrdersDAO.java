package org.example.DAO;

import org.example.model.Order;
import org.example.model.user.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class OrdersDAO {

    public void write(User user) {
        Order newOrder = new Order();
        newOrder.setStatusAsOrdered();

        try {
            Connection c = new DatabaseSqlite().getConnection();

            String queryToExecute = "INSERT INTO Orders (UserId, Status, Date)"
                    + " VALUES (?, ?, ?)";

            PreparedStatement ps = c.prepareStatement(queryToExecute);

            ps.setInt(1, user.getId());
            ps.setString(2, newOrder.getStatus());
            ps.setString(3, newOrder.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

            ps.execute();

            c.close();
        } catch (SQLException e) {
            System.err.println("Error! Writing orderd to DB failed!");
            e.printStackTrace();
        }
    }

    public void update(User user, Order order) {
        // TODO: not sure!
        try {
            Connection c = new DatabaseSqlite().getConnection();
            // TODO: not sure!
            String queryToExecute = "UPDATE Orders SET Status = ?, Date = ? WHERE Id = ? AND UserId = ?";
            PreparedStatement ps = c.prepareStatement(queryToExecute);

            ps.setString(1, order.getStatus());
            ps.setString(2, order.getDate().toString());
            ps.setInt(3, order.getId());
            ps.setInt(4, user.getId());

            ps.executeUpdate();

            c.close();

        } catch (SQLException e) {
            System.err.println("Error! Updating order failed");
            e.printStackTrace();
        }
    }


    public ArrayList<Order> readOrdersByUser(User user) {
        ArrayList<Order> listOfOrders = new ArrayList<>();
        DatabaseSqlite ds = new DatabaseSqlite();

        try {
            ResultSet rs = ds.executeQuery("SELECT * FROM Orders WHERE \"UserId\" LIKE '" + user.getId() + "';");
            while (rs.next()) {
                int id = rs.getInt("id");
                int userId = rs.getInt("UserId");
                String status = rs.getString("Status");
                String date = rs.getString("Date");

                Order newOrder = new Order();
                newOrder.setId(id);
                newOrder.setUserId(userId);
                newOrder.setStatus(status);

                listOfOrders.add(newOrder);
            }
        } catch (SQLException e) {
            System.err.println("Error! Reading all orders of user failed!");
            e.printStackTrace();
        }
        return listOfOrders;
    }

    public ArrayList<Order> readAllOrders() {
        ArrayList<Order> listOfAllOrders = new ArrayList<>();
        DatabaseSqlite ds = new DatabaseSqlite();

        try (ResultSet rs = ds.executeQuery("SELECT * FROM ORDERS;")) {
            while (rs.next()) {
                int id = rs.getInt("Id");
                int userId = rs.getInt("UserId");
                String status = rs.getString("Status");
                String date = rs.getString("Date"); // ???

                Order newOrder = new Order();
                newOrder.setId(id);
                newOrder.setUserId(userId);
                newOrder.setStatus(status);
                listOfAllOrders.add(newOrder);
            }
            ds.close();

        } catch (SQLException e) {
            System.err.println("Error! Reading all orders failed!");
            e.printStackTrace();
        }
        return listOfAllOrders;
    }

}
