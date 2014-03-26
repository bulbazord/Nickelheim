package com.nickelheim.models;


public interface TransactionModel {
	boolean isValidWithdraw(final Account account, final double amount,
	                            final long timestamp, final String comment);
	boolean isValidDeposit(final Account account, final double amount,
	                                final long timestamp, final String comment);
	void addTransaction(final Account account, final double amount,
	        final boolean withdraw, final boolean deposit, final long timestamp,
                                                        final String comment);
}
