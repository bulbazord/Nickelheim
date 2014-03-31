package com.nickelheim.models;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.field.DatabaseField;


@DatabaseTable(tableName = "transactions")
public class Transaction {

    private String accountUsername;
    @DatabaseField(foreign = true, canBeNull = false)
    private Account account;
    private String accountName;
    private double accountBalance;
    @DatabaseField
    private double amount;
    private boolean withdraw;
    private boolean deposit;
    @DatabaseField(id = true)
    private long timestamp;
    @DatabaseField
    private String comment;

    /**
     * No arg constructor for ORMLite
     */
    Transaction() {
        
    }

    public Transaction(Account account, double amount, boolean withdraw,
                       boolean deposit, long timestamp, String comment) {
        this.account = account;
        this.accountUsername = account.getUsername();
        this.accountName = account.getName();
        this.accountBalance = account.getBalance();
        this.amount = amount;
        this.withdraw = withdraw;
        this.deposit = deposit;
        this.timestamp = timestamp;
        this.comment = comment;
    }

    public String getAccountUsername() {
        return accountUsername;
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
