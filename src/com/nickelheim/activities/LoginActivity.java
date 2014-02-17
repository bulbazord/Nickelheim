package com.nickelheim.activities;

import com.nickelheim.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;


/**
 * An activity in which the user can log-in to the system.
 *
 * @author matthugs and xiaobai
 * @version 1.0
 */
public class LoginActivity extends Activity {

    /**
     * Initializes the activity.
     *
     * Sets up the layout, among other necessities.
     *
     * @param Bundle to be loaded if the application was saved
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }

    /**
     * Signals to the presenter that the user has attempted to log in.
     *
     * Called automatically when the user presses a button.
     *
     * @param View standard argument for button-tied method
     */
    public void attemptLogin(View view) {
	// To be filled out!
    }
}
