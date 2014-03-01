package com.nickelheim.views;

import android.view.View;

public interface RegisterActivityInterface {
    public abstract String getUsername();
    public abstract String getPassword();
    public abstract void attemptRegistration(View view);
}
