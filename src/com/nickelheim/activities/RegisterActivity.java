package com.nickelheim.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import com.nickelheim.R;
import com.nickelheim.models.UserList;
import com.nickelheim.presenters.RegisterButtonListener;
import com.nickelheim.views.AbstractRegisterActivity;

public class RegisterActivity extends AbstractRegisterActivity {
    private RegisterButtonListener listener;
    private EditText usernameField;
    private EditText passwordField;
    private UserList userList;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        
        usernameField =  (EditText) findViewById(R.id.register_username_field);
        passwordField =  (EditText) findViewById(R.id.register_password_field);
        
        
        listener = new RegisterButtonListener(this, this, UserList.getInstance());
    }

    @Override
    public String getUsername() {
        return usernameField.getText().toString();
    }

    @Override
    public String getPassword() {
        return passwordField.getText().toString();
    }
    
    public UserList getUserList() {
        return userList;
    }
    
    public void attemptRegistration(View view) {
        listener.registrationSuccess();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.register, menu);
        return true;
    }

}
