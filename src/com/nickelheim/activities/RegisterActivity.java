package com.nickelheim.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import com.nickelheim.R;
import com.nickelheim.presenters.RegisterButtonListener;
import com.nickelheim.views.RegisterActivityInterface;

/**
 * Activity for registration.
 * 
 * @author Nickelheim
 *
 */
public class RegisterActivity extends Activity
                                         implements RegisterActivityInterface {
    /**
     * listener instance variable.
     */
    private RegisterButtonListener listener;
    /**
     * usernameField instance variable.
     */
    private EditText usernameField;
    /**
     * passwordField instance variable.
     */
    private EditText passwordField;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        
        usernameField =  (EditText) findViewById(R.id.register_username_field);
        passwordField =  (EditText) findViewById(R.id.register_password_field);
        
        
        listener = new RegisterButtonListener(this, this);
    }
    /**
     * method to return username.
     * 
     * @return username as a String
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
     * method signaling presenter that user is attempting to register.
     * 
     * @param view is the current activity
     */
    public void attemptRegistration(View view) {
        listener.attemptRegistration();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.register, menu);
        return true;
    }

}
