package com.nickelheim.views;

import android.view.View;

public interface CreateAccountActivityInterface {
    /**
     * Returns the username of the user presently logged in.
     *
     * @return String the user's username
     */
    public String getUsername();
    /**
     * Returns the account name input by the user.
     *
     * @return String the account name
     */
    public String getAccountName();

    
    public double getBalance();
    /**
     * Tries to create an account with the presently available first name,
     * last name, and email for the presently logged user.
     *
     * @param View obligatory parameter for button-press-tied method
     */
    public void attemptCreateAccount(View view);
}
