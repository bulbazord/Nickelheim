package com.nickelheim.views;

import android.view.View;

/**
 * interface for LoginSuccessActivity.
 * 
 * @author Nickelheim
 *
 */
public interface LoginSuccessActivityInterface {
    /**
     * method to create a new account.
     * 
     * @param view is the current activity
     */
    void createAccount(View view);
    /**
     * sends user to a new activity to view account.
     * 
     * @param view is the current activity
     */
    void showAccount(View view);
}
