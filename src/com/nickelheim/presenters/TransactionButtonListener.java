package com.nickelheim.presenters;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.content.Context;
import android.widget.Toast;

import com.nickelheim.activities.TransactionActivity;
import com.nickelheim.models.TransactionList;
import com.nickelheim.models.Account;

public class TransactionButtonListener {
    public static final String ACCOUNT = "account";
    private Context context;
    private TransactionActivity view;
    private TransactionList model = TransactionList.getInstance();
    private Account account;


    public TransactionButtonListener(TransactionActivity view, Context context,
                                     Account account) {
        this.view = view;
        this.account = account;
        this.context = context;
    }
    
    public void attemptWithdraw() {
        long timestamp = getTimeInMilliSeconds();        
    	double amount = view.getAmount();
    	String comment = view.getComment();
        boolean isValidWithdraw = model.isValidWithdraw(view.getAccount(),
                                                        amount, timestamp,
                                                        comment);
        if(isValidWithdraw) {
        	view.updateBalanceField();
        	Toast.makeText(this.context, "Withdraw successful.",
                               Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this.context, "Withdraw not successful.  Try again.",
                           Toast.LENGTH_SHORT).show();
        }

    }
    
    public void attemptDeposit() {
        long timestamp = getTimeInMilliSeconds();
    	double amount = view.getAmount();
    	String comment = view.getComment();
        boolean isValidDeposit = model.isValidDeposit(view.getAccount(), amount, timestamp, comment);
        if(isValidDeposit) {
        	view.updateBalanceField();
        	Toast.makeText(this.context, "Deposit successful.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this.context, "Deposit not successful.  Try again.", Toast.LENGTH_SHORT).show();
        }
    }
    
    public long getTimeInMilliSeconds() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTimeInMillis();
    }    
}
