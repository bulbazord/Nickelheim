package com.nickelheim.activities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.widget.TextView;

import com.nickelheim.R;
import com.nickelheim.models.Transaction;
import com.nickelheim.models.TransactionList;
import com.nickelheim.presenters.CreateReportButtonListener;

/**
 * Class that shows the page after user successfully creates a report.
 * 
 * @author Nickelheim
 */
public class CreateReportSuccessActivity extends Activity {
    /**
     * transactionList instance variable.
     */
    List<Transaction> transactionList;
    /**
     * transactionField instance variable.
     */
    private TextView transactionField;
    /**
     * startDate instance variable.
     */
    private String startDate;
    /**
     * endDate instance variable.
     */
    private String endDate;
    /**
     * username instance variable.
     */
    private String username;
    /**
     * dateFormat instance variable.
     */
    private String dateFormat = "MMddyyy HH:mm:ss";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_report_success);
        transactionList = TransactionList.getInstance().getTransactionList();
        
        startDate = this.getIntent().getExtras().getString(
                CreateReportButtonListener.START_DATE);
        
        endDate = this.getIntent().getExtras().getString(
                CreateReportButtonListener.END_DATE);
        
        username = this.getIntent().getExtras().getString(
                CreateReportButtonListener.USERNAME);
        
        long startTime = startDateToSeconds(startDate);
        //System.out.println("startTime = " + startTime);
        
        long endTime = endDateToSeconds(endDate);
        //System.out.println("endTime = " + endTime);
        
        transactionField =  (TextView) findViewById(R.id.transactions);
        transactionField.setMovementMethod(new ScrollingMovementMethod());
        for (Transaction transaction : transactionList) {
            if ((transaction.getTimestamp() >= startTime) && (transaction.getTimestamp() <= endTime)
            		&& (transaction.getAccountUsername().equals(username))) {
                transactionField.append(transaction.toString() + "\n");
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.create_report_success, menu);
        return true;
    }
    /**
     * converts start date into seconds.
     * 
     * @param startingDate is the start date as a String
     * @return seconds as a long
     */
    public long startDateToSeconds (String startingDate) {
        String startDateWithSeconds = startingDate + " 00:00:00";
        //System.out.println("startDateWithSeconds = "+ startDateWithSeconds);
        SimpleDateFormat simpleDateFormat = 
                                    new SimpleDateFormat(dateFormat, Locale.US);
        try {
            Date date = simpleDateFormat.parse(startDateWithSeconds);
            long milliseconds = date.getTime();
            return milliseconds;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0; 
    }
    /**
     * converts end date into seconds.
     * 
     * @param endingDate is the end date
     * @return seconds as a long
     */
    public long endDateToSeconds (String endingDate) {
        String endDateWithSeconds = endingDate + " 23:59:59";
        //System.out.println("endDateWithSeconds = "+ endDateWithSeconds );
        SimpleDateFormat simpleDateFormat = 
                                    new SimpleDateFormat(dateFormat, Locale.US);
        try {
            Date date = simpleDateFormat.parse(endDateWithSeconds);
            long milliseconds = date.getTime();
            return milliseconds;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0; 
    }

}


