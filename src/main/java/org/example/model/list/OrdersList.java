package org.example.model.list;

import org.example.model.Order;

import java.util.List;

public class OrdersList {
    List<Order> orders;

    public OrdersList(List<Order> orders) {
        this.orders = orders;
    }


    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
