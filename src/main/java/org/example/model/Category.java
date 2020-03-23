package org.example.model;

import org.example.DAO.CategoryDAO;

public class Category {
    private int id;
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void writeToDB() {
        new CategoryDAO().write(this);
    }

    public void updateInDB() {
        new CategoryDAO().update(this);
    }
}
