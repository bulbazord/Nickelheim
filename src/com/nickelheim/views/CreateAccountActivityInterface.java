package com.nickelheim.views;

import android.view.View;

/**
 * Interface for CreateAccount Activity.
 * 
 * @author Nickelheim
 */
public interface CreateAccountActivityInterface {
    /**
     * Returns the username of the user presently logged in.
     *
     * @return String the user's username
     */
    String getUsername();
    /**
     * Returns the account name input by the user.
     *
     * @return String the account name
     */
    String getAccountName();
    /**
     * Returns the balance of an account.
     *
     * @return balance as a double
     */
    double getBalance();
    /**
     * Tries to create an account with the presently available first name,
     * last name, and email for the presently logged user.
     *
     * @param view obligatory parameter for button-press-tied method
     */
    void attemptCreateAccount(View view);
}
