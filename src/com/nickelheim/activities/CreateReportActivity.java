package com.nickelheim.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import com.nickelheim.R;
import com.nickelheim.presenters.CreateAccountButtonListener;
import com.nickelheim.presenters.CreateReportButtonListener;
import com.nickelheim.views.CreateReportActivityInterface;

public class CreateReportActivity extends Activity implements 
                                                CreateReportActivityInterface {
    private CreateReportButtonListener listener;
    private EditText startDateField;
    private EditText endDateField;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_report);
        username = this.getIntent().getExtras().getString(CreateAccountSuccessActivity.USERNAME);
        listener = new CreateReportButtonListener(this, this);

        startDateField =  (EditText) findViewById(R.id.start_date_input);
        endDateField =  (EditText) findViewById(R.id.end_date_input);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.report, menu);
        return true;
    }

    public String getStartDate() {
        return startDateField.getText().toString();
    }
    
    public String getEndDate() {
        return endDateField.getText().toString();
    }
    
    public String getUsername() {
    	return username;
    }
    
    public void showReport(View view) {
        listener.showReport();
    }

}
