package com.nickelheim.presenters;

import com.nickelheim.views.WelcomeView;
import android.content.Intent;

public class WelcomeButtonListener {

    private WelcomeView view;

    public WelcomeButtonListener(WelcomeView view) {
	this.view = view;
    }

    public void login() {
	Intent intent  = new Intent(this, LoginActivity.class);
	startActivity(intent);
    }

    public void register() {
	// Intent intent = new Intent(this, );
    }


}
