package com.nickelheim.presenters;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.nickelheim.activities.CreateReportActivity;
import com.nickelheim.activities.CreateReportSuccessActivity;


/**
 * Presenter for creating a report.
 * 
 * @author Nickelheim
 *
 */
public class CreateReportButtonListener {
    /**
     * START_DATE instance variable.
     */
    public static final String START_DATE = "start date";
    /**
     * END_DATE instance variable.
     */
    public static final String END_DATE = "end date";
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
    private CreateReportActivity view;
    /**
     * constructor.
     * 
     * @param viewInput is the view
     * @param contextInput is the context
     */
    public CreateReportButtonListener(CreateReportActivity viewInput, 
                                                         Context contextInput) {
        this.view = viewInput;
        this.context = contextInput;
    }
    /**
     * method to show the report.
     */
    public void showReport() {
        String startDate = view.getStartDate();
        String endDate = view.getEndDate();
        String username = view.getUsername();
        if (isValidDate(startDate) && isValidDate(endDate)) {
            Intent intent  = new Intent(view, CreateReportSuccessActivity.class);
            intent.putExtra(START_DATE, startDate);
            intent.putExtra(END_DATE, endDate);
            intent.putExtra(USERNAME, username);
            view.startActivity(intent);
        } else {
            Toast.makeText(this.context, "Create report not successful." 
                                    + "  Try again.", Toast.LENGTH_LONG).show();
        }
    }
    /**
     * determines validity of date string.
     * @param dateString is the date string
     * @return boolean
     */
    public boolean isValidDate(String dateString) {
        if (dateString.length() < 8) {
            return false;
        }
        return true;
    }

}
