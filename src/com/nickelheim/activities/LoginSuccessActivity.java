package com.nickelheim.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.nickelheim.R;

public class LoginSuccessActivity extends Activity {

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

}
