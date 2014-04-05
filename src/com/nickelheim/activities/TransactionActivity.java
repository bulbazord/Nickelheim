package com.nickelheim.activities;

import java.text.NumberFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.nickelheim.R;
import com.nickelheim.models.Account;
import com.nickelheim.presenters.TransactionButtonListener;
import com.nickelheim.views.TransactionActivityInterface;

/**
 * Activity for transactions.
 * 
 * @author Nickelheim
 *
 */
public class TransactionActivity extends Activity
							implements TransactionActivityInterface {
    /**
     * listener instance variable.
     */
    private TransactionButtonListener listener;
    /**
     * accountNameField instance variable.
     */
    private TextView accountNameField;
    /**
     * amountField instance variable.
     */
    private EditText amountField;
    /**
     * balanceField instance variable.
     */
    private TextView balanceField;
    /**
     * account instance variable.
     */
    private Account account;
    /**
     * commentField instance variable.
     */
    private EditText commentField;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
		
        listener = new TransactionButtonListener(this, this,
                                                 CreateAccountSuccessActivity
                                                     .accountToBeViewed);
		
        amountField =  (EditText) findViewById(R.id.amount);
        balanceField = (TextView) findViewById(R.id.balance);
        accountNameField = (TextView) findViewById(R.id.account_name);
        commentField = (EditText) findViewById(R.id.comment);
        
        String accountName = this.getIntent().getExtras().getString(CreateAccountSuccessActivity.ACCOUNT_NAME);
        account = CreateAccountSuccessActivity.accountToBeViewed;
        
        accountNameField.setText(accountName);
        
        updateBalanceField();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.transaction, menu);
        return true;
    }
    /**
     * method to get amount.
     * @return string representing amount
     */
    @Override
    public double getAmount() {
        return Double.valueOf(amountField.getText().toString());
    }
    /**
     * method to get a comment.
     * @return string representing a comment
     */
    public String getComment() {
        String comment = commentField.getText().toString();
        if (comment == null || comment.length() == 0) {
            return "None";
        }
        return comment;
    }
    /**
     * method to get an account.
     * @return Account
     */
    public Account getAccount() {
        return account;
    }
    /**
     * method signaling presenter that user is attempting to withdraw money.
     * 
     * @param view is the current activity
     */
    @Override
    public void attemptWithdraw(View view) {
        listener.attemptWithdraw();
    }
    /**
     * method signaling presenter that user is attempting to deposit money.
     * 
     * @param view is the current activity
     */
    @Override
    public void attemptDeposit(View view) {
        listener.attemptDeposit();
    }
    /**
     * method to update the balance field.
     */
    public void updateBalanceField() {
        NumberFormat format = NumberFormat.getCurrencyInstance();
        balanceField.setText(format.format(account.getBalance()));
            // presently the previous line is calling a null pointer exception
            // account needs to be set
    }

}
