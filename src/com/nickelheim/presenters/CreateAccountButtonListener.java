package com.nickelheim.presenters;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.nickelheim.activities.CreateAccountActivity;
import com.nickelheim.activities.CreateAccountSuccessActivity;
import com.nickelheim.models.AccountList;

public class CreateAccountButtonListener {
	public static final String USERNAME = "username";
    public static final String ACCOUNTNAME = "accountName";
    public static final String ACCOUNTTYPE = "accountType";
    public static final String BALANCE = "balance";
    private Context context;
    private CreateAccountActivity view;
    private AccountList model;
    
    public CreateAccountButtonListener(CreateAccountActivity view,
                                    Context context, AccountList model) {
        this.view = view;
        this.model = model;
        this.context = context;
    }
     
    public void attemptCreateAccount() {
        String accountName = view.getAccountName();
        double balance = view.getBalance();
        boolean isValidCreateAccount = model.isValidCreateAccount(accountName,
                                                                    balance);
        if(isValidCreateAccount) {
            //Toast.makeText(this.context, "Create account successful."
            //                                        , Toast.LENGTH_LONG).show();
            Intent intent  = new Intent(view,
                                            CreateAccountSuccessActivity.class);
            view.startActivity(intent);
        } else {
            Toast.makeText(this.context, "Create account not successful."
                                    + "  Try again.", Toast.LENGTH_LONG).show();
        }

    }
    
    
    
}
