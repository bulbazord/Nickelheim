package com.nickelheim.models;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Transaction {
	private String accountName;
	private double accountBalance;
	private double amount;
	private boolean withdraw;
	private boolean deposit;
    private long timestamp;
    private String comment;

	public Transaction(Account account, double amount, boolean withdraw,
						boolean deposit, long timestamp, String comment) {
		this.accountName = account.getName();
		this.accountBalance = account.getBalance();
		this.amount = amount;
		this.withdraw = withdraw;
		this.deposit = deposit;
	    this.timestamp = timestamp;
	    this.comment = comment;
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
	
	public long getTimestamp() {
	    return timestamp;
	}
	
	public String milliSecondsToFormattedDate(long milliseconds) {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
	        String formattedDate = dateFormat.format(milliseconds);
	        return formattedDate;
	}
	
	public String toString() {
	    return ("Date: " + milliSecondsToFormattedDate(timestamp) + "\n" 
	            + "Account Name: " + accountName + "\n"
	            + "Withdraw: " + withdraw + "\n" 
	            + "Deposit: " + deposit + "\n" 
	            + "Comment: " + comment + "\n"
	            + "Transaction Amount: " + amount + "\n" 
	            + "Ending Balance: " + accountBalance); 
 	}
	
}
