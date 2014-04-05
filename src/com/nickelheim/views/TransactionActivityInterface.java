package com.nickelheim.views;

import com.nickelheim.models.Account;

import android.view.View;

/**
 * Interface for Transaction Activity.
 * 
 * @author Nickelheim
 *
 */
public interface TransactionActivityInterface {
    /**
     * method to get amount.
     * @return string representing amount
     */
    double getAmount();
	 /**
     * method to get a comment.
     * @return string representing a comment
     */
    String getComment();
    /**
     * method to get an account.
     * @return Account
     */
    Account getAccount();
    /**
     * method signaling presenter that user is attempting to withdraw money.
     * 
     * @param view is the current activity
     */
    void attemptWithdraw(View view);
    /**
     * method signaling presenter that user is attempting to deposit money.
     * 
     * @param view is the current activity
     */
    void attemptDeposit(View view);
	/**
     * method to update the balance field.
     */
    void updateBalanceField();
}
