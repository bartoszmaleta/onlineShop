package org.example.model.list;

import org.example.model.Product;
import org.example.model.ProductOrder;

import java.util.List;

public class ProductsOrdersList {
    List<ProductOrder> productsOrders;

    public ProductsOrdersList(List<ProductsOrdersList> productsOrdersLists) {
        this.productsOrders = productsOrders;
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

}
