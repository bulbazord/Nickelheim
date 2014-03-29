package com.nickelheim.activities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.widget.TextView;

import com.nickelheim.R;
import com.nickelheim.models.Transaction;
import com.nickelheim.models.TransactionList;
import com.nickelheim.presenters.CreateReportButtonListener;

public class CreateReportSuccessActivity extends Activity {
    List<Transaction> transactionList;
    private TextView transactionField;
    private String startDate;
    private String endDate;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_report_success);
        transactionList = TransactionList.getInstance().getList();
        
        startDate =this.getIntent().getExtras().getString(
                CreateReportButtonListener.START_DATE);
        
        endDate =this.getIntent().getExtras().getString(
                CreateReportButtonListener.END_DATE);
        
        username =this.getIntent().getExtras().getString(
                CreateReportButtonListener.USERNAME);
        
        long startTime = startDateToSeconds(startDate);
        //System.out.println("startTime = " + startTime);
        
        long endTime = endDateToSeconds(endDate);
        //System.out.println("endTime = " + endTime);
        
        transactionField =  (TextView) findViewById(R.id.transactions);
        transactionField.setMovementMethod(new ScrollingMovementMethod());
        for (Transaction transaction : transactionList) {
            if((transaction.getTimestamp() >= startTime) && (transaction.getTimestamp() <= endTime)
            		&& (transaction.getAccountUsername().equals(username))) {
                transactionField.append(transaction.toString() + "\n" + "\n");
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.create_report_success, menu);
        return true;
    }
    
    public long startDateToSeconds (String startDate) {
        String startDateWithSeconds = startDate + " 00:00:00";
        //System.out.println("startDateWithSeconds = "+ startDateWithSeconds);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMddyyy HH:mm:ss");
        try {
            Date date = simpleDateFormat.parse(startDateWithSeconds);
            long milliseconds = date.getTime();
            return milliseconds;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0; 
    }
    
    public long endDateToSeconds (String endDate) {
        String endDateWithSeconds = endDate + " 23:59:59";
        //System.out.println("endDateWithSeconds = "+ endDateWithSeconds );
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMddyyy HH:mm:ss");
        try {
            Date date = simpleDateFormat.parse(endDateWithSeconds);
            long milliseconds = date.getTime();
            return milliseconds;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0; 
    }

}


