package com.nickelheim.views;

import android.app.Activity;
import android.view.View;

public abstract class AbstractLoginActivity extends Activity {
    public abstract String getUsername();
    public abstract String getPassword();
    public abstract void attemptLogin(View view);
}
