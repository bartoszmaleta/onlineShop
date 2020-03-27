package org.example.model.list;

import org.example.model.Product;
import org.example.model.ProductOrder;

import java.util.ArrayList;
import java.util.List;

public class ProductsOrdersList {
    ArrayList<ProductOrder> productsOrders;

    public ProductsOrdersList(ArrayList<ProductOrder> productsOrdersLists) {
        this.productsOrders = productsOrders;
    }

    public void add(ProductOrder orderItem) {
        this.productsOrders.add(orderItem);
    }

    public void addToProductsOrdersList (ProductOrder productsOrders ) {
        this.productsOrders.add(productsOrders);
    }

    public void removeFromProductsOrdersList (ProductOrder productsOrders ) {
        this.productsOrders.remove(productsOrders);
    }

    public String toString() {
        String productsOrdersListString = "";
        for (ProductOrder productsOrders : this.productsOrders) {
            productsOrdersListString += productsOrders.getId() + ", ";
        }

        return productsOrdersListString;
    }

    public ArrayList<ProductOrder> getProductsOrders() {
        return this.productsOrders;
    }
    public int calculateValue (ProductList products) {
        int totalPrice = 0;
        for (Product product : products.getProducts()) {
            totalPrice += (product.getPrice() * product.getAmount());
        }
        return totalPrice;
    }

}
