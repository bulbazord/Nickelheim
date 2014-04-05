package com.nickelheim.views;

import android.view.View;

/**
 * Interface for LoginActivity.
 * 
 * @author Nickelheim
 */
public interface LoginActivityInterface {
    /**
     * method to return username.
     * 
     * @return username
     */
    String getUsername();
    /**
     * method to return password.
     * 
     * @return password as a String
     */
    String getPassword();
    /**
     * method signaling presenter that user is attempting to login.
     * 
     * @param view is the current activity
     */
    void attemptLogin(View view);
}
