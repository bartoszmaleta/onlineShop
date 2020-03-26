package org.example.model.list;

import org.example.model.Category;
import org.example.model.Product;

import java.util.List;

public class CategoryList {
    List<Category> categories;

    public CategoryList(List<Category> categories) {
        this.categories = categories;
    }

    public Category getCategoryById(int id) {
        for (Category category : categories) {
            if (category.getId() == id) {
                return category;
            }
        }
        return null;
    }

    public Category getCategoryByName(String name) {
        for (Category category : categories) {
            if (category.getName() == name) {
                return category;
            }
        }
        return null;
    }

    public boolean isCategoryCorrect(String name) {
        for (Category category : categories) {
            if (category.getName() == name) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        String categoryListString = "";
        for (Category category : categories) {
            categoryListString += category.getName() + ", ";
        }

        return categoryListString;
    }
}
