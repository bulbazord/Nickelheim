package com.nickelheim.views;

import android.view.View;

/**
 * Interface for CreateReport Activity.
 * 
 * @author Nickelheim
 */
public interface CreateReportActivityInterface {
    /**
     * returns startDate as a string.
     * 
     * @return string representing the start date
     */
    String getStartDate();
    /**
     * returns endDate as a string.
     * 
     * @return string representing the end date
     */
    String getEndDate();
    /**
     * returns username as a string.
     * 
     * @return string representing the username
     */
    String getUsername();
    /**
     * show report method activated by button click.
     * 
     * @param view which is this activity
     */
    void showReport(View view);
}
