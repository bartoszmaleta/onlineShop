package org.example.model.user;

import java.sql.SQLException;

public interface UserInterface {

    public void viewUserTable() throws SQLException;

    public void addUser(User user) throws Exception;

    public boolean isLoginTaken(String loginToCheck) throws SQLException;

    public boolean isEmailTaken(String emailToCheck) throws SQLException;

}
