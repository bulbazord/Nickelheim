package com.nickelheim.models;


public interface TransactionModel {
	boolean isValidWithdraw(final Account account, final double amount);
	boolean isValidDeposit(final Account account, final double amount);
	void addTransaction(final Account account, final double amount,
            final boolean withdraw, final boolean deposit);
}
