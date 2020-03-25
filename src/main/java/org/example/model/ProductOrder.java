package org.example.model;

import java.math.BigDecimal;

public class ProductOrder {
    private int id;
    private int orderId;
    private int itemId;
    private int amount;
    private BigDecimal price;

    public ProductOrder(int id, int orderId, int itemId, int amount, BigDecimal price) {
        this.id = id;
        this.orderId = orderId;
        this.itemId = itemId;
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

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", orderId='" + orderId + '\'' +
                ", itemId=" + itemId +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }
}
