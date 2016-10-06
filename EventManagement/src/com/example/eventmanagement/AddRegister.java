package com.example.eventmanagement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

















import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class AddRegister extends Activity
{
	EditText fname1,lname1,college1,mob_no1,email1,fname2,lname2,college2,mob_no2,email2;
	EditText fname3,lname3,college3,mob_no3,email3,fname4,lname4,college4,mob_no4,email4;
	
	EditText fee,regmob;
	
	DBController controller = new DBController(this);
	String eId, smsText,mobile;
	    
	    
	 @Override
	    public void onCreate(Bundle savedInstanceState) 
	 	{
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.add_new_register);
	        
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
	        
	        eId=getIntent().getStringExtra("eventId");
	        


	    }
	
	 public void addNewentry(View view) 
	 {
		 
		 Calendar c = Calendar.getInstance();
		// System.out.println("Current time => " + c.getTime());

		 SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		 String date1 = df.format(c.getTime());

		 //calculating balance
		 HashMap<String, String> eventList = controller.geteventInfo(eId);
		 
		 String total=eventList.get("fee");
		 int tot=Integer.parseInt(total);
		 String paid=fee.getText().toString();
		 int amt=Integer.parseInt(paid);
		 int balance=tot-amt;
		
		 
		HashMap<String, String> queryValues =  new  HashMap<String, String>();
		queryValues.put("eventId", eId);
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
		queryValues.put("bal", Integer.toString(balance));
		queryValues.put("registered_date", date1);
		queryValues.put("regmob", regmob.getText().toString());
		controller.insertregister(queryValues);
		
		
		HashMap<String, String> eventList1 = controller.geteventInfo(eId);
		
		String eventName=eventList.get("eventName");
		String date=eventList.get("date");
		 mobile=mob_no1.getText().toString();
		System.out.println(mobile);
		 
		 smsText = "Hello  "+fname1.getText().toString()+"  "+lname1.getText().toString()+"  "+fname2.getText().toString()+" "+lname2.getText().toString()+"  "+fname3.getText().toString()+" "+lname3.getText().toString()+"  "+fname4.getText().toString()+" "+lname4.getText().toString()+", you have successfully registered for the "+eventName+" SPECTRUM "+"\nRegistered Date : "+date1+" .\nEvent Date :"+date+" at PCCOE \nFees Paid : "+fee.getText().toString()+"\nBalance amount : "+Integer.toString(balance)+"\nRegistered By : "+regmob.getText().toString()+".\nThank you.\nFor more details visit : www.spectrum2016.com";
		 
		try 
		  {
	          SmsManager sms = SmsManager.getDefault();
		      ArrayList<String> parts = sms.divideMessage(smsText);
		      sms.sendMultipartTextMessage(mobile, null, parts, null, null);
	          Toast.makeText(getApplicationContext(), "SMS Sent!",Toast.LENGTH_SHORT).show();
	      } 
		  catch (Exception e) 
		  {
	            Toast.makeText(getApplicationContext(),
	                "SMS faild, please try again later!",
	                        Toast.LENGTH_SHORT).show();
	            e.printStackTrace();

	      }
		 
		this.callHomeActivity(view);
		
	}
	
	 public void callHomeActivity(View view) 
	 {
		 finish();
		Intent objIntent = new Intent(getApplicationContext(), RegisterActivity.class);
		objIntent.putExtra("eventId", eId); 
		startActivity(objIntent);
	}	
}
