package com.nickelheim.views;

import android.view.View;
import android.app.Activity;
/**
 * The view abstraction between the presenter responsible for
 * welcoming the user and the corresponding Activity/view.
 *
 * @author xiaobai
 * @version 1.0
 */
public abstract class AbstractWelcomeActivity extends Activity {
    public abstract void startLogin(View view);
    public abstract void startRegister(View view);
}
