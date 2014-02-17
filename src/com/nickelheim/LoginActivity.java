package com.nickelheim;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.nickelheim.LoginSuccessActivity;
import com.nickelheim.R;

public class LoginActivity extends Activity {
    
    public final static String USERNAME = "username";
    public final static String PASSWORD = "password";
    EditText username;
    EditText  password;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }
    
    public void sendLoginForValidation(View view) {
        Intent intent = new Intent (this, LoginSuccessActivity.class);
        
        String usernameString = username.getText().toString();
        String passwordString = password.getText().toString();
        UserVerification u = new UserVerification(usernameString, passwordString);

        if (u.isAdmin()) {
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Login Not Successful.  Try Again.",
                    Toast.LENGTH_LONG).show();
        }
        
    }
}
