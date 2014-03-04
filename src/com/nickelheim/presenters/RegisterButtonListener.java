package com.nickelheim.presenters;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.nickelheim.activities.LoginSuccessActivity;
import com.nickelheim.activities.RegisterActivity;
import com.nickelheim.models.UserList;

public class RegisterButtonListener {
    public static final String USERNAME = "username";
    private Context context;
    private RegisterActivity view;
    private UserList model;
    
    public RegisterButtonListener(RegisterActivity view, Context context, UserList model) {
        this.view = view;
        this.model = model;
        this.context = context;
        
    }
     
    public void attemptRegistration() {
        String username = view.getUsername();
        String password = view.getPassword();
        boolean isValidRegistration = model.isValidRegistration(username, password);
        if(isValidRegistration) {
            Intent intent  = new Intent(view, LoginSuccessActivity.class);
            intent.putExtra(USERNAME, username);
            view.startActivity(intent);
        } else {
            Toast.makeText(this.context, "Register not successful.  Try again.", Toast.LENGTH_LONG).show();
        }

    }
}
