package com.nickelheim.views;

import android.view.View;

public interface LoginActivityInterface {
    public String getUsername();
    public String getPassword();
    public void attemptLogin(View view);
}
