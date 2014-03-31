package com.nickelheim.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.nickelheim.R;
import com.nickelheim.models.UserList;
import com.nickelheim.presenters.LoginButtonListener;
import com.nickelheim.views.LoginActivityInterface;


/**
 * An activity in which the user can log-in to the system.
 *
 * @author Nickelheim Group
 * @version 1.0
 */
public class LoginActivity extends Activity implements LoginActivityInterface {
    private LoginButtonListener listener;
    private EditText usernameField;
    private EditText passwordField;

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
        setContentView(R.layout.login);
        
        listener = new LoginButtonListener(this, this);

        usernameField =  (EditText) findViewById(R.id.login_username);
        passwordField =  (EditText) findViewById(R.id.login_password);
        
    }
    

    /**
     * Signals to the presenter that the user has attempted to log in.
     *
     * Called automatically when the user presses a button.
     *
     * @param View standard argument for button-tied method
     */
    @Override
    public String getUsername() {
        return usernameField.getText().toString();
    }

    @Override
    public String getPassword() {
        return passwordField.getText().toString();
    }
    
    public void attemptLogin(View view) {
        listener.attemptLogin();
    }
}
