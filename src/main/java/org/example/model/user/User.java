package org.example.model.user;

import org.example.DAO.ConnectionFactory;

public class User {

    private int id;
    private String name;
    private String login;
    private String password;
    private String email;
    private RoleEnum role;
    private int isAdmin;
    private int basketId;

    public User(String login, String password, String email, RoleEnum role) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.role = role;
    }
    public User() {

    }

    public int getBasketId() {
        return basketId;
    }

    public void setBasketId(int basketId) {
        this.basketId = basketId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public RoleEnum getRole() {
        return role;
    }

}
