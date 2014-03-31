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
import com.nickelheim.models.AccountList;
import com.nickelheim.models.TransactionList;
import com.nickelheim.presenters.TransactionButtonListener;
import com.nickelheim.views.TransactionActivityInterface;

public class TransactionActivity extends Activity
							implements TransactionActivityInterface {
	private TransactionButtonListener listener;
	private TextView accountNameField;
    private EditText amountField;
    private TextView balanceField;
    private Account account;
    private EditText commentField;
    
    @Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
		
        listener = new TransactionButtonListener(this, this,
                                                 TransactionList.getInstance());
		
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
	
	@Override
	public double getAmount() {
        return Double.valueOf(amountField.getText().toString());
    }
	
	public String getComment() {
	   String comment = commentField.getText().toString();
	   if (comment == null || comment.length() == 0) {
	       return "None";
	   }
	   return comment;
	    
	}
	public Account getAccount() {
	    return account;
	}
	
	@Override
	public void attemptWithdraw(View view) {
        listener.attemptWithdraw();
    }
	
	@Override
	public void attemptDeposit(View view) {
		listener.attemptDeposit();
	}
	
	public void updateBalanceField() {
	    NumberFormat format = NumberFormat.getCurrencyInstance();
            balanceField.setText(format.format(account.getBalance()));
            // presently the previous line is calling a null pointer exception
            // account needs to be set
	}

}
