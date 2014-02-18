package com.nickelheim.models;

import java.util.HashMap;
import java.util.Map;

public class UserList implements Model {
    private Map<String, User> userList;
    
    public UserList() {
        userList = new HashMap<String, User>();
        userList.put("admin", new User("admin", "pass123"));
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
    
    @Override
    public void addUser(User user) {
        userList.put(user.getUsername(), new User(user.getUsername(), user.getPassword()));
    }
    
}
