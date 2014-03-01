package com.nickelheim.presenters;

import android.content.Intent;

import com.nickelheim.activities.LoginActivity;
import com.nickelheim.activities.RegisterActivity;
import com.nickelheim.activities.WelcomeActivity;
/**
 * The presenter responsible for managing the task of welcoming the user.
 *
 * @author Nickelheim Group
 * @version 1.0
 */
public class WelcomeButtonListener {

    private WelcomeActivity view;

    /**
     * Constructs the WelcomeButtonListener, setting up a reference to the
     * correpsonding view object.
     *
     * @param AbstractWelcomeActivity the Activity/view to which this is tied
     */
    public WelcomeButtonListener(WelcomeActivity view) {
        this.view = view;
    }

    /**
     * Responds to the user's signal of intention to login.
     *
     * Called in turn by the view.
     */
    public void beginLogin() {
        Intent intent  = new Intent(view, LoginActivity.class);
        view.startActivity(intent);
    }

    /**
     * Responds to the user's signal of intention to register with the
     * application.
     *
     * Called in turn by the view.
     */
    public void beginRegister() {
        Intent intent = new Intent(view, RegisterActivity.class );
        view.startActivity(intent);
    }


}