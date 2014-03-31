package com.nickelheim.activities;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import android.widget.Toast;
import android.util.Log;

import com.nickelheim.R;
import com.nickelheim.models.Account;
import com.nickelheim.models.User;
import com.nickelheim.models.Portfolio;
import com.nickelheim.models.AccountList;
import com.nickelheim.presenters.CreateAccountButtonListener;
import com.nickelheim.presenters.LoginButtonListener;
import com.nickelheim.presenters.storage.NickelOpenHelper;

import android.os.AsyncTask;
import java.sql.SQLException;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.android.apptools.OpenHelperManager;


public class CreateAccountSuccessActivity extends Activity {
    
    public static final String ACCOUNT_NAME = "account name";
    public static final String USERNAME = "username";
    private String username;

    private User user = LoginButtonListener.loggedInUser;
    private Portfolio port = (Portfolio) user.getPortfolios().toArray()[0];

    public static Account accountToBeViewed = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account_success);
        username = this.getIntent().getExtras().getString(CreateAccountButtonListener.USERNAME);

        new AccountListTask().execute();
    }


    private NickelOpenHelper databaseHelper = null;
    private NickelOpenHelper getHelper() {
        if (databaseHelper == null) {
            databaseHelper = 
                OpenHelperManager.getHelper(this, NickelOpenHelper.class);
        }
        return databaseHelper;
    }


    /**
     * Task that gets the list of Accounts and then sets up the rest of what
     * we're supposed to be looking at. This should be in a separate presenter
     * class.
     */
    private class AccountListTask extends AsyncTask<String, Void, List<Account>>
    {
        private boolean foundSomeAccounts = false;

        protected List<Account> doInBackground(String... args) {
            List<Account> result = null;
            try {
                Dao<Account, Integer> accountDao = getHelper().getAccountDao();
                QueryBuilder<Account, Integer> qb = accountDao.queryBuilder();
                Where<Account, Integer> where = qb.where();
                where.eq(Account.PORTFOLIO_COL, port.getId());
                result = accountDao.query(qb.prepare());
                if(result != null && result.size() > 0) {
                    foundSomeAccounts = true;
                } else {
                    foundSomeAccounts = false;
                }

            } catch(SQLException e) {
                Log.e(AccountListTask.class.getName(),
                      "issue querying for accounts", e);
                throw new RuntimeException(e);
            }
            return result;
        }

        protected void onPostExecute(List<Account> accountList) {
            if(!foundSomeAccounts) {
                Toast.makeText(CreateAccountSuccessActivity.this,
                               "Couldn't get any accounts. Weird.",
                               Toast.LENGTH_LONG).show(); 
            } else {
                setUpList(accountList);
            }
        }
    }

    /**
     * This should be called by a presenter! There should be a presenter started
     * for this activity in the constructor!
     */
    private void setUpList(List<Account> accountList) {
        
        ArrayList<String> accountNames = new ArrayList<String>();
        
        for (Account account : accountList) {
            accountNames.add(account.getName());
        }
             
        ListView listView = (ListView)findViewById(R.id.list);
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1,
                                                                accountNames);
      
        // Assign adapter to ListView
        listView.setAdapter(adapter); 
                
        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                    int postion, long id) {
                Intent intent  = new Intent(getApplicationContext(),
                                                    TransactionActivity.class);
                String accountName = ((TextView) view).getText().toString();
                CreateAccountSuccessActivity.accountToBeViewed =
                                     port.getAccountByName(accountName);
                intent.putExtra(ACCOUNT_NAME, accountName);
                startActivity(intent); 
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.create_account_success, menu);
        return true;
    }
    
    public void viewReport(View view) {
        Intent intent  = new Intent(this, CreateReportActivity.class);
        intent.putExtra(USERNAME, username);
        startActivity(intent);
    }

    
}
