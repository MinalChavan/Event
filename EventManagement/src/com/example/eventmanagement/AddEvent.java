package com.example.eventmanagement;

import java.util.Calendar;
import java.util.HashMap;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class AddEvent extends Activity
{
	EditText eventName,fee,date,location;
	DBController controller = new DBController(this);
	
	 @Override
	    public void onCreate(Bundle savedInstanceState) 
	    {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.add_new_event);
	        
	        eventName = (EditText) findViewById(R.id.eventName);
	        fee = (EditText) findViewById(R.id.fee);
	        date = (EditText) findViewById(R.id.date);
	        location = (EditText) findViewById(R.id.location);
	    }
	 
	 	public void addNewevent(View view) 
	 	{
	 		HashMap<String, String> queryValues =  new  HashMap<String, String>();
	 		
	 		queryValues.put("eventName", eventName.getText().toString());
	 		queryValues.put("date", date.getText().toString());
	 		queryValues.put("location", location.getText().toString());
	 		queryValues.put("fee", fee.getText().toString());
	 		controller.insertevent(queryValues);
		
	 		/*Calendar cal = Calendar.getInstance();              
	 		Intent intent = new Intent(Intent.ACTION_EDIT);
	 		intent.setType("vnd.android.cursor.item/event");
			intent.putExtra("beginTime", cal.getTimeInMillis());
			intent.putExtra("endTime", cal.getTimeInMillis()+60*60*1000);
			intent.putExtra("title",  eventName.getText().toString());
			intent.putExtra("Location",location.getText().toString());
		    startActivity(intent);*/

		this.callHomeActivity(view);
	 	}
	
	 	public void callHomeActivity(View view) 
	 	{
	 		finish();
			Intent objIntent = new Intent(getApplicationContext(), MainActivity.class);
			startActivity(objIntent);
	 	}	
}