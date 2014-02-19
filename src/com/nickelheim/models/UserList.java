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
        User user = new User(username, password);
        if (user != null) {
            if (password.equals(user.getPassword())) {
                return true;
            }
            
        }
        return false;
    }
    
    public boolean isValidRegistration(final String username, final String password) {
        if (null == username) {
            return false;
        }
        if (null == password) {
            return false;
        }
        if (userList.containsKey(username)) {
            return false;
        }
        addUser(username, password);
        return true;  
    }
    
    @Override
    public void addUser(String username, String password) {
        userList.put(username, new User(username, password));
    }
    
}
