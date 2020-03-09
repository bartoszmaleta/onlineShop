package org.example.model;

public class User {
    private int UserId;
    private String name;
    private Basket Basket;
    private String UserRank;

    public User(int userId, String name, String userRank) {
        UserId = userId;
        this.name = name;
        UserRank = userRank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public org.example.model.Basket getBasket() {
        return Basket;
    }

    public void setBasket(org.example.model.Basket basket) {
        Basket = basket;
    }

    public String getUserRank() {
        return UserRank;
    }

    public void setUserRank(String userRank) {
        UserRank = userRank;
    }
}
