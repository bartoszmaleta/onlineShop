package org.example.model.list;

import org.example.model.user.User;
import java.util.ArrayList;
import java.util.List;

public class UserList {
    List<User> users;

    public UserList(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }
  
      public void setUsers(List<User> users) {
        this.users = users;
    }
}
