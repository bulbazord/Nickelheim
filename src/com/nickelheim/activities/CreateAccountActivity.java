package com.nickelheim.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import com.nickelheim.R;
import com.nickelheim.models.AccountList;
import com.nickelheim.presenters.CreateAccountButtonListener;
import com.nickelheim.presenters.RegisterButtonListener;
import com.nickelheim.views.AbstractCreateAccountActivity;

/**
 * An <code>Activity</code> responsible for Account creation.
 *
 * Contains fields for user information, and a button that the user can press
 * to attempt to create an account.
 *
 * @author Nickeclheim
 */
public class CreateAccountActivity extends AbstractCreateAccountActivity {
    private CreateAccountButtonListener listener;
    private EditText firstNameField;
    private EditText lastNameField;
    private EditText emailField;
    private String username;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        
        firstNameField =  (EditText) findViewById(
                                        R.id.create_account_first_name_field);
        lastNameField =  (EditText) findViewById(
                                        R.id.create_account_last_name_field);
        emailField = (EditText) findViewById(
                                        R.id.create_account_email_field);
        username =this.getIntent().getExtras().getString(
                                        RegisterButtonListener.USERNAME);
        
        listener = new CreateAccountButtonListener(this, this,
                                                   new AccountList());
    }
    
    @Override
    public String getUsername() {
        return username;
    }
    
    @Override
    public String getFirstName() {
        return firstNameField.getText().toString();
    }

    @Override
    public String getLastName() {
        return lastNameField.getText().toString();
    }
    
    @Override
    public String getEmail() {
        return emailField.getText().toString();
    }

    @Override
    public void attemptCreateAccount(View view) {
        listener.attemptCreateAccount();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.create_account, menu);
        return true;
    }

}
