package com.nickelheim.presenters;

import com.nickelheim.views.WelcomeView;
import android.content.Intent;
import com.nickelheim.activities.LoginActivity;

public class WelcomeButtonListener {

    private WelcomeView view;

    public WelcomeButtonListener(WelcomeView view) {
	this.view = view;
    }

    public void startLogin() {
	Intent intent  = new Intent(this, LoginActivity.class);
	startActivity(intent);
    }

    public void startRegister() {
	// Intent intent = new Intent(this, );
    }


}
