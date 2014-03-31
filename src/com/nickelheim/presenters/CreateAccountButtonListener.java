package com.nickelheim.presenters;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.nickelheim.activities.CreateAccountActivity;
import com.nickelheim.activities.CreateAccountSuccessActivity;
import com.nickelheim.models.AccountList;

import android.util.Log;
import java.sql.SQLException;
import com.nickelheim.models.Portfolio;
import com.nickelheim.models.Account;
import com.j256.ormlite.dao.Dao;
import java.util.List;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.nickelheim.presenters.storage.NickelOpenHelper;
import android.os.AsyncTask;
import com.nickelheim.models.User;

public class CreateAccountButtonListener {
	public static final String USERNAME = "username";
    public static final String ACCOUNTNAME = "accountName";
    public static final String ACCOUNTTYPE = "accountType";
    public static final String BALANCE = "balance";
    private Context context;
    private CreateAccountActivity view;
    private User user;
    public static Account accountBeingViewed = null;

    public CreateAccountButtonListener(CreateAccountActivity view,
                                    Context context) {
        this.view = view;
        this.context = context;
        this.user = LoginButtonListener.loggedInUser;
    }
     
    public void attemptCreateAccount() {
    	String username = view.getUsername();
        String accountName = view.getAccountName();
        double balance = view.getBalance();
        
        boolean isValidCreateAccount = AccountList.getInstance().isValidCreateAccount(username,
                                                                  accountName,
                                                                  balance);
        if(isValidCreateAccount) {
            new AccountCreationTask().execute(accountName);
        } else {
            Toast.makeText(context,
                           "The data you've input is invalid. Try again.",
                           Toast.LENGTH_LONG).show();
        }

    }

    private NickelOpenHelper openHelper;

    private NickelOpenHelper getHelper() {
        if(openHelper == null) {
            openHelper = OpenHelperManager.getHelper(context,
                                                     NickelOpenHelper.class);
        }
        return openHelper;

    }
    
    private class AccountCreationTask extends AsyncTask<String, Void, Account> {

        private Portfolio port = (Portfolio) user.getPortfolios().toArray()[0];
        private double balance;

        protected void onPreExecute() {
            balance = view.getBalance();
        }

        protected Account doInBackground(String... args) {
            Account acc = null;
            try {//query to see if there are accounts with matching data
                Dao<Account, Integer> accountDao = getHelper().getAccountDao();
                QueryBuilder<Account, Integer> qb = accountDao.queryBuilder();
                Where<Account, Integer> where = qb.where();
                where.eq(Account.PORTFOLIO_COL, port.getId())
                    .and().eq(Account.ACCOUNT_NAME_COL, args[0]);
                List<Account> accounts = accountDao.query(qb.prepare());
                if(accounts.size() == 0) { // then make the Account and add
                    // it to the portfolio
                    acc = new Account(port, args[0], balance);
                    port.addAccount(acc);
                    Dao<Portfolio, Integer> portDao =
                        getHelper().getPortfolioDao();
                    accountDao.create(acc); //throwing an error for some reason
                    // hypothesis: it's a uniqueness issue
                    // corroborated by logCat, at least
                    portDao.update(port);
                }                
            } catch(SQLException e) {
                Log.e(AccountCreationTask.class.getName(), "Couldn't query for "
                      + "the specified account.", e);
                throw new RuntimeException(e);
            }
            return acc;
        }

        protected void onPostExecute(Account acc) {
            if(acc == null) {
                Toast.makeText(context,
                               "Your input is confusing my darling database",
                               Toast.LENGTH_LONG).show();
            } else {
                accountBeingViewed = acc;
                Intent intent  = new Intent(view,
                                            CreateAccountSuccessActivity.class);
                intent.putExtra(USERNAME, user.getUsername());
                view.startActivity(intent);
            }
        }
    }
    
}
