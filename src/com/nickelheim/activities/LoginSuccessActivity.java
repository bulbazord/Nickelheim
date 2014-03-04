package com.nickelheim.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.nickelheim.R;
import com.nickelheim.presenters.LoginButtonListener;
import com.nickelheim.views.LoginSuccessActivityInterface;

public class LoginSuccessActivity extends Activity implements LoginSuccessActivityInterface {
    public static final String USERNAME = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login_success, menu);
        return true;
    }
    @Override
    public void createAccount(View view) {
        
        Intent intent  = new Intent(this, CreateAccountActivity.class);
        String username = this.getIntent().getExtras().getString(LoginButtonListener.USERNAME);
        intent.putExtra(USERNAME, username);
        startActivity(intent);
    }
    
    public void showAccount(View view) {
    	Intent intent = new Intent(this, CreateAccountSuccessActivity.class);
    	String username = this.getIntent().getExtras().getString(LoginButtonListener.USERNAME);
    	intent.putExtra(USERNAME, username);
    	startActivity(intent);
    }

}
