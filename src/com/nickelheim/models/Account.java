package com.nickelheim.models;

public class Account {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    
    public Account(String username, String firstName, String lastName, String email) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    
    public String toString() {
        return "username: " + username + " first name: " + firstName 
                + " last name: " + lastName + " email: " + email;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getEmail() {
        return email;
    }

}
