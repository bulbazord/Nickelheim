package com.nickelheim.models;

/**
 * Represents the account that a user creates after successful
 * login/registration.
 *
 * This is an account in the domain sense of the word; we are not talking about
 * the account the user has with our service. This is a financial account, not
 * application-specific.
 *
 * @author aphivantrakul
 */
public class Account {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private double balance;
    
    /**
     * Constructs an Account object, given identifying information about the
     * corresponding user.
     *
     * @param username
     * @param firstName
     * @param lastName
     * @param email
     * @param balance
     */
    public Account(String username, String firstName, String lastName, String email, double balance) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.balance = balance;
    }

    /**
     * Returns a String representation of this Account.
     *
     * Presently not being used.
     *
     * @return String a representation of this object
     */
    @Override
    public String toString() {
        return "username: " + username + " first name: " + firstName 
                + " last name: " + lastName + " email: " + email 
                + " balance: " + balance;
    }
    
    /**
     * Returns the username of the user who owns this account.
     *
     * @return String the username
     */
    public String getUsername() {
        return username;
    }
    
    /**
     * Returns the first name of the user who owns this account.
     *
     * @return String the user's name
     */
    public String getFirstName() {
        return firstName;
    }
    
    /**
     * Returns the last name of the user who owns this account.
     *
     * @return String the last name
     */
    public String getLastName() {
        return lastName;
    }
    
    /**
     * Returns the email of the user who owns this account.
     *
     * @return String the email
     */
    public String getEmail() {
        return email;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void withdraw(double amount) {
    	this.balance -= amount;
    }
    
    public void deposit(double amount) {
    	this.balance += amount;
    }

}
