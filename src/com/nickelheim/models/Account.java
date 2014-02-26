package com.nickelheim.models;

/**
 * Represents the account that a user creates after successful
 * login/registration
 * 
 * @author aphivantrakul
 */
public class Account {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    
    //Constructor
    public Account(String username, String firstName, String lastName, String email) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    
    //toString method that is not currently being used
    //prints out all the instance variables in a pretty way
    public String toString() {
        return "username: " + username + " first name: " + firstName 
                + " last name: " + lastName + " email: " + email;
    }
    
    //getter for username instance variable
    public String getUsername() {
        return username;
    }
    
    //getter for firstname instance variable
    public String getFirstName() {
        return firstName;
    }
    
    //getter for lastname instance variable
    public String getLastName() {
        return lastName;
    }
    
    //getter for email instance variable
    public String getEmail() {
        return email;
    }

}
