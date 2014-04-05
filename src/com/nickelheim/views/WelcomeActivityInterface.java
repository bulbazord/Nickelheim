package com.nickelheim.views;

import android.view.View;

/**
 * Interface for Welcome Activity.
 * 
 * @author Nickelheim
 *
 */
public interface WelcomeActivityInterface {
    /**
     * Sends a message to the presenter class to start the login activity.
     *
     * @param view standard argument for button-tied method
     */
    void startLogin(View view);
    /**
     * Sends a message to the presenter class to start the Registration
     * activity.
     *
     * @param view standard argument for button-tied method
     */
    void startRegister(View view);
}
