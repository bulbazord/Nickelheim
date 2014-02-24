package com.nickelheim.models;

import java.util.HashMap;
import java.util.Map;

public class UserList implements UserModel {
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
        if (username == null) {
            return false;
        }
        if (username.length() == 0) {
            return false;
        }
        if (password == null) {
            return false;
        }
        if (password.length() == 0) {
            return false;
        }
        if (userList.containsKey(username)) {
            return false;
        } else {
            addUser(username, password);
            return true; 
        }
         
    }
    
    @Override
    public void addUser(String username, String password) {
        userList.put(username, new User(username, password));
    }
    
}
