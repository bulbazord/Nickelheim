package com.example.m4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.example.m3.R;

public class ValidateLoginActivity extends Activity {

    public final static String FAILURE = "failure";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Get the message from the intent
        Intent intent = getIntent();
        String username = intent.getStringExtra(LoginActivity.USERNAME);
        String password = intent.getStringExtra(LoginActivity.PASSWORD);
        
        // Create the text view
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        if ((username.equals("admin")) && (password.equals("pass123"))) {
            textView.setText("Login Successful");            
        } else {
            Intent returnIntent = new Intent();
            String fail = "fail";
            returnIntent.putExtra(FAILURE, fail);
            setResult(RESULT_OK, returnIntent);
            finish();
        }
        
        
        
        
        
        
        
        setContentView(textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.validate_login, menu);
        return true;
    }

}
