package org.example.model.list;

import org.example.model.Product;

import java.util.List;

public class ProductList {
    List<Product> products;

    public ProductList(List<Product> products) {
        this.products = products;
    }

    public void add (Product product) {
        this.products.add(product);
    }

    public void remove(Product product) {
        this.products.remove(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public boolean isIdCorrect(int id) {
        for (Product product : this.products) {
            if (product.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public Product getProductById(int id) {
        for (Product product : this.products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void removeQuantityOfProductById(int id, int quantity) {
        Product product = getProductById(id);
        product.setAmount(product.getAmount() - quantity);
    }

    public void updateProductsInDB() {
        for (Product product : this.products) {
            product.update();
        }
    }

    public String toString() {
        String productListString = "";
        for (Product product : this.products) {
            productListString += product.getName() + ", ";
        }

        return productListString;
    }

}
