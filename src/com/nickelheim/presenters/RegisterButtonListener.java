package com.nickelheim.presenters;

import java.sql.SQLException;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.nickelheim.activities.LoginSuccessActivity;
import com.nickelheim.activities.RegisterActivity;
import com.nickelheim.models.Portfolio;
import com.nickelheim.models.User;
import com.nickelheim.presenters.storage.NickelOpenHelper;
/**
 * Presenter for Regerstration.
 * 
 * @author Nickelheim
 *
 */
public class RegisterButtonListener {
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
    private RegisterActivity view;
    /**
     * databaseHelper instance variable.
     */
    private NickelOpenHelper databaseHelper = null;
    /**
     * constructor.
     * @param viewInput is the view
     * @param contextInput is the context
     */
    public RegisterButtonListener(RegisterActivity viewInput, 
                                                        Context contextInput) {
        this.view = viewInput;
        this.context = contextInput;
    }
    /**
     * method to attempt registration. 
     */
    public void attemptRegistration() {
        String username = view.getUsername();
        String password = view.getPassword();


        new RegistrationTask().execute(username, password);
    }
    /**
     * method to get NickelOpenHelper.
     * @return NickelOpenHelper
     */
    private NickelOpenHelper getHelper() {
        if (databaseHelper == null) {
            databaseHelper = 
                OpenHelperManager.getHelper(context, NickelOpenHelper.class);
        }
        return databaseHelper;
    }

    //Maybe add a closeHelper method and hook it to the Activity too?


    /**
     * Database i/o task that checks whether the given username is already in
     * the database.
     *
     * If the username is found in the database, gives the user a Toast to that
     * effect. If the username is not found, then we create the User and store
     * it in the database, and start the next activity as if the user had just
     * logged in.
     */
    private class RegistrationTask extends AsyncTask<String, Void, User>
    {

        /**
         * method to do processes in background.
         * 
         * @param usernameAndPassword are string prarameters
         * @return User
         */
        protected User doInBackground(String... usernameAndPassword) {
            User result = null;
            try {
                Dao<User, String> userDao = getHelper().getUserDao();
                result = userDao.queryForId(usernameAndPassword[0]);
                if (result == null) {
                    result = new User(usernameAndPassword[0],
                                      usernameAndPassword[1]);
                    userDao.create(result); //stores in d/b
                    Log.i(RegistrationTask.class.getName(),
                          "inserted User " + result.toString());
                    Dao<Portfolio, Integer> portfolioDao =
                        getHelper().getPortfolioDao();
                    portfolioDao.create(result.getPortfolioByName("default"));
                    Log.i(RegistrationTask.class.getName(),
                          "inserted default Portfolio");
                } else {
                    // inform the user that they suck
                    result = null;
                }
            } catch (SQLException e) {
                Log.e(RegistrationTask.class.getName(), "Can't query"
                      + " User table.", e);
                throw new RuntimeException(e);
            }
            return result;
        }
        /**
         * method to call processes after execution.
         * 
         * @param user is the user
         */
        protected void onPostExecute(User user) {
            if (user == null) {
                Toast.makeText(context,
                               "Registration not successful.  Try again.",
                               Toast.LENGTH_LONG).show(); 
            } else {
                LoginButtonListener.loggedInUser = user;
                Intent intent = new Intent(view, LoginSuccessActivity.class);
                intent.putExtra(USERNAME, user.getUsername());
                view.startActivity(intent);
            }
        }
    }
}
