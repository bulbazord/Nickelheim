package com.nickelheim.models;

import java.text.SimpleDateFormat;
import java.util.Locale;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Transaction class.
 * 
 * @author Nickelheim
 *
 */
@DatabaseTable(tableName = "transactions")
public class Transaction {
    /**
     * accountUsername instance variable.
     */
    private String accountUsername;
    /**
     * DatabaseField.
     */
    @DatabaseField(foreign = true, canBeNull = false)
    private Account account;
    /**
     * accountName instance variable.
     */
    private String accountName;
    /**
     * accountBalance instance variable.
     */
    private double accountBalance;
    /**
     * DatabaseField.
     */
    @DatabaseField
    private double amount;
    /**
     * withdraw instance variable.
     */
    private boolean withdraw;
    /**
     * withdraw instance variable.
     */
    private boolean deposit;
    /**
     * DatabaseField.
     */
    @DatabaseField(id = true)
    private long timestamp;
    /**
     * DatabaseField.
     */
    @DatabaseField
    private String comment;

    /**
     * dateFormat instance variable.
     */
    private static String dateFormat = "MMddyyy HH:mm:ss";

    /**
     * No arg constructor for ORMLite.
     */
    Transaction() {
        
    }
    /**
     * Represents a transaction.
     * 
     * @param accountInput is an account
     * @param amountInput is the amount
     * @param withdrawInput signifies a withdraw transaction
     * @param depositInput signifies a deposit
     * @param timestampInput is the time the transaction occurred
     * @param commentInput is the comment associated with the transaction
     */
    public Transaction(Account accountInput, double amountInput, 
       boolean withdrawInput, boolean depositInput, long timestampInput, String commentInput) {
        this.account = accountInput;
        this.accountUsername = accountInput.getUsername();
        this.accountName = accountInput.getAccountName();
        this.accountBalance = accountInput.getBalance();
        this.amount = amountInput;
        this.withdraw = withdrawInput;
        this.deposit = depositInput;
        this.timestamp = timestampInput;
        this.comment = commentInput;
    }
    /**
     * gets account username.
     * 
     * @return username as a string
     */
    public String getAccountUsername() {
        return accountUsername;
    }
	/**
	 * gets amount.
	 * 
	 * @return amount as double
	 */
    public double getAmount() {
        return amount;
    }
	/**
	 * determines if transaction is withdraw.
	 * 
	 * @return boolean
	 */
    public boolean getWithdraw() {
        return withdraw;
    }
    /**
     * determines if transaction is deposit.
     * 
     * @return boolean
     */
    public boolean getDeposit() {
        return deposit;
    }
    /**
     * gets the timestamp.
     * @return timestamp as long
     */
    public long getTimestamp() {
        return timestamp;
    }
	/**
	 * takes a time in milliseconds and returns a formatted date.
	 * @param milliseconds is time in milliseconds
	 * @return formatted date as string
	 */
    public String milliSecondsToFormattedDate(long milliseconds) {
        SimpleDateFormat dateFormat =
                                new SimpleDateFormat("MM-dd-yyyy", Locale.US);
        String formattedDate = dateFormat.format(milliseconds);
        return formattedDate;
    }
	/**
	 * toString method.
	 * @return a string
	 */
    public String toString() {
        String newLine = "\n";
        return ("Date: " + milliSecondsToFormattedDate(timestamp) + newLine 
                + "Account Name: " + accountName + newLine
                + "Withdraw: " + withdraw + newLine 
                + "Deposit: " + deposit + newLine 
                + "Comment: " + comment + newLine
                + "Transaction Amount: " + amount + newLine 
                + "Ending Balance: " + accountBalance); 
    }	

    /**
     * converts start date into seconds.
     * 
     * @param startingDate is the start date as a String
     * @return seconds as a long
     */
    public static long startDateToSeconds (String startingDate) {
        String startDateWithSeconds = startingDate + " 00:00:00";
        //System.out.println("startDateWithSeconds = "+ startDateWithSeconds);
        SimpleDateFormat simpleDateFormat = 
                                    new SimpleDateFormat(dateFormat, Locale.US);
        try {
            Date date = simpleDateFormat.parse(startDateWithSeconds);
            long milliseconds = date.getTime();
            return milliseconds;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0; 
    }
    /**
     * converts end date into seconds.
     * 
     * @param endingDate is the end date
     * @return seconds as a long
     */
    public static long endDateToSeconds (String endingDate) {
        String endDateWithSeconds = endingDate + " 23:59:59";
        //System.out.println("endDateWithSeconds = "+ endDateWithSeconds );
        SimpleDateFormat simpleDateFormat = 
                                    new SimpleDateFormat(dateFormat, Locale.US);
        try {
            Date date = simpleDateFormat.parse(endDateWithSeconds);
            long milliseconds = date.getTime();
            return milliseconds;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0; 
    }

}
