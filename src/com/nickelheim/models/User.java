package com.nickelheim.models;

/**
 * Class for User, which is created on the registration page
 *
 * @author aphivantrakul
 */
public class User {
    private String username;
    private String password;
    
    //Constructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    //toString to print out instance variables in a pretty way
    //probably should change username to getUsername() and password to 
    //getPassword since these are private instance variables
    //this method is not currently being used
    public String toString() {
        return "username: " + username + " password: " + password;
    }
    
    //getter for username instance variable
    public String getUsername() {
        return username;
    }
    
    //getter for password instance variable
    public String getPassword() {
        return password;
    }
}
