package com.nickelheim.models;

import java.util.ArrayList;
import java.util.List;

public class TransactionList implements TransactionModel {
	private static TransactionList instance;
	private List<Transaction> transactionList;
		
	private TransactionList() {
		transactionList = new ArrayList<Transaction>();
	}
	
	public static TransactionList getInstance() {
        if (instance == null) {
            instance = new TransactionList();
        }
        return instance;
    }
	
	public boolean isValidWithdraw(Account account, double amount, long timestamp, String comment) {
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
	
	public boolean isValidDeposit(Account account, double amount, long timestamp, String comment) {
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
	public void addTransaction(Account account, double amount, boolean withdraw,
                            boolean deposit, long timestamp, String comment) {
		transactionList.add(new Transaction(account, amount, withdraw,
                                                  deposit, timestamp, comment));
	}
		
	public List<Transaction> getList() {
	    return transactionList;
	}
	
}
