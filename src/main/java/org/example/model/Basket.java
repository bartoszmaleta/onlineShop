package org.example.model;

import org.example.DAO.BasketsDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Basket {
    private int userId;
    private HashMap<Product, Integer> products;

    public Basket (int userId) {
        this.userId = userId;
        this.products = new HashMap<>();
    }


    public void addProductToBasket(int productId, List<Product> productList, int amount) {
        for (Product product : productList) {
            if (productId == product.getId()) {
                if (products.containsKey(product)) {
                    int counter = products.get(product);
                    counter += amount;
                    products.replace(product, counter);
                } else {
                    products.put(product, amount);
                }
            }
        }
    }

    public Double calculateTotalValue() {
        Double totalValue = 0.0;

        for (Map.Entry<Product, Integer> keyValueSet : this.products.entrySet()) {
            Product keyOfProduct = keyValueSet.getKey();
            Integer valueOfQuantityOfProduct = keyValueSet.getValue();

            totalValue += keyOfProduct.getPrice() * valueOfQuantityOfProduct;
        }
        return totalValue;
    }

    // TODO: ASAP!!!!!
    public void updateProductList(ProductList productList) {

    }

    // TODO: later
    public void updateBasketInDB() {
        //        BasketsDAO basketsDAO = new BasketsDAO();
    }

    // TODO: later
    public void setBasketFromDB() {
//

//        BasketsDAO basketsDAO = new BasketsDAO();
//        basketsDAO.setUserId(this.userId);
//        this.basket = basketsDAO.read();
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public HashMap<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(HashMap<Product, Integer> products) {
        this.products = products;
    }

    public String toString() {
        return "Basket{" +
                "userId=" + userId +
                ", products=" + products +
                '}';
    }
}
