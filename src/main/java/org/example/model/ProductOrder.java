package org.example.model;

public class ProductOrder {
    private int id;
    private int orderId;
    private int productId;
    private int amount;
    private double price;

    public ProductOrder(int id, int orderId, int productId, int amount, double price) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.amount = amount;
        this.price = price;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", orderId='" + orderId +
                ", itemId=" + productId +
                ", amount=" + amount +
                ", price=" + price +
                "}\n";
    }
}
