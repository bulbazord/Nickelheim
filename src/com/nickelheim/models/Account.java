package com.nickelheim.models;

import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;

import java.util.Collection;
import java.util.ArrayList;

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
@DatabaseTable(tableName = "accounts")
public class Account {
    public static final String PORTFOLIO_COL = "portfolio";
    @DatabaseField(canBeNull = false, foreign = true,
                   columnName = PORTFOLIO_COL)
    private Portfolio portfolio;
    @DatabaseField(generatedId = true)
    private int id; //SQL magic, but complicates our querying syntax
    public static final String ACCOUNT_NAME_COL = "accountName";
    @DatabaseField(columnName = ACCOUNT_NAME_COL)
    private String accountName;
    @DatabaseField
    private double balance;

    @ForeignCollectionField
    private Collection<Transaction> transactions;
    /**
     * No-arg constructor for ORMLite! DO NOT USE
     */
    Account() {

    }

    /**
     * Constructs an Account object, given identifying information about the
     * corresponding user.
     *
     * @param username
     * @param accountName
     * @param balance
     */
    public Account(Portfolio port, String accountName, double balance) {
        this.portfolio = port;
    	this.accountName = accountName;
        this.balance = balance;
        this.transactions = new ArrayList<Transaction>();
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
        return "Account Name: " + accountName + "\n" + "Balance: " + balance;
    }
    
    
    /**
     * Returns the first name of the user who owns this account.
     *
     * @return String the user's name
     */
    public String getName() {
        return accountName;
    }
    
    /**
     * We really should take this out, it is a LoD violation at its core.
     */
    public String getUsername() {
    	return portfolio.getUser().getUsername();
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void addTransaction(Transaction trans) {
        transactions.add(trans);
        balance += trans.getAmount(); //will need to refactor to be negative for
        // withdrawals if I want to do this
    }

    public void withdraw(double amount) {
    	this.balance -= amount;
    }
    
    public void deposit(double amount) {
    	this.balance += amount;
    }

}
