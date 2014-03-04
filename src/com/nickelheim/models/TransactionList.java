package com.nickelheim.models;

import java.util.HashMap;
import java.util.Map;

public class TransactionList implements TransactionModel {
	private static TransactionList instance;
	private Map<Account, Transaction> transactionList;
		
	private TransactionList() {
		transactionList = new HashMap<Account, Transaction>();
	}
	
	public static TransactionList getInstance() {
        if (instance == null) {
            instance = new TransactionList();
        }
        return instance;
    }
	
	public boolean isValidWithdraw(Account account, double amount) {
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
			addTransaction(account, amount, withdraw, deposit);
			return true;	
		}
	
	}
	
	public boolean isValidDeposit(Account account, double amount) {
		if (amount <= 0) {
			return false;
		} 
		else {
			account.deposit(amount);
			boolean deposit = true;
			boolean withdraw = false;
			addTransaction(account, amount, withdraw, deposit);
			return true;	
		}
	
	}
	public void addTransaction(Account account, double amount, boolean withdraw, boolean deposit) {
		transactionList.put(account, new Transaction(account, amount, withdraw, deposit));
	}
		
	
	
	
}
