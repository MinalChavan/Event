package com.example.eventmanagement;

import java.util.HashMap;










import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import android.app.Activity;
import android.content.Intent;
import android.view.View;

public class EditRegisterActivity extends Activity{
	EditText fname1,lname1,college1,mob_no1,email1,fname2,lname2,college2,mob_no2,email2;
	EditText fname3,lname3,college3,mob_no3,email3,fname4,lname4,college4,mob_no4,email4;
	
	EditText fee,regmob;
	
	DBController controller = new DBController(this);
	String registerId,eventId;
	
   
	 @Override
	    public void onCreate(Bundle savedInstanceState) 
	 {
		 	super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_edit_register);
			
			    fname1 = (EditText) findViewById(R.id.fname1);
		        lname1 = (EditText) findViewById(R.id.lname1);
		        college1 = (EditText) findViewById(R.id.college1);
		        mob_no1 = (EditText) findViewById(R.id.mob_no1);
		        email1 = (EditText) findViewById(R.id.email1);
		        
		        fname2 = (EditText) findViewById(R.id.fname2);
		        lname2 = (EditText) findViewById(R.id.lname2);
		        college2 = (EditText) findViewById(R.id.college2);
		        mob_no2 = (EditText) findViewById(R.id.mob_no2);
		        email2 = (EditText) findViewById(R.id.email2);
		        
		        fname3 = (EditText) findViewById(R.id.fname3);
		        lname3 = (EditText) findViewById(R.id.lname3);
		        college3 = (EditText) findViewById(R.id.college3);
		        mob_no3 = (EditText) findViewById(R.id.mob_no3);
		        email3 = (EditText) findViewById(R.id.email3);
		        
		        fname4 = (EditText) findViewById(R.id.fname4);
		        lname4 = (EditText) findViewById(R.id.lname4);
		        college4 = (EditText) findViewById(R.id.college4);
		        mob_no4 = (EditText) findViewById(R.id.mob_no4);
		        email4 = (EditText) findViewById(R.id.email4);
		        
		        fee = (EditText) findViewById(R.id.fee);
		        regmob = (EditText) findViewById(R.id.regmob);

			
			Intent objIntent = getIntent();
			 registerId = objIntent.getStringExtra("registerId");
			 
			HashMap<String, String> registerList = controller.getregisterInfo(registerId);
			eventId=registerList.get("eventId");
			if(registerList.size()!=0) {
			fname1.setText(registerList.get("fname1"));
			lname1.setText(registerList.get("lname1"));
			college1.setText(registerList.get("college1"));
		    mob_no1.setText(registerList.get("mob_no1"));
		   email1.setText(registerList.get("email1"));
		   
		   fname2.setText(registerList.get("fname2"));
			lname2.setText(registerList.get("lname2"));
			college2.setText(registerList.get("college2"));
		    mob_no2.setText(registerList.get("mob_no2"));
		   email2.setText(registerList.get("email2"));
		   
		   fname3.setText(registerList.get("fname3"));
			lname3.setText(registerList.get("lname3"));
			college3.setText(registerList.get("college3"));
		    mob_no3.setText(registerList.get("mob_no3"));
		   email3.setText(registerList.get("email3"));
		   
		   fname4.setText(registerList.get("fname4"));
			lname4.setText(registerList.get("lname4"));
			college4.setText(registerList.get("college4"));
		    mob_no4.setText(registerList.get("mob_no4"));
		   email4.setText(registerList.get("email4"));
		   
		   fee.setText(registerList.get("fee"));
		   regmob.setText(registerList.get("regmob"));
		   
		   
			}
			
			
	    }
	public void editentry(View view) 
	{
		
		 HashMap<String, String> registerList = controller.getregisterInfo(registerId);
		 
		 //calculating balance amount
		 String paid1=registerList.get("fee");
		 int tot=Integer.parseInt(paid1);
		 
		 String paid=fee.getText().toString();
		 int amt=Integer.parseInt(paid);
		 
		 int balance=tot-amt;
		 
		 String balance1=registerList.get("bal");
		 
		 int bal1=Integer.parseInt(balance1);
		 int newbal=bal1+balance;
		 
		HashMap<String, String> queryValues =  new  HashMap<String, String>();
		
		Intent objIntent = getIntent();
		 registerId = objIntent.getStringExtra("registerId");
		queryValues.put("registerId", registerId);
		queryValues.put("fname1", fname1.getText().toString());
		queryValues.put("lname1", lname1.getText().toString());
		queryValues.put("college1", college1.getText().toString());
		queryValues.put("mob_no1", mob_no1.getText().toString());
		queryValues.put("email1", email1.getText().toString());
		
		queryValues.put("fname2", fname2.getText().toString());
		queryValues.put("lname2", lname2.getText().toString());
		queryValues.put("college2", college2.getText().toString());
		queryValues.put("mob_no2", mob_no2.getText().toString());
		queryValues.put("email2", email2.getText().toString());
		
		queryValues.put("fname3", fname3.getText().toString());
		queryValues.put("lname3", lname3.getText().toString());
		queryValues.put("college3", college3.getText().toString());
		queryValues.put("mob_no3", mob_no3.getText().toString());
		queryValues.put("email3", email3.getText().toString());
		
		queryValues.put("fname4", fname4.getText().toString());
		queryValues.put("lname4", lname4.getText().toString());
		queryValues.put("college4", college4.getText().toString());
		queryValues.put("mob_no4", mob_no4.getText().toString());
		queryValues.put("email4", email4.getText().toString());
		
		queryValues.put("fee", fee.getText().toString());
		queryValues.put("bal", Integer.toString(newbal));
		queryValues.put("regmob", regmob.getText().toString());
		
		
		controller.updateregister(queryValues);
		Toast.makeText(getApplicationContext(), "Entry Edited !!",
                Toast.LENGTH_SHORT).show();
		this.callHomeActivity(view);
		
	}
	public void removeentry(View view) 
	{
		Intent objIntent = getIntent();
		 registerId = objIntent.getStringExtra("registerId");
		controller.deleteregister(registerId);
		Toast.makeText(getApplicationContext(), "Entry Removed !!",
                Toast.LENGTH_SHORT).show();
		this.callHomeActivity(view);
		
	}
	public void callHomeActivity(View view) 
	{
		finish();
		Intent objIntent1 = new Intent(getApplicationContext(), RegisterActivity.class);
		objIntent1.putExtra("eventId", eventId);
		startActivity(objIntent1);
	}
}



