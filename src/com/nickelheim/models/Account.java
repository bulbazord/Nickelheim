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
    private String accountName;
    private double balance;
    
    /**
     * Constructs an Account object, given identifying information about the
     * corresponding user.
     *
     * @param username
     * @param accountName
     * @param balance
     */
    public Account(String accountName, double balance) {
        this.accountName = accountName;
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
        return " account name: " + accountName + " balance: " + balance;
    }
    
    
    /**
     * Returns the first name of the user who owns this account.
     *
     * @return String the user's name
     */
    public String getAccountName() {
        return accountName;
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
