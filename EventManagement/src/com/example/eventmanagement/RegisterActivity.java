package com.example.eventmanagement;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class RegisterActivity extends ListActivity {
	Intent intent;
	String id;
	TextView registerId;
	
	DBController controller = new DBController(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
		id=getIntent().getStringExtra("eventId");
		
				
				ArrayList<HashMap<String, String>> registerList =  controller.getAllregisters(id);
				
				if(registerList.size()!=0) 
				{
						
					ListView lv = getListView();
					
				lv.setOnItemClickListener(new OnItemClickListener() 
				{
						
						  @Override 
								
				public void onItemClick(AdapterView<?> parent, View view,int position, long id) 
						  {
						
							  registerId = (TextView) view.findViewById(R.id.registerId);
						
							  String  valregisterId = registerId.getText().toString();	
								
					Intent  objIndent = new Intent(getApplicationContext(),ThirdActivity.class);
					
								  objIndent.putExtra("registerId", valregisterId); 
					
								  finish();
							  startActivity(objIndent); 
								
				  }
				}); 
							
				ListAdapter adapter = new SimpleAdapter( RegisterActivity.this,registerList, R.layout.view_register_entry, new String[] { "registerId","fname1","lname1"}, new int[] {R.id.registerId, R.id.fname1,R.id.lname1}); 

							setListAdapter(adapter);

			}

		}
			
		public void showAddRegisterForm(View view) 
		{
			
			
			Intent objIntent = new Intent(getApplicationContext(),AddRegister.class);
			objIntent.putExtra("eventId", id);
			startActivity(objIntent);
			}


}
