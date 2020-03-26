package org.example.model.list;

import org.example.DAO.CategoryDAO;
import org.example.model.Category;

import java.util.ArrayList;

public class CategoryList {
    private ArrayList<Category> categoryList;

    public CategoryList() {
        this.categoryList = new CategoryDAO().readCategoryList();
    }

    public ArrayList<Category> getCategoryList() {
        return this.categoryList;
    }

    public Category getCategoryById(int id) {
        for (Category category : this.categoryList) {
            if (category.getId() == id) {
                return category;
            }
        }
        return null;
    }

    public boolean isCategoryValid(int id) {
        for (Category category : this.categoryList) {
            if (category.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public String getCategoryNameById (int id) {
        for (Category category : this.categoryList) {
            if (category.getId() == id) {
                return category.getName();
            }
        }
        return null;
    }

    public String toString() {
        String categoryListString = "";
        for (Category category : this.categoryList) {
            categoryListString += category.toString() + "\n";
        }
        return categoryListString;
    }
}
