package com.nickelheim.models;

import java.util.HashMap;
import java.util.Map;

public class UserList implements Model {
    private static UserList instance;
    private Map<String, User> userList;
    
    private UserList() {
        userList = new HashMap<String, User>();
        userList.put("admin", new User("admin", "pass123"));
    }
    
    public static UserList getInstance() {
        if (instance == null) {
            instance = new UserList();
        }
        return instance;
    }
    
    @Override
    public boolean isValidUser(final String username, final String password) {
        User user = userList.get(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                return true;
            } 
        } 
        return false;
    }
    
    public boolean isValidRegistration(final String username, final String password) {
        boolean isValid;
        if (username == null) {
            isValid = false;
        }
        if (password == null) {
            isValid = false;
        }
        if (userList.containsKey(username)) {
            isValid = false;
        } else {
            addUser(username, password);
            isValid = true; 
        }
        return isValid;
         
    }
    
    @Override
    public void addUser(String username, String password) {
        userList.put(username, new User(username, password));
    }
    
}
