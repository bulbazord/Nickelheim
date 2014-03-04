package com.nickelheim.presenters;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.nickelheim.activities.CreateAccountActivity;
import com.nickelheim.activities.CreateAccountSuccessActivity;
import com.nickelheim.models.AccountList;

public class CreateAccountButtonListener {
	public static final String USERNAME = "username";
    public static final String FIRSTNAME = "firstName";
    public static final String LASTNAME = "lastName";
    public static final String EMAIL = "email";
    public static final String BALANCE = "balance";
    private Context context;
    private CreateAccountActivity view;
    private AccountList model;
    
    public CreateAccountButtonListener(CreateAccountActivity view, Context context, AccountList model) {
        this.view = view;
        this.model = model;
        this.context = context;
    }
     
    public void attemptCreateAccount() {
        String username = view.getUsername();
        String firstName = view.getFirstName();
        String lastName = view.getLastName();
        String email = view.getEmail();
        double balance = view.getBalance();
        boolean isValidCreateAccount = model.isValidCreateAccount(username, firstName,
                                        lastName, email, balance);
        if(isValidCreateAccount) {
            Intent intent  = new Intent(view, CreateAccountSuccessActivity.class);
            intent.putExtra(USERNAME, username);
            //intent.putExtra(FIRSTNAME, firstName);
            //intent.putExtra(LASTNAME, lastName);
            ///intent.putExtra(EMAIL, email);
            //intent.putExtra(BALANCE, balance);
            view.startActivity(intent);
        } else {
            Toast.makeText(this.context, "Create account not successful.  Try again.", Toast.LENGTH_LONG).show();
        }

    }
    
    
    
}
