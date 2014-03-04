package com.nickelheim.views;

import android.view.View;

public interface TransactionActivityInterface {
	public double getAmount();
	public void attemptWithdraw(View view);
	public void attemptDeposit(View view);
}
