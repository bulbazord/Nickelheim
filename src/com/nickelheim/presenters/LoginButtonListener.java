package com.nickelheim.presenters;

import java.sql.SQLException;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.nickelheim.activities.LoginActivity;
import com.nickelheim.activities.LoginSuccessActivity;
import com.nickelheim.models.User;
import com.nickelheim.presenters.storage.NickelOpenHelper;
/**
 * Presenter for loggin in.
 * @author Nickelheim
 *
 */
public class LoginButtonListener {
    /**
     * USERNAME instance variable.
     */
    public static final String USERNAME = "username";
    /**
     * context instance variable.
     */
    private Context context;
    /**
     * view instance variable.
     */
    private LoginActivity view;
    /**
     * loggedInUser instance variable.
     */
    public static User loggedInUser = null;
    /**
     * databaseHelper instance variable.
     */
    private NickelOpenHelper databaseHelper = null;
    /**
     * constructor.
     * @param viewInput is the view
     * @param contextInput is the context
     */
    public LoginButtonListener(LoginActivity viewInput, Context contextInput) {
        this.view = viewInput;
        this.context = contextInput;
        
    }
    /**
     * method witch attempts to login. 
     */
    public void attemptLogin() {
        String username = view.getUsername();
        String password = view.getPassword();

        new LoadUserTask().execute(username, password);
    }
    /**
     * gets NickelOpenHelper.
     * @return NickelOpenHelper
     */
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
    /**
     * LoadUserTask class.
     * 
     * @author Nickelheim
     *
     */
    private class LoadUserTask extends AsyncTask<String, Void, User> {
        /**
         * process that occur in the background.
         * 
         * @param usernameAndPassword are string inputs
         * @return User
         */
        protected User doInBackground(String... usernameAndPassword) {
            User result = null;
            try {            
                Dao<User, String> userDao = getHelper().getUserDao();
                result = userDao.queryForId(usernameAndPassword[0]);
                if (result == null 
                    || !result.getPassword().equals(usernameAndPassword[1])) {
                    result = null;
                }
            } catch (SQLException e) {
                result = null;
                throw new RuntimeException(e);
            } //  finally {
            //     closeHelper();
            // }
            return result;
        }
        /**
         * method callin post execute processes.
         * 
         * @param user is the user
         */
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
