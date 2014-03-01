package com.nickelheim.views;

import android.view.View;

public interface LoginActivityInterface {
    public abstract String getUsername();
    public abstract String getPassword();
    public abstract void attemptLogin(View view);
}
