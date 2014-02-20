package com.nickelheim.activities;

import android.os.Bundle;
import android.view.View;

import com.nickelheim.R;
import com.nickelheim.presenters.WelcomeButtonListener;
import com.nickelheim.views.AbstractWelcomeActivity;


/**
 * The parent activity for the Nickelheim application.
 *
 * Contains buttons for logging in and registration. 
 *
 * @author Nickelheim Group
 * @version 1.0
 */
public class WelcomeActivity extends AbstractWelcomeActivity {
    private WelcomeButtonListener listener;


    /**
     * Initializes the activity.
     *
     * Sets up the layout, among other necessities.
     *
     * @param Bundle to be loaded if the application was saved
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
     * @param View standard argument for button-tied method
     */
    public void startLogin(View view) {
	listener.beginLogin();
    }

    /**
     * Sends a message to the presenter class to start the Registration
     * activity.
     *
     * @param View standard argument for button-tied method
     */
    public void startRegister(View view) {
	listener.beginRegister();
    }
}
