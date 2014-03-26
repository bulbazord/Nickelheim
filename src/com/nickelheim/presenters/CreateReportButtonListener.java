package com.nickelheim.presenters;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.nickelheim.activities.CreateReportActivity;
import com.nickelheim.activities.CreateReportSuccessActivity;

public class CreateReportButtonListener {
    public static final String START_DATE = "start date";
    public static final String END_DATE = "end date";
    private Context context;
    private CreateReportActivity view;
    
    public CreateReportButtonListener(CreateReportActivity view, 
                                                            Context context) {
        this.view = view;
        this.context = context;
    }
    
    public void showReport() {
        String startDate = view.getStartDate();
        String endDate = view.getEndDate();
        if (isValid(startDate) && isValid(endDate)) {
            Intent intent  = new Intent(view, CreateReportSuccessActivity.class);
            intent.putExtra(START_DATE, startDate);
            intent.putExtra(END_DATE, endDate);
            view.startActivity(intent);
        } else {
            Toast.makeText(this.context, "Create report not successful." + 
                                "  Try again.", Toast.LENGTH_LONG).show();
        }
    }
    
    public boolean isValid(String string) {
        if (string.length() < 8) {
            return false;
        }
        return true;
    }

}
