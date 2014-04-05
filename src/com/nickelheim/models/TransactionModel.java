package com.nickelheim.models;


/**
 * Interface for transactions.
 * 
 * @author Nickelheim
 *
 */
public interface TransactionModel {
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
    boolean isValidWithdraw(final Account account, final double amount,
	                            final long timestamp, final String comment);
	/**
     * determines if deposit is valid.
     * 
     * @param account is the account
     * @param amount is the amount
     * @param timestamp is the timestamp
     * @param comment is the comment
     * @return boolean
     */
    boolean isValidDeposit(final Account account, final double amount,
	                                final long timestamp, final String comment);
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
    void addTransaction(final Account account, final double amount,
	        final boolean withdraw, final boolean deposit, final long timestamp,
                                                        final String comment);
}
