package com.nickelheim.activities;

import com.nickelheim.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class WelcomeActivity extends Activity implements WelcomeView
{
    private WelcomeButtonListener listener;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
	listener = new WelcomeButtonListener(this, new MemoryModel());

    }


    public void startLogin(View view) {
	
    }


    public void startRegister(View view) {

    }
}