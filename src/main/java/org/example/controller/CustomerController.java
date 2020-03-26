package org.example.controller;

import org.example.DAO.OrdersDAO;
import org.example.DAO.ProductsDAO;
import org.example.model.Basket;
import org.example.model.list.OrderList;
import org.example.model.list.ProductList;
import org.example.model.user.User;

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

    public void run() {
        boolean isRunning = true;

        Scanner scanner = new Scanner(System.in);

        while (isRunning) {

        }
    }
}
