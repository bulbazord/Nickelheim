package com.nickelheim.models;

import java.util.HashMap;
import java.util.Map;

/**
 * Stores all User objects into a hashmap.
 * 
 * @author aphivantrakul
 */

public class UserList implements UserModel {
    /**
     * instance instance variable.
     */
    private static UserList instance;
    /**
     * userList instance variable.
     */
    private Map<String, User> userList;
    
    /**
     * Private constructor to be called only by the getInstance method in this
     * class. Also adds default admin and pass123 to hashmap.  
     */
   
    private UserList() {
        String admin = "admin";
        userList = new HashMap<String, User>();
        userList.put(admin, new User(admin, "pass123"));
    }
    /**
     * method to check if a hashmap already exists.  If it exists, return the 
     * hashmap.  If it does not exist, create a new instance of it by calling
     * the constructor.
     * 
     * @return UserList
     */
    
    public static UserList getInstance() {
        if (instance == null) {
            instance = new UserList();
        }
        return instance;
    }
    
    /**
     * checks whether information passed to log in user is not empty and whether
     * the username passed in matches the password in the hashmap
     * maybe should also add if statement to check first if username is found in
     * hashmap.
     *
     * @param username is the username
     * @param password is the password
     * @return is a boolean
     */
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
    
    /**
     * checks whether fields on registration page are empty when page is
     * submitted.  Also checks whether username has already been taken.
     * if information passes, the new User object is created and added to the
     * hashmap
     * 
     * @param username is the username
     * @param password is the password
     * @return is a boolean
     */
    
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
    
    /**
     * adds user to the list.
     * 
     * @param username is the username
     * @param password is the password
     */
    @Override
    public void addUser(String username, String password) {
        userList.put(username, new User(username, password));
    }
    
}
