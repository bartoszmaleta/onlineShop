package org.example.controller;

import org.example.DAO.UsersDAO;
import org.example.Services.menu.LoginMenu;
import org.example.model.user.User;
import org.example.view.TerminalView;

import java.util.Scanner;

public class LoggingController {
    Scanner scanner = new Scanner(System.in);

    public void init() {
        boolean isRunning = true;
        while (isRunning) {
            // clearScreen()
            TerminalView.clearScreen();
            LoginMenu.display();
            // showMenu = logmenu!!!

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    loggingUser();
                    break;
                case 2:
//                    createNewAccount();
                    break;
                case 0:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Wrong input!");
            }
        }
    }

    public void loggingUser(){
        Scanner scanner = new Scanner(System.in);

        TerminalView.printString("User name: ");
        String name = scanner.nextLine();

        TerminalView.printString("User password: ");
        String password = scanner.nextLine();

        if (new UsersDAO().readUserByNameAndPassoword(name,password).getName()==null){
            TerminalView.printString("Wrong username or password.");
        } else {
            User user = new UsersDAO().readUserByNameAndPassoword(name,password);
            if (user.getIsAdmin() == 1) {
                // TODO:
//                AdminController adminController = new AdminController(user);
//                adminController.run();
            } else {
                CustomerController customerController = new CustomerController(user);
                customerController.init();
            }
        }
    }
}

