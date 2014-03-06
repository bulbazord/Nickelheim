package com.nickelheim.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import com.nickelheim.R;
import com.nickelheim.models.AccountList;
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
public class CreateAccountActivity extends Activity implements CreateAccountActivityInterface {
    private CreateAccountButtonListener listener;
    private EditText accountNameField;
    private EditText balanceField;
    private String username;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        
        accountNameField =  (EditText) findViewById(
                                        R.id.create_account_account_name_field);
        balanceField = (EditText) findViewById(
                R.id.create_account_balance_field);
        
        username =this.getIntent().getExtras().getString(
                                        RegisterButtonListener.USERNAME);
        
        listener = new CreateAccountButtonListener(this, this,
                                               AccountList.getInstance());
    }
    
    @Override
    public String getUsername() {
        return username;
    }
    
    @Override
    public String getAccountName() {
        return accountNameField.getText().toString();
    }

    @Override
    public double getBalance() {
        return Double.valueOf(balanceField.getText().toString());
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
