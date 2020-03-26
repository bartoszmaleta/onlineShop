package org.example.controller;

import org.example.DAO.BasketsDAO;
import org.example.DAO.OrdersDAO;
import org.example.DAO.ProductsDAO;
import org.example.DAO.ProductsOrdersDAO;
import org.example.Services.TerminalManager;
import org.example.Services.menu.CustomerMenu;
import org.example.model.Basket;
import org.example.model.Order;
import org.example.model.ProductOrder;
import org.example.model.list.OrderList;
import org.example.model.list.ProductList;
import org.example.model.user.User;
import org.example.view.TableView;
import org.example.view.TerminalView;

import javax.swing.text.View;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CustomerController {
    private User user;
    private Basket basket;
    private ProductList productList;
    private OrderList orderList;

    public CustomerController(User user) {
        this.user = user;
        this.basket = new Basket(user.getId());
        this.productList = new ProductList(new ProductsDAO().readAllProducts());
        this.orderList = new OrderList(new OrdersDAO().readAllOrders());


        // TODO:
        this.basket.setBasketFromDB();
        this.basket.updateProductList(this.productList);
    }

    public void init() throws FileNotFoundException {
        boolean isRunning = true;

        Scanner scanner = new Scanner(System.in);

        while (isRunning) {
            TerminalManager.clearScreen();
            CustomerMenu.showCustomerMenu();

            int choice = TerminalManager.askForInt("");

            switch (choice) {
                case 1:
                    TerminalView.clearScreen();
//                    TableView.displayProductTable(this.productList, this.user);
                    TableView.displayProducts(this.user);
//                    TerminalView.pressAnyKeyToContinue();
                    break;
                case 2:
//                    TableView.displayProductsFromSpecificCategory();
//                    TerminalView.pressAnyKeyToContinue();
                    break;
                case 3:
                    TerminalView.clearScreen();
//                    TableView.displayProductTable(this.productList, this.user);
                    TableView.displayProducts(this.user);
                    addProductToBasket();
                    TerminalView.pressAnyKeyToContinue();
                    break;
                case 4:
//                    TableView.printBasket(this.basket); // Old
                    TableView.printBasketPretty(this.basket);
                    TerminalView.pressAnyKeyToContinue();
                    break;
                case 5:
//                    TableView.displayBasket(this.basket);
//                    editBasket();
//                    TerminalView.pressAnyKeyToContinue();
                    break;
                case 6:
//                    saveBasket();
                    break;
                case 7:
                    placeOrder();
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

    private void placeOrder() {
        System.out.println("place order here");
        if(!basket.getProducts().isEmpty()) {

            // Save to DB
            new OrdersDAO().write(this.user);
            this.orderList.setOrders(new OrdersDAO().readOrdersByUser(this.user));

            // Order from the end
            Order newOrder = new OrdersDAO().readOrdersByUser(user).get(orderList.getOrders().size() - 1);

            // Save to ProductsOrder
            new ProductsOrdersDAO().write(basket, newOrder);

            // update products in DB
            this.productList.updateProductsInDB();

            // clear Basket
            basket.getProducts().clear();

            // delete basket from DB
            new BasketsDAO().delete(user);

            // update user productList
            this.productList = new ProductList(new ProductsDAO().readAllProducts());

            System.out.println("Good job! You just have placed order!");

        } else {
            System.out.println("Basket empty! At first put something to basket!");
        }
    }

    public void addProductToBasket() {
        boolean isRunnig = true;
        while (isRunnig) {
            int productId = TerminalManager.askForInt("Choose index of product: ");
            boolean isProductIdCorrect = productList.isIdCorrect(productId) && productList.getProductById(productId).isInStorage();

            if (isProductIdCorrect) {
                int quantity = TerminalManager.askForInt("How many of this product You want? ");
                if (quantity <= 0) {
                    isRunnig = false;
                }
                if (quantity > 0 && quantity <= productList.getProductById(productId).getAmount()
                        && productList.getProductById(productId).isAvailable()) {
                    basket.addProductToBasket(productId, this.productList.getProducts(), quantity);
                    this.productList.removeQuantityOfProductById(productId, quantity);
                    isRunnig = false;
                } else {
                    System.out.println("Wrong input!");  // wrong amount or availability
                }
            } else {
                System.out.println("Wrong input!"); // wrong id
            }
        }
    }
}
