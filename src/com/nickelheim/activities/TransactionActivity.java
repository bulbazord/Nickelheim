package com.nickelheim.activities;

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
    private EditText amountField;
    private TextView balanceField;
    private AccountList accountList;
    private Account account;
    
    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_transaction);
		
		listener = new TransactionButtonListener(this, this, TransactionList.getInstance());
		
		String username = getUsername();
		accountList = AccountList.getInstance();
		account = accountList.findAccount(username);
		
        amountField =  (EditText) findViewById(R.id.amount);
        
        balanceField = (TextView) findViewById(R.id.balance);
        String balanceToString = Double.toString(account.getBalance());
        balanceField.setText(balanceToString);
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
	
	@Override
	public void attemptWithdraw(View view) {
        listener.attemptWithdraw();
    }
	
	@Override
	public void attemptDeposit(View view) {
		listener.attemptDeposit();
	}
	
	public String getUsername() {
		String username = this.getIntent().getExtras().getString(CreateAccountSuccessActivity.USERNAME);
		return username;
	}
	
	public void updateBalanceField() {
        String balanceToString = Double.toString(account.getBalance());
        balanceField.setText(balanceToString);
	}

}
