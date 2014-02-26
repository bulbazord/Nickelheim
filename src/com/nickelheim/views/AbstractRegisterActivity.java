package com.nickelheim.views;

import android.app.Activity;
import android.view.View;

/**
 * Abstract class to be extended by RegisterActivity.java
 * 
 * @author Nickelheim
 *
 */

public abstract class AbstractRegisterActivity extends Activity  {
    public abstract String getUsername();
    public abstract String getPassword();
    public abstract void attemptRegistration(View view);
}
