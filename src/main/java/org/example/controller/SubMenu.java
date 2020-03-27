package org.example.controller;

import org.example.DAO.ProductsDAO;
import org.example.Services.menu.AdminMenu;
import org.example.Services.menu.LoginMenu;
import org.example.model.Product;
import org.example.view.TerminalView;

import java.sql.SQLException;
import java.util.Scanner;

public class SubMenu {
    Scanner scanner = new Scanner(System.in);


    public void printSubMenu() {

        System.out.println("*********************************************************");
        System.out.println("1. Add: ");
        System.out.println("2. Edit: ");
        System.out.println("3. Remove: ");
        System.out.println("4. View: ");
        System.out.println("0. Go to Admin menu: ");
    }

    public void actionSubMenu() throws SQLException {

            boolean isRunning = true;

                TerminalView.clearScreen();
                printSubMenu();

                ProductsDAO productsDAO = new ProductsDAO();
                productsDAO.viewProductTable();

        System.out.println("Your choice: ");
        int choice = scanner.nextInt();

                switch (choice) {
                    case 1:

                       productsDAO.write(new Product("soap",10.5,1,true,1,true,5));
                        break;
                    case 2:
                       // Edit
                        break;
                    case 3:
                        // Remove
                        break;
                    case 4:

                        productsDAO.viewProductTable();
                        break;
                    case 0:
                        AdminMenu adminMenu = new AdminMenu();
                        adminMenu.displayAdminMenu();
                        //isRunning = false;
                        break;

                }

    }
}
