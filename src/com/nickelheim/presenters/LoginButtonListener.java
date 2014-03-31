package com.nickelheim.presenters;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.nickelheim.activities.LoginActivity;
import com.nickelheim.activities.LoginSuccessActivity;
import com.nickelheim.models.UserList;
import android.os.AsyncTask;

import com.nickelheim.models.User;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.nickelheim.presenters.storage.NickelOpenHelper;

import java.sql.SQLException;

public class LoginButtonListener {
    public static final String USERNAME = "username";
    private Context context;
    private LoginActivity view;
    public static User loggedInUser = null;
    
    private NickelOpenHelper databaseHelper = null;

    public LoginButtonListener(LoginActivity view, Context context) {
        this.view = view;
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
    // I might need to close the helper at some point, but right now it seems
    // unnecessary. I'd need to make an onClose method for this presenter
    // which I would need to hook up the corresponding Activity to call in its
    // onClose method.
    // private void closeHelper() {
    //     OpenHelperManager.releaseHelper();
    // }

    private class LoadUserTask extends AsyncTask<String, Void, User> {

        protected User doInBackground(String... usernameAndPassword) {
            User result = null;
            try {            
                Dao<User, String> userDao = getHelper().getUserDao();
                result = userDao.queryForId(usernameAndPassword[0]);
                if(result == null
                   || !result.getPassword().equals(usernameAndPassword[1])) {
                    result = null;
                }
            } catch (SQLException e) {
                result = null;
                throw new RuntimeException(e);
            }//  finally {
            //     closeHelper();
            // }
            return result;
        }

        protected void onPostExecute(User user) {
            if (user != null) {
                Intent intent  = new Intent(view, LoginSuccessActivity.class);
                intent.putExtra(USERNAME, user.getUsername());
                LoginButtonListener.loggedInUser = user;
                view.startActivity(intent);
            } else {
                Toast.makeText(context,
                               "Please enter valid un/pass combination",
                               Toast.LENGTH_LONG).show();
            }
        }
    }
}
