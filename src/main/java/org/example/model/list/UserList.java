package org.example.model.list;

import org.example.model.user.User;

import java.util.ArrayList;

public class UserList {
    private ArrayList<User> users;

    public UserList(ArrayList<User> users){this.users = users;}

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}
