package org.example.model.list;

import org.example.model.Product;
import org.example.model.ProductOrder;

import java.util.ArrayList;

public class ProductOrderList {
    private ArrayList<ProductOrder> productOrders;

    public ProductOrderList(ArrayList<ProductOrder> productOrders) {
        this.productOrders = productOrders;
    }

    public ArrayList<ProductOrder> getProductOrders() {
        return productOrders;
    }

    public void setProductOrders(ArrayList<ProductOrder> productOrders) {
        this.productOrders = productOrders;
    }

    public void add(ProductOrder productOrder) {
        this.productOrders.add(productOrder);
    }

    public void remove(ProductOrder productOrder) {
        this.productOrders.remove(productOrder);
    }

    public int calculateTotalValue (ProductList productsInOrder) {
        int totalValue = 0;
        for (Product product : productsInOrder.getProducts()) {
            totalValue += (product.getPrice() * product.getAmount());
        }
        return totalValue;
    }

    public String toString() {
        String productOrdersString = "";
        for (ProductOrder productOrder : this.productOrders) {
            productOrdersString += productOrder.toString();
        }
        return productOrdersString;
    }
}
