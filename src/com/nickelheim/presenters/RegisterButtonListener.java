package com.nickelheim.presenters;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.nickelheim.activities.LoginActivity;
import com.nickelheim.models.UserList;
import com.nickelheim.views.AbstractRegisterActivity;

public class RegisterButtonListener {
    private Context context;
    private AbstractRegisterActivity view;
    private UserList model;
    
    public RegisterButtonListener(AbstractRegisterActivity view, Context context, UserList model) {
        this.view = view;
        this.model = model;
        this.context = context;
        
    }
     
    public void registrationSuccess() {
        String username = view.getUsername();
        String password = view.getPassword();
        boolean isValidRegistration = model.isValidRegistration(username, password);
        //System.out.println(isValidRegistration);
        if(isValidRegistration) {
            Intent intent  = new Intent(view, LoginActivity.class);
            view.startActivity(intent);
        } else {
            Toast.makeText(this.context, "Register not successful.  Try again.", Toast.LENGTH_LONG).show();
        }

    }
}
