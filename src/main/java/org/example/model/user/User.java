package org.example.model.user;

import org.example.DAO.ConnectionFactory;

public abstract class User {

    private int id;
    private String login;
    private String password;
    private String email;
    private RoleEnum role;

    public User(String login, String password, String email, RoleEnum role) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.role = role;
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
