package org.example.DAO;

import org.example.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryDAO {
    public void write(Category category) {
        try (Connection c = new DatabaseSqlite().getConnection()) {
            String queryToExecute = "INSERT INTO Categories (Name)" + " VALUES (?)";

            PreparedStatement preparedStatement = c.prepareStatement(queryToExecute);
            preparedStatement.setString(1, category.getName());

            preparedStatement.execute();
        } catch (SQLException e) {
            System.err.println("Error! Writing category to DB failed");
            e.printStackTrace();
        }
    }


    public void update(Category category) {
        try (Connection c = new DatabaseSqlite().getConnection()) {
            String queryToExecute = "UPDATE Categories SET Name = ? WHERE Id = ?";

            PreparedStatement preparedStatement = c.prepareStatement(queryToExecute);
            preparedStatement.setString(1, category.getName());
            preparedStatement.setInt(2, category.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error! Updating category in DB failed");
            e.printStackTrace();
        }
    }

    public ArrayList<Category> readCategoryList() {
        ArrayList<Category> listOfCategory = new ArrayList<>();
        try (ResultSet rs = new DatabaseSqlite().executeQuery("SELECT * FROM Categories;")) {
            while (rs.next()) {
                int id = rs.getInt("Id");
                String name = rs.getString("Name");
                Category category = new Category(name);
                category.setId(id);
                listOfCategory.add(category);
            }
        } catch (SQLException e) {
            System.err.println("Error! Reading Categories from DB failed");
            e.printStackTrace();
        }
        return listOfCategory;
    }
}
