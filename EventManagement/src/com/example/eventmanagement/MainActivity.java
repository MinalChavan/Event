package com.example.eventmanagement;

import java.util.ArrayList;
import java.util.HashMap;
import android.os.Bundle;
import android.app.ListActivity;

import android.content.Intent;

import android.view.View;


import android.widget.AdapterView;

import android.widget.AdapterView.OnItemClickListener;

import android.widget.ListAdapter;

import android.widget.SimpleAdapter;

import android.widget.TextView;

import android.widget.ListView;

public class MainActivity extends ListActivity {
	
Intent intent;
	
TextView eventId;
	
DBController controller = new DBController(this);

	@Override

	protected void onCreate(Bundle savedInstanceState) 
	{
	
	super.onCreate(savedInstanceState);
		
setContentView(R.layout.activity_main);

ArrayList<HashMap<String, String>> eventList =  controller.getAllevents();
		
if(eventList.size()!=0) {
		
	ListView lv = getListView();
	
		lv.setOnItemClickListener(new OnItemClickListener() 
		{
		
		  @Override 
				
  public void onItemClick(AdapterView<?> parent, View view,int position, long id) 
		  {
		
			  eventId = (TextView) view.findViewById(R.id.eventId);
		
			  String  valeventId = eventId.getText().toString();	
				
	Intent  objIndent = new Intent(MainActivity.this,SecondActivity.class);
	
				  objIndent.putExtra("eventId", valeventId); 
	
				  //finish();
			  startActivity(objIndent); 
				
  }
			}); 
			
ListAdapter adapter = new SimpleAdapter( MainActivity.this,eventList, R.layout.view_event_entry, new String[] { "eventId","eventName"}, new int[] {R.id.eventId, R.id.eventName}); 

			setListAdapter(adapter);

		}

	}
	
public void showAddForm(View view) 
{
	
	Intent objIntent = new Intent(getApplicationContext(),AddEvent.class);
	
	startActivity(objIntent);
	}
}

