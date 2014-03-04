package com.nickelheim.views;

import android.view.View;

public interface RegisterActivityInterface {
    public String getUsername();
    public String getPassword();
    public void attemptRegistration(View view);
}
