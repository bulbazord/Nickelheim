package com.nickelheim.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.nickelheim.R;
import com.nickelheim.presenters.WelcomeButtonListener;
import com.nickelheim.views.WelcomeActivityInterface;


/**
 * The parent activity for the Nickelheim application.
 *
 * Contains buttons for logging in and registration. 
 *
 * @author Nickelheim Group
 * @version 1.0
 */
public class WelcomeActivity extends Activity
                                           implements WelcomeActivityInterface {
    /**
     * listener instance variable.
     */
    private WelcomeButtonListener listener;


    /**
     * Initializes the activity.
     *
     * Sets up the layout, among other necessities.
     *
     * @param savedInstanceState to be loaded if the application was saved
     */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        listener = new WelcomeButtonListener(this);

    }

    /**
     * Sends a message to the presenter class to start the login activity.
     *
     * @param view standard argument for button-tied method
     */
    public void startLogin(View view) {
        listener.beginLogin();
    }

    /**
     * Sends a message to the presenter class to start the Registration
     * activity.
     *
     * @param view standard argument for button-tied method
     */
    public void startRegister(View view) {
        listener.beginRegister();
    }
}
