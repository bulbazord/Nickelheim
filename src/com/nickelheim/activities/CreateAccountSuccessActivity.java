package com.nickelheim.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;

import com.nickelheim.R;
import com.nickelheim.presenters.CreateAccountButtonListener;

public class CreateAccountSuccessActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account_success);
        
        String firstName = this.getIntent().getExtras().getString(CreateAccountButtonListener.FIRSTNAME);
        String lastName = this.getIntent().getExtras().getString(CreateAccountButtonListener.LASTNAME);
        String email = this.getIntent().getExtras().getString(CreateAccountButtonListener.EMAIL);
        
        EditText firstNameField =  (EditText) findViewById(R.id.create_account_success_first_name_field);
        EditText lastNameField =  (EditText) findViewById(R.id.create_account_success_lastname_field);
        EditText emailField = (EditText) findViewById(R.id.create_account_success_email_field);
        
        firstNameField.setText(firstName);
        lastNameField.setText(lastName);
        emailField.setText(email);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.creat_account_success, menu);
        return true;
    }
    


}
