package com.nickelheim.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import com.nickelheim.R;
import com.nickelheim.presenters.CreateReportButtonListener;
import com.nickelheim.views.CreateReportActivityInterface;

/**
 * Activity to display page for creating a report.
 * 
 * @author Nickelheim
 *
 */
public class CreateReportActivity extends Activity implements 
                                                CreateReportActivityInterface {
    /**
     * listener instance variable.
     */
    private CreateReportButtonListener listener;
    /**
     * startDateField instance variable.
     */
    private EditText startDateField;
    /**
     * endDateField instance variable.
     */
    private EditText endDateField;
    /**
     * username instance variable.
     */
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
    /**
     * returns startDate as a string.
     * 
     * @return string representing the start date
     */
    public String getStartDate() {
        return startDateField.getText().toString();
    }
    /**
     * returns endDate as a string.
     * 
     * @return string representing the end date
     */
    public String getEndDate() {
        return endDateField.getText().toString();
    }
    /**
     * returns username as a string.
     * 
     * @return string representing the username
     */
    public String getUsername() {
    	return username;
    }
    /**
     * show report method activated by button click.
     * 
     * @param view which is this activity
     */
    public void showReport(View view) {
        listener.showReport();
    }
}
