package org.example.Services.menu;

import org.example.DAO.DatabaseSqlite;

import java.sql.SQLException;
import java.util.Scanner;


//import database.SqlConnector;
//import database.basket.BasketDAO;
//import database.order.OrderDAO;
//import database.user.UserDAO;


public class AdminMenu extends DatabaseSqlite {
    public static void displayDeleteMode() {
        System.out.println();
        System.out.println("     ****************************************");
        System.out.println("     *              EDIT  MODE              *");
        System.out.println("     ****************************************");
        System.out.println("     What do you want to do ?");
        System.out.println("     (1) Delete product");
        System.out.println("     (2) Delete category");
        System.out.println("     (3) Delete order");
        System.out.println("     (4) Delete user\n");
        System.out.println("     (0) Back to main menu");
    }


    public static void displayAddMode() {
        System.out.println();
        System.out.println("     ****************************************");
        System.out.println("     *               ADD  MODE              *");
        System.out.println("     ****************************************");
        System.out.println("     What do you want to do ?");
        System.out.println("     (1) Add product");
        System.out.println("     (2) Add category");
        System.out.println("     (3) Add order");
        System.out.println("     (4) Add new user\n");
        System.out.println("     (0) Back to main menu");
    }

    public static void displayEditMode() {
        System.out.println();
        System.out.println("     ****************************************");
        System.out.println("     *              EDIT  MODE              *");
        System.out.println("     ****************************************");
        System.out.println("     What do you want to do ?");
        System.out.println("     (1) Edit product");
        System.out.println("     (2) Edit category");
        System.out.println("     (3) Edit order");
        System.out.println("     (4) Edit user\n");
        System.out.println("     (0) Back to main menu");
    }

    public static void displayMenu() {
        System.out.println();
        System.out.println("     ****************************************");
        System.out.println("     *               ADMIN  MENU            *");
        System.out.println("     ****************************************");
        System.out.println("     What do you want to do ?");
        System.out.println("     (1) Display products");
        System.out.println("     (2) Display categories");
        System.out.println("     (3) Display orders");
        System.out.println("     (4) Display users\n");
        System.out.println("     (5) Delete methods"); // user, products, categories,
        System.out.println("     (6) Edit methods"); // user, products, categories
        System.out.println("     (7) Add methods\n"); // user, products, categories
        System.out.println("     (8) STATS");
        System.out.println("     (9) ");
        System.out.println("     (0) Log out");
    }

    public void adminMenu() throws SQLException {
        boolean isRunning = true;

        displayMenu();

//            System.out.println("Your choice : ");
        Scanner in = new Scanner(System.in);
        int option = in.nextInt();


        switch (option) {
            case 1:
//                    CustomerMenu customerMenu = new CustomerMenu();
//                    customerMenu.customMenu();
                break;
            case 2:
//                    UserDAO userDAO = new UserDAO(sqlConnector);
//                    userDAO.viewUserTable();
//                    adminMenu();

                break;
            case 3:
//                    OrderDAO orderDAO = new OrderDAO(sqlConnector);
//                    orderDAO.viewOrderTable();
//                    adminMenu();
                break;
            case 4:
//                    BasketDAO basketDAO = new BasketDAO(sqlConnector);
//                    basketDAO.viewBasketTable();
//                    adminMenu();
                break;
            case 5:
//                    System.out.println("Which basket : ");
//
//                    int basketChoice = in.nextInt();
//                    BasketDAO basketDAO1 = new BasketDAO(sqlConnector);
//                    basketDAO1.viewBasketbyId(basketChoice);
                adminMenu();
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 0:
                isRunning = false;
                break;

        }
    }
}

