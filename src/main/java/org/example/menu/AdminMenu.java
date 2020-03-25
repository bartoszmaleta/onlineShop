package org.example.menu;

import org.example.DAO.DatabaseSqlite;

import java.sql.SQLException;
import java.util.Scanner;



//import database.SqlConnector;
//import database.basket.BasketDAO;
//import database.order.OrderDAO;
//import database.user.UserDAO;

import java.sql.SQLException;
import java.util.Scanner;

    public class AdminMenu extends DatabaseSqlite {


        public void adminMenu() throws SQLException {
            boolean isRunning = true;

            System.out.println();
            System.out.println("     ****************************************");
            System.out.println("     *               ADMIN  MENU            *");
            System.out.println("     ****************************************");
            System.out.println("     What do you want to do ?");
            System.out.println("     (1) Customer Menu");
            System.out.println("     (2) View Users");
            System.out.println("     (3) View Orders");
            System.out.println("     (4) View all Baskets");
            System.out.println("     (5) View basket");
            System.out.println("     (6) Customer Menu");
            System.out.println("     (7) Customer Menu");
            System.out.println("     (8) Customer Menu");
            System.out.println("     (9) Customer Menu");
            System.out.println("     (0) Exit program");
            System.out.println();
            System.out.println("Your choice : ");
            Scanner in = new Scanner(System.in);
            int option = in.nextInt();


            switch(option)

            {
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

