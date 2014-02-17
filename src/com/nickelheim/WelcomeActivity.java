package com.nickelheim;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.example.m3.R;

public class WelcomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.welcome, menu);
        return true;
    }
    
    public void openLogin(View view) {
        Intent intent = new Intent (this, LoginActivity.class);
        startActivity(intent); 
    }
    
    public void openRegister(View view) {
        Intent intent = new Intent (this, RegisterActivity.class);
        startActivity(intent); 
    }

}
