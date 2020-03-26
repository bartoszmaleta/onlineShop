package org.example.controller;

import org.example.DAO.OrdersDAO;
import org.example.DAO.ProductsDAO;
import org.example.Services.TerminalManager;
import org.example.Services.menu.CustomerMenu;
import org.example.model.Basket;
import org.example.model.list.OrderList;
import org.example.model.list.ProductList;
import org.example.model.user.User;
import org.example.view.TableView;
import org.example.view.TerminalView;

import javax.swing.text.View;
import java.util.Scanner;

public class AdminController {
    private User user;
    private Basket basket;
    private ProductList productList;
    private OrderList orderList;

    public AdminController(User user) {
        this.user = user;
        this.basket = new Basket(user.getId());
        this.productList = new ProductList(new ProductsDAO().readAllProducts());
        this.orderList = new OrderList(new OrdersDAO().readAllOrders());
        this.basket.setBasketFromDB();
        this.basket.updateProductList(this.productList);
    }

    public void init() {
        boolean isRunning = true;

        Scanner scanner = new Scanner(System.in);

        while (isRunning) {
            TerminalManager.clearScreen();
            CustomerMenu.showCustomerMenu();

            int choice = TerminalManager.askForInt("");

            switch (choice) {
                case 1:
//                    TerminalView.clearScreen();
//                    TableView.displayProductTable(this.productList, this.user);
//                    TerminalView.pressAnyKeyToContinue();
                    break;
                case 2:
//                    TableView.displayProductsFromSpecificCategory();
//                    TerminalView.pressAnyKeyToContinue();
                    break;
                case 3:
//                    TerminalView.clearScreen();
//                    TableView.displayProductTable(this.productList, this.user);
//                    addProductToDatabase();
//                    TerminalView.pressAnyKeyToContinue();
                    break;
                case 4:
//                    TableView.displayBasket(this.basket);
//                    TerminalView.pressAnyKeyToContinue();
//                    break;
                case 5:
//                    TableView.displayBasket(this.basket);
//                    editBasket();
//                    TerminalView.pressAnyKeyToContinue();
                    break;
                case 6:
//                    saveBasket();
                    break;
                case 7:
//                    placeOrder();
                    break;
                case 8:
//                    TableView.displayArchivedOrders(this.orderList, this.productList, this.user);
//                    TerminalView.pressAnyKeyToContinue();
                    break;
                case 0:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Wrong input!");
            }
        }
    }

}
