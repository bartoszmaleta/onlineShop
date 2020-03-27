package org.example.model;

import org.example.DAO.ProductsDAO;

public class Product {

    private int id;
    private String name;
    private double price;
    private int amount;
    private boolean isAvailable;
    private int category;
    private boolean isInStorage; // user does not see
    private int rating;

    public Product(String name, double price, int amount, boolean isAvailable, int category, boolean isInStorage, int rating) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.isAvailable = isAvailable;
        this.category = category;
        this.isInStorage = isInStorage;
        this.rating = rating;
    }

    public void update() {
        new ProductsDAO().update(this);
    }

    public void delete() {
        new ProductsDAO().delete(this);
    }
    public void write() {
        new ProductsDAO().write(this);
    }

    public String toString() {
        return "Product{" +
                "id= " + id
                + ", name= " + name
                + ", price= " + price
                + ", amount= " + amount
                + ", isAvailable= " + isAvailable
                + ", category= " + category
                + ", isInStorage= " + isInStorage
                + ", rating= " + rating
                + '\'' +
                '}';
    }

    // equals??
    // hashCode??

    // GETTERS AND SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public boolean isInStorage() {
        return isInStorage;
    }

    public void setInStorage(boolean inStorage) {
        isInStorage = inStorage;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
