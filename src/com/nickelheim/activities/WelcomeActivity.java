package com.nickelheim.activities;

import com.nickelheim.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.nickelheim.presenters.WelcomeButtonListener;
import com.nickelheim.views.WelcomeView;

public class WelcomeActivity extends Activity implements WelcomeView
{
    private WelcomeButtonListener listener;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
	listener = new WelcomeButtonListener(this);

    }


    public void startLogin(View view) {
	listener.startLogin();
    }


    public void startRegister(View view) {
	listener.startRegister();
    }
}
