package com.nickelheim.presenters;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.nickelheim.activities.LoginActivity;
import com.nickelheim.activities.LoginSuccessActivity;
import com.nickelheim.models.UserList;
import android.os.AsyncTask;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.nickelheim.presenters.storage.NickelOpenHelper;

public class LoginButtonListener {
    public static final String USERNAME = "username";
    private Context context;
    private LoginActivity view;
    private UserList model;
    public static User loggedInUser = null;
    
    private NickelOpenHelper databaseHelper = null;

    public LoginButtonListener(LoginActivity view, Context context, UserList model) {
        this.view = view;
        this.model = model;
        this.context = context;
        
    }
     
    public void attemptLogin() {
        String username = view.getUsername();
        String password = view.getPassword();

        new LoadUserTask().execute(username, password);
    }

    private NickelOpenHelper getHelper() {
        if (databaseHelper == null) {
            databaseHelper = 
                OpenHelperManager.getHelper(context, NickelOpenHelper.class);
        }
        return databaseHelper;
    }

    private class LoadUserTask extends AsyncTask<String, Void, User> {
        protected User doInBackground(String... usernameAndPassword) {
            RuntimeExceptionDao<User, String> userDao =
                getHelper().getUserDao();
            User result = userDao.queryForId(usernameAndPassword[0]);
            if(result == null
               || !result.getPassword().equals(usernameAndPassword[1])) {
                Toast.makeText(context, "Login not successful.  Try again.",
                               Toast.LENGTH_LONG).show();
                // Consider figuring out how to cancel the task?
            }
            return result;
        }

        protected void onPostExecute(User user) {
            if (user != null) {
                Intent intent  = new Intent(view, LoginSuccessActivity.class);
                intent.putExtra(USERNAME, user.getUsername());
                loggedInUser = user;
                view.startActivity(intent);
            }
        }
    }

}
