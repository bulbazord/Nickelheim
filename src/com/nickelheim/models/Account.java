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
    /**
     * PORTFOLIO_COL instance variable.
     */
    public static final String PORTFOLIO_COL = "portfolio";
    /**
     * DatabaseField.
     */
    @DatabaseField(canBeNull = false, foreign = true,
                   columnName = PORTFOLIO_COL)
    private Portfolio portfolio;
    /**
     * DatabaseField.
     */
    @DatabaseField(generatedId = true)
    private int id; //SQL magic, but complicates our querying syntax
    /**
     * ACCOUNT_NAME_COL instance variable.
     */
    public static final String ACCOUNT_NAME_COL = "accountName";
    /**
     * DatabaseField.
     */
    @DatabaseField(columnName = ACCOUNT_NAME_COL)
    private String accountName;
    /**
     * DatabaseField.
     */
    @DatabaseField
    private double balance;
    /**
     * transactions instance variable.
     */
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
     * @param accountNameInput is the name of the account
     * @param balanceInput is the balance
     * @param port is the portfolio
     */
    public Account(Portfolio port, String accountNameInput,
                                                        double balanceInput) {
        this.portfolio = port;
    	this.accountName = accountNameInput;
        this.balance = balanceInput;
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
    public String getAccountName() {
        return accountName;
    }
    
    /**
     * We really should take this out, it is a LoD violation at its core.
     * 
     * @return string representing the username
     */
    public String getUsername() {
    	return portfolio.getUser().getUsername();
    }
    /**
     * method to return the balance.
     * 
     * @return double representing the balance
     */
    public double getBalance() {
        return balance;
    }
    /**
     * method to add a transaction.
     * 
     * @param trans is a transaction
     */
    public void addTransaction(Transaction trans) {
        transactions.add(trans);
        balance += trans.getAmount(); //will need to refactor to be negative for
        // withdrawals if I want to do this
    }
    /**
     * method to perform withdraw.
     * 
     * @param amount is the amount to withdraw
     */
    public void withdraw(double amount) {
    	this.balance -= amount;
    }
    /**
     * method to perform deposit.
     * 
     * @param amount is the amount to deposit
     */
    public void deposit(double amount) {
    	this.balance += amount;
    }

}
