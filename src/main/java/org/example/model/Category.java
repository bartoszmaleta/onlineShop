package org.example.model;

import org.example.DAO.CategoryDAO;

public class Category {
    private int id;
    private String name;
    private boolean isAvailable;

    public Category(String name) {
        this.name = name;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public void setAvailable() {
        isAvailable = true;
    }
    public void setUnavailable() {
        isAvailable = false;
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

    public String toString() {
        String categoryString = "";
        categoryString += this.id + ", ";
        categoryString += this.name + ", ";
        categoryString += this.isAvailable;
        return categoryString;
    }
}
