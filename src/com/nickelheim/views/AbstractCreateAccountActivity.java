package com.nickelheim.views;

import android.app.Activity;
import android.view.View;

/**
 * Abstract class to be extended by CreateAccountActivity.java
 * 
 * @author Nickelheim
 *
 */
public abstract class AbstractCreateAccountActivity extends Activity  {
    public abstract String getUsername();
    public abstract String getFirstName();
    public abstract String getLastName();
    public abstract String getEmail();
    public abstract void attemptCreateAccount(View view);
}

