package com.example.eventmanagement;

import java.util.HashMap;







import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;

public class EditEventActivity extends Activity{
	EditText eventName,date,location,fee;
	DBController controller = new DBController(this);
	
	 @Override
	    public void onCreate(Bundle savedInstanceState) 
	 {
		 	super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_edit_event);
			
			eventName = (EditText) findViewById(R.id.eventName);
			date = (EditText) findViewById(R.id.date);
			location = (EditText) findViewById(R.id.location);
			fee = (EditText) findViewById(R.id.fee);
			
			Intent objIntent = getIntent();
			String eventId = objIntent.getStringExtra("eventId");
			
			Log.d("Reading: ", "Reading all contacts..");
			
			HashMap<String, String> eventList = controller.geteventInfo(eventId);
			
			Log.d("eventName",eventList.get("eventName"));
			if(eventList.size()!=0) {
			eventName.setText(eventList.get("eventName"));
			date.setText(eventList.get("date"));
			location.setText(eventList.get("location"));
			fee.setText(eventList.get("fee"));

			
			}
			
			
	    }
	public void editevent(View view) 
	{
		HashMap<String, String> queryValues =  new  HashMap<String, String>();
		
		eventName = (EditText) findViewById(R.id.eventName);
		
		Intent objIntent = getIntent();
		String eventId = objIntent.getStringExtra("eventId");
		
		queryValues.put("eventId", eventId);
		queryValues.put("eventName", eventName.getText().toString());
		queryValues.put("date", date.getText().toString());
		queryValues.put("location", location.getText().toString());
		queryValues.put("fee", fee.getText().toString());
		controller.updateevent(queryValues);
		
		Toast.makeText(getApplicationContext(), "Changed successfully !!",
                Toast.LENGTH_SHORT).show();
		
		this.callHomeActivity(view);
		
	}
	public void removeevent(View view) 
	{
		Intent objIntent = getIntent();
		String eventId = objIntent.getStringExtra("eventId");
		controller.deleteevent(eventId);
		
		Toast.makeText(getApplicationContext(), "Event Deleted !!",
                Toast.LENGTH_SHORT).show();


		this.callHomeActivity(view);
		
	}
	public void callHomeActivity(View view) 
	{
		finish();
		Intent objIntent = new Intent(getApplicationContext(), MainActivity.class);
		startActivity(objIntent);
	}
}



