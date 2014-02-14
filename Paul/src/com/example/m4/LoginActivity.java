package com.example.m4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.m3.R;

public class LoginActivity extends Activity {
    
    public final static String USERNAME = "username";
    public final static String PASSWORD = "password";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }
    
    public void sendLoginForValidation(View view) {
        Intent intent = new Intent (this, ValidateLoginActivity.class);
        EditText username = (EditText) findViewById(R.id.username);
        String usernameString = username.getText().toString();
        EditText  password = (EditText) findViewById(R.id.password);
        String passwordString = password.getText().toString();
        intent.putExtra(USERNAME, usernameString);
        intent.putExtra(PASSWORD, passwordString);
        startActivityForResult(intent, 1);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            Toast.makeText(getApplicationContext(), "Login Not Successful.  Try Again.",
                    Toast.LENGTH_LONG).show();
        }
    }

}
