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

import com.nickelheim.R;
import com.nickelheim.models.Account;
import com.nickelheim.models.AccountList;
import com.nickelheim.presenters.CreateAccountButtonListener;
import com.nickelheim.presenters.LoginButtonListener;

public class CreateAccountSuccessActivity extends Activity {
    
    public static final String ACCOUNT_NAME = "account name";
    public static final String USERNAME = "username";
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account_success);
        username = this.getIntent().getExtras().getString(CreateAccountButtonListener.USERNAME);
        
        List<Account> accountList = 
                                    AccountList.getInstance().getListByUsername(username);
        
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
