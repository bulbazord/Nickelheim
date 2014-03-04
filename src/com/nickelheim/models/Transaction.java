package com.nickelheim.models;

public class Transaction {
	private Account account;
	private double amount;
	private boolean withdraw;
	private boolean deposit;

	public Transaction(Account account, double amount, boolean withdraw,
						boolean deposit) {
		this.account = account;
		this.amount = amount;
		this.withdraw = withdraw;
		this.deposit = deposit;
	}
	
	public Account getAccount() {
        return account;
    }
	
	public double getAmount() {
		return amount;
	}
	
	public boolean getWithdraw() {
		return withdraw;
	}
	
	public boolean getDeposit() {
		return deposit;
	}
	
}
