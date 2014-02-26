package com.nickelheim.views;

import android.app.Activity;
import android.view.View;

/**
 * Abstract class to be extended by LoginActivity.java
 * 
 * @author Nickelheim
 *
 */

public abstract class AbstractLoginActivity extends Activity {
    public abstract String getUsername();
    public abstract String getPassword();
    public abstract void attemptLogin(View view);
}
