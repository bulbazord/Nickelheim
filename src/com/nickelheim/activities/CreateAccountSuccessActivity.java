package com.nickelheim.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nickelheim.R;
import com.nickelheim.models.Account;
import com.nickelheim.models.AccountList;
import com.nickelheim.presenters.CreateAccountButtonListener;

public class CreateAccountSuccessActivity extends Activity {
	AccountList accountList = AccountList.getInstance();
	public static final String USERNAME = "username";
	public String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account_success);
        
        username = this.getIntent().getExtras().getString(CreateAccountButtonListener.USERNAME);
        //String firstName = this.getIntent().getExtras().getString(CreateAccountButtonListener.FIRSTNAME);
        //String lastName = this.getIntent().getExtras().getString(CreateAccountButtonListener.LASTNAME);
        //String email = this.getIntent().getExtras().getString(CreateAccountButtonListener.EMAIL);
        //double balance = this.getIntent().getExtras().getDouble(CreateAccountButtonListener.BALANCE);
        
        Account account = accountList.findAccount(username);
        
        TextView firstNameField =  (TextView) findViewById(R.id.create_account_success_first_name_field);
        TextView lastNameField =  (TextView) findViewById(R.id.create_account_success_lastname_field);
        TextView emailField = (TextView) findViewById(R.id.create_account_success_email_field);
        TextView balanceField = (TextView) findViewById(R.id.create_account_success_balance);
        Button transaction = (Button) findViewById(R.id.transaction);
        
        if (account != null) {
        	firstNameField.setText(account.getFirstName());
            lastNameField.setText(account.getLastName());
            emailField.setText(account.getEmail());
            
            String balanceToString = Double.toString(account.getBalance());
            balanceField.setText(balanceToString);	
		} else {
			firstNameField.setText("Empty");
			lastNameField.setText("Empty");
			emailField.setText("Empty");
			balanceField.setText("Empty");
			transaction.setVisibility(View.GONE);
		}
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.create_account_success, menu);
        return true;
    }
    
    public void startTransaction(View view) {
    	Intent intent  = new Intent(this, TransactionActivity.class);
    	intent.putExtra(USERNAME, username);
        startActivity(intent);
    }
    
}
