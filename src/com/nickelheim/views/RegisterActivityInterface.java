package com.nickelheim.views;

import android.view.View;

/**
 * Interface for Register Activity.
 * 
 * @author Nickelheim
 *
 */
public interface RegisterActivityInterface {
    /**
     * method to return username.
     * 
     * @return username as a String
     */
    String getUsername();
    /**
     * method to return password.
     * 
     * @return password as a String
     */
    String getPassword();
    /**
     * method signaling presenter that user is attempting to register.
     * 
     * @param view is the current activity
     */
    void attemptRegistration(View view);
}
