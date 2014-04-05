package com.nickelheim.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.nickelheim.R;
import com.nickelheim.presenters.LoginButtonListener;
import com.nickelheim.views.LoginActivityInterface;


/**
 * An activity in which the user can log-in to the system.
 *
 * @author Nickelheim Group
 * @version 1.0
 */
public class LoginActivity extends Activity implements LoginActivityInterface {
    /**
     * listener instance variable.
     */
    private LoginButtonListener listener;
    /**
     * usernameField instance variable.
     */
    private EditText usernameField;
    /**
     * passwordField instance variable.
     */
    private EditText passwordField;

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
        setContentView(R.layout.login);
        
        listener = new LoginButtonListener(this, this);

        usernameField =  (EditText) findViewById(R.id.login_username);
        passwordField =  (EditText) findViewById(R.id.login_password);
        
    }
    

    /**
     * method to return username.
     * 
     * @return username
     */
    @Override
    public String getUsername() {
        return usernameField.getText().toString();
    }
    /**
     * method to return password.
     * 
     * @return password as a String
     */
    @Override
    public String getPassword() {
        return passwordField.getText().toString();
    }
    /**
     * method signaling presenter that user is attempting to login.
     * 
     * @param view is the current activity
     */
    public void attemptLogin(View view) {
        listener.attemptLogin();
    }
}
