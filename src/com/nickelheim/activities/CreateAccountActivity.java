package com.nickelheim.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import com.nickelheim.R;
import com.nickelheim.presenters.CreateAccountButtonListener;
import com.nickelheim.presenters.RegisterButtonListener;
import com.nickelheim.views.CreateAccountActivityInterface;

/**
 * An <code>Activity</code> responsible for Account creation.
 *
 * Contains fields for user information, and a button that the user can press
 * to attempt to create an account.
 *
 * @author Nickeclheim
 */
public class CreateAccountActivity extends Activity implements 
                                                CreateAccountActivityInterface {
    /**
     * Listener instance variable.
     */
    private CreateAccountButtonListener listener;
    /**
     * accountNameField instance variable.
     */
    private EditText accountNameField;
    /**
     * balanceField instance variable.
     */
    private EditText balanceField;
    /**
     * username instance variable.
     */
    private String username;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        
        accountNameField =  (EditText) findViewById(
                                        R.id.create_account_account_name_field);
        balanceField = (EditText) findViewById(
                R.id.create_account_balance_field);
        
        username = this.getIntent().getExtras().getString(
                                        RegisterButtonListener.USERNAME);
        
        listener = new CreateAccountButtonListener(this, this);
    }
    /**
     * method to return username.
     * 
     * @return username as a String
     */
    @Override
    public String getUsername() {
        return username;
    }
    /**
     * method to return account name.
     * 
     * @return account name as a String
     */
    @Override
    public String getAccountName() {
        return accountNameField.getText().toString();
    }
    /**
     * method to return balance.
     * 
     * @return balance as a double
     */
    @Override
    public double getBalance() {
        return Double.valueOf(balanceField.getText().toString());
    }
    /**
     * signals to the presenter to create and account.
     *
     * @param view standard argument for button-tied method
     */
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
