package com.nickelheim.presenters;

import android.content.Context;
import android.widget.Toast;

import com.nickelheim.activities.TransactionActivity;
import com.nickelheim.models.Account;
import com.nickelheim.models.AccountList;
import com.nickelheim.models.TransactionList;

public class TransactionButtonListener {
	private AccountList accountList = AccountList.getInstance();
	private Account account;
	public static final String ACCOUNT = "account";
	private Context context;
    private TransactionActivity view;
    private TransactionList model;
    
    
    
    public TransactionButtonListener(TransactionActivity view, Context context,
    												TransactionList model) {
        this.view = view;
        this.model = model;
        this.context = context;
    }
    
    public void attemptWithdraw() {
    	double amount = view.getAmount();
        boolean isValidWithdraw = model.isValidWithdraw(view.getAccount(), amount);
        if(isValidWithdraw) {
        	view.updateBalanceField();
        	Toast.makeText(this.context, "Withdraw successful.", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this.context, "Withdraw not successful.  Try again.", Toast.LENGTH_LONG).show();
        }

    }
    
    public void attemptDeposit() {
    	double amount = view.getAmount();
        boolean isValidDeposit = model.isValidDeposit(view.getAccount(), amount);
        if(isValidDeposit) {
        	view.updateBalanceField();
        	Toast.makeText(this.context, "Deposit successful.", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this.context, "Deposit not successful.  Try again.", Toast.LENGTH_LONG).show();
        }

    }
}
