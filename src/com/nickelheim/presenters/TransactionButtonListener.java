package com.nickelheim.presenters;

import java.util.Calendar;

import android.content.Context;
import android.widget.Toast;

import com.nickelheim.activities.TransactionActivity;
import com.nickelheim.models.Account;
import com.nickelheim.models.TransactionList;
/**
 * Presenter for transactions.
 * 
 * @author Nickelheim
 *
 */
public class TransactionButtonListener {
    /**
     * ACCOUNT instance variable.
     */
    public static final String ACCOUNT = "account";
    /**
     * context instance variable.
     */
    private Context context;
    /**
     * view instance variable.
     */
    private TransactionActivity view;
    /**
     * model instance variable.
     */
    private TransactionList model = TransactionList.getInstance();
    /**
     * account instance variable.
     */
    private Account account;

    /**
     * constructor.
     * @param viewInput is the view
     * @param contextInput is the context
     * @param accountInput is the account
     */
    public TransactionButtonListener(TransactionActivity viewInput, 
            Context contextInput, Account accountInput) {
        this.view = viewInput;
        this.account = accountInput;
        this.context = contextInput;
    }
    /**
     * method that attempts withdraw.
     */
    public void attemptWithdraw() {
        long timestamp = getTimeInMilliSeconds();        
    	double amount = view.getAmount();
    	String comment = view.getComment();
        boolean isValidWithdraw = model.isValidWithdraw(view.getAccount(),
                                                        amount, timestamp,
                                                        comment);
        if (isValidWithdraw) {
            view.updateBalanceField();
            Toast.makeText(this.context, "Withdraw successful.",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this.context, "Withdraw not successful.  Try again.",
                           Toast.LENGTH_SHORT).show();
        }

    }
    /**
     * method that attempts a deposit.
     */
    public void attemptDeposit() {
        long timestamp = getTimeInMilliSeconds();
    	double amount = view.getAmount();
    	String comment = view.getComment();
        boolean isValidDeposit = model.isValidDeposit(view.getAccount(), amount,
                                                            timestamp, comment);
        if (isValidDeposit) {
            view.updateBalanceField();
            Toast.makeText(this.context, "Deposit successful.",
        	                                        Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this.context, "Deposit not successful.  Try again.",
                                                    Toast.LENGTH_SHORT).show();
        }
    }
    /**
     * gets time in milliseconds.
     * @return time in milliseconds as a long
     */
    public long getTimeInMilliSeconds() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTimeInMillis();
    }    
}
