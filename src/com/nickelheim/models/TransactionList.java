package com.nickelheim.models;

import java.util.ArrayList;
import java.util.List;

/**
 * List of Transactions.
 * 
 * @author Nickelheim
 *
 */
public class TransactionList implements TransactionModel {
    /**
     * instance instance variable.
     */
    private static TransactionList instance;
	/**
     * transactionList instance variable.
     */
    private List<Transaction> transactionList;
    /**
     * TransactionList constructor.
     */	
    private TransactionList() {
        transactionList = new ArrayList<Transaction>();
    }
	/**
	 * gets an instance of TransactionList.
	 * @return TransactionList object
	 */
    public static TransactionList getInstance() {
        if (instance == null) {
            instance = new TransactionList();
        }
        return instance;
    }
    /**
     * determines if user input is valid for withdraw.
     * 
     * @param account is the account
     * @param amount is the amount
     * @param timestamp is the timestamp
     * @param comment is the comment
     * @return boolean
     *    
     */
    public boolean isValidWithdraw(Account account, double amount, long timestamp, String comment) {
        if (account == null || amount == null || timestamp == null || comment == null) {
            return false;
        }
        if (amount <= 0) {
            return false;
        } 
        if (amount > account.getBalance()) {
            return false;
        }
        else {
            account.withdraw(amount);
            boolean withdraw = true;
            boolean deposit = false;
            addTransaction(account, amount, withdraw, deposit, timestamp, comment);
            return true;	
        }
	
    }
	/**
	 * determines if deposit is valid.
	 * 
     * @param account is the account
     * @param amount is the amount
     * @param timestamp is the timestamp
     * @param comment is the comment
     * @return boolean
	 */
    public boolean isValidDeposit(Account account, double amount, long timestamp, String comment) {
        if (account == null || amount == null || timestamp == null || comment == null) {
            return false;
        }
        if (amount <= 0) {
            return false;
        } 
        else {
            account.deposit(amount);
            boolean deposit = true;
            boolean withdraw = false;
            addTransaction(account, amount, withdraw, deposit, timestamp, comment);
            return true;	
        }	
    }
    /**
     * adds a transaction to the transactionList.
     * 
     * @param account is the account
     * @param amount is the amount
     * @param timestamp is the timestamp
     * @param comment is the comment
     * @param withdraw determines if the transaction is a withdraw
     * @param deposit determines if the transaction is a deposit
     */
    public void addTransaction(Account account, double amount, boolean withdraw,
                            boolean deposit, long timestamp, String comment) {
        transactionList.add(new Transaction(account, amount, withdraw,
                                                  deposit, timestamp, comment));
    }
	/**
	 * gets the transaction list.	
	 * @return List of transactions
	 */
    public List<Transaction> getTransactionList() {
        return transactionList;
    }
	
}
