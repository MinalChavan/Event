package com.example.eventmanagement;

import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class InfoActivity extends Activity {

	TextView eventName,fees,date,location;
	DBController controller = new DBController(this);
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_info);
		
		eventName=(TextView)findViewById(R.id.event);
		fees=(TextView)findViewById(R.id.fee);
		date=(TextView)findViewById(R.id.date);
		location=(TextView)findViewById(R.id.location);
		
			}
		
	public void infoevent(View view) 
	{
		
		Intent objIntent = getIntent();
		String eventId = objIntent.getStringExtra("eventId");
		
		HashMap<String, String> eventList = controller.geteventInfo(eventId);
		
		eventName.setText("Event    :  "+eventList.get("eventName"));
		     fees.setText("Fees     :  "+eventList.get("fee"));
		     date.setText("Date     :  "+eventList.get("date"));
		 location.setText("Location :  "+eventList.get("location"));
		
		
	}
	public void callHomeActivity(View view) 
	{
		Intent objIntent = new Intent(getApplicationContext(), MainActivity.class);
		startActivity(objIntent);
	}
}
