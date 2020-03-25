package org.example.model;

import java.time.LocalDate;

public class Order {
    private int id;
    private int userId;
    private String status;
    private LocalDate date = LocalDate.now();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStatusAsOrdered() {
        this.status = "Ordered";
    }

    public void setStatusAsPaid() {
        this.status = "Paid";
    }

    public void setStatusOnTheWay() {
        this.status = "On the way";
    }

    public void setStatusAsDelivered() {
        this.status = "Delivered";
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
