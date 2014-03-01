package com.nickelheim.views;

import android.view.View;

public interface CreateAccountActivityInterface {
    /**
     * Returns the username of the user presently logged in.
     *
     * @return String the user's username
     */
    public abstract String getUsername();
    /**
     * Returns the first name input by the user.
     *
     * @return String the name
     */
    public abstract String getFirstName();
    /**
     * Returns the last name input by the user.
     *
     * @return the name
     */
    public abstract String getLastName();
    /**
     * Returns the email address input by the user.
     *
     * @return the email
     */
    public abstract String getEmail();
    /**
     * Tries to create an account with the presently available first name,
     * last name, and email for the presently logged user.
     *
     * @param View obligatory parameter for button-press-tied method
     */
    public abstract void attemptCreateAccount(View view);
}
