package com.mamlambo.clicktracker;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.apps.analytics.GoogleAnalyticsTracker;

public class ClickTrackerActivity extends Activity {
	
	GoogleAnalyticsTracker tracker; 
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
        // Start your statistics tracking
        tracker = GoogleAnalyticsTracker.getInstance();     
        tracker.start("UA-24060381-1", 30, this);  

        setContentView(R.layout.main);
        tracker.trackPageView("/ClickTracker-Main-Screen"); 
        
    }
    
    
    
    @Override
	protected void onDestroy() {
		super.onDestroy();
		tracker.stop();
	}



	public void onClickHighButton(View v)
    {
    	// High button clicked.
    	Toast.makeText(ClickTrackerActivity.this, "Chose the High Road", Toast.LENGTH_SHORT).show();
    	tracker.trackEvent("Clicks", "Button", "High Road", 0); 
    }

    public void onClickLowButton(View v)
    {
    	// High button clicked.
    	Toast.makeText(ClickTrackerActivity.this, "Chose the Low Road", Toast.LENGTH_SHORT).show();
    	tracker.trackEvent("Clicks", "Button", "Low Road", 0); 
    }
}