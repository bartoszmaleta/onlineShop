package org.example.view;

import com.jakewharton.fliptables.FlipTableConverters;
import org.example.DAO.DatabaseSqlite;
import org.example.Services.TerminalManager;
import org.example.model.Category;
import org.example.model.Product;
import org.example.model.list.CategoryList;
import org.example.model.list.ProductList;
import org.example.model.user.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TableView {


    public static void displayProducts(User user) {

        // TODO: display ProductList logo!!!!

        String query = "SELECT * FROM Products;";
        try {
            System.out.println("\n\n\n");
//            DatabaseSqlite ds = new DatabaseSqlite();
//            ResultSet rs = ds.executeQuery(query);

            String lineAbove = "┌" + TerminalView.repeatString("-", 94) + "┐";
            System.out.println(lineAbove);

            String idTitle = "Id";
            String nameTitle = "Name";
            String priceTitle = "Price";
            String amountTitle = "Amount";
            String isAvailableTitle = "Availability";
            String categoryTitle = "Category";
            String ratingTitle = "Rating";

            System.out.format("| %4s | %15s | %10s | %6s | %18s | %13s | %10s |\n"
                    , idTitle, nameTitle, priceTitle, amountTitle, isAvailableTitle
                    , categoryTitle, ratingTitle);

            String lineAfterTitles = "├" + TerminalView.repeatString("-", 94) + "┤";
            System.out.println(lineAfterTitles);

            ResultSet rs = new DatabaseSqlite().executeQuery(query);
            while (rs.next()) {

                int idInt = rs.getInt("Id");
                String id = String.valueOf(idInt);

                String name = rs.getString("Name");

                double priceDouble = rs.getDouble("Price");
                String price = String.valueOf(priceDouble);

                int amountInt = rs.getInt("Amount");
                String amount = String.valueOf(amountInt);

                boolean isAvailableBool = (rs.getInt("IsAvailable") != 0);
                String isAvailable = convertIsAvailableToString(isAvailableBool);

                // TODO: Optimilize!
                int categoryInt = (rs.getInt("CategoryId"));
                String category = new CategoryList().getCategoryNameById(categoryInt);

                int ratingInt = rs.getInt("Rating");
                String rating = String.valueOf(ratingInt);

                if (user.getIsAdmin() == 1) {
                    boolean isInStorage = (rs.getInt("IsInStorage") != 0);
                }
//                                      id      name    price  amou   avail   categ   rating
//                String productTable = "|%1$-3s|%2$-20s|%3$-8s|%4$-6s|%5$-18s|%6$-15s|%7$-4s|\n";
//                System.out.printf(productTable, name, id, price, amount, isAvailable, category, rating);

                System.out.format("| %4s | %15s | %10s | %6s | %18s | %13s | %10s |\n", id, name, price, amount, isAvailable, category, rating);
            }
            String lineBelow = "└" + TerminalView.repeatString("-", 94) + "┘";
            System.out.println(lineBelow);
        } catch (SQLException e) {
            System.err.println("Error! Displaying all products failed! ");
            e.printStackTrace();
        }
    }

    public static String convertIsAvailableToString(boolean isAvailableBool) {
        String convertedString = "";

        if (isAvailableBool == true) {
            return convertedString = "Available";
        } else {
            return convertedString = "Not available";
        }
    }

    public String convertIsInStorageToString(boolean isInStorageBool) {
        String convertedString = "";

        if (isInStorageBool == true) {
            return convertedString = "In storage";
        } else {
            return convertedString = "Not in storage";
        }
    }


//    public static void displayProductTable(ProductList productList, User user) {
//        List<Product> products = productList.getProducts();
//
//        int id;
//        String productName;
//        double price;
//        int amount;
//        boolean isAvailable;
//        int category;
//        int rating;
//
//        for (Product product : products) {
//
//        }
//
//    }

//    public void displayPlayerStatistics() {
////        TODO:
//        String[] headers = {"Remaining Cards", "Coins", "Experience", "Level", "    ", "Cards in pot"};
//        Object[][] data = {
//                {this.health, this.coins, this.experience, this.level, "    ", potCardsToString()}
//        };
//        System.out.println(FlipTableConverters.fromObjects(headers, data));
//    }
}
