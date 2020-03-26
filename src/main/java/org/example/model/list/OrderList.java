package org.example.model.list;

import org.example.model.Order;

import java.util.ArrayList;

public class OrderList {
    private ArrayList<Order> orders;

    public OrderList(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
}
