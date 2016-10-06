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

public class RegisterInfoActivity extends Activity {

	TextView fname1,lname1,college1,mob_no1,email1,fname2,lname2,college2,mob_no2,email2;
	TextView fname3,lname3,college3,mob_no3,email3,fname4,lname4,college4,mob_no4,email4;
	
	TextView feepaid,feebal,regmob;
	
	DBController controller = new DBController(this);
	String Id;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register_info);
		
		fname1=(TextView)findViewById(R.id.fname1);
		lname1=(TextView)findViewById(R.id.lname1);
		college1=(TextView)findViewById(R.id.college1);
		mob_no1=(TextView)findViewById(R.id.mob_no1);
		email1=(TextView)findViewById(R.id.email1);
		
		fname2=(TextView)findViewById(R.id.fname2);
		lname2=(TextView)findViewById(R.id.lname2);
		college2=(TextView)findViewById(R.id.college2);
		mob_no2=(TextView)findViewById(R.id.mob_no2);
		email2=(TextView)findViewById(R.id.email2);
		
		fname3=(TextView)findViewById(R.id.fname3);
		lname3=(TextView)findViewById(R.id.lname3);
		college3=(TextView)findViewById(R.id.college3);
		mob_no3=(TextView)findViewById(R.id.mob_no3);
		email3=(TextView)findViewById(R.id.email3);
		
		fname4=(TextView)findViewById(R.id.fname4);
		lname4=(TextView)findViewById(R.id.lname4);
		college4=(TextView)findViewById(R.id.college4);
		mob_no4=(TextView)findViewById(R.id.mob_no4);
		email4=(TextView)findViewById(R.id.email4);
		
		feepaid=(TextView)findViewById(R.id.feepaid);
		feebal=(TextView)findViewById(R.id.feebal);
		regmob=(TextView)findViewById(R.id.regmob);
		
		Id=getIntent().getStringExtra("registerId");
		
			}
		
	
	public void inforegister(View view) 
	{
			
		Intent objIntent = getIntent();
		String registerId = objIntent.getStringExtra("registerId");
		
		HashMap<String, String> registerList = controller.getregisterInfo(registerId);
		
		
			fname1.setText("Name          :  "+registerList.get("fname1")+"  ");
		    lname1.setText(registerList.get("lname1"));
		    college1.setText("College Name:  "+registerList.get("college1"));
		    mob_no1.setText("Contact      :  "+registerList.get("mob_no1"));
		    email1.setText("Email         :  "+registerList.get("email1")+"\n");
		
		    fname2.setText("Name          :  "+registerList.get("fname2")+"  ");
		    lname2.setText(registerList.get("lname2"));
		    college2.setText("College Name:  "+registerList.get("college2"));
		    mob_no2.setText("Contact      :  "+registerList.get("mob_no2"));
		    email2.setText("Email         :  "+registerList.get("email2")+"\n");
		    
		    fname3.setText("Name          :  "+registerList.get("fname3")+"  ");
		    lname3.setText(registerList.get("lname3"));
		    college3.setText("College Name:  "+registerList.get("college3"));
		    mob_no3.setText("Contact      :  "+registerList.get("mob_no3"));
		    email3.setText("Email         :  "+registerList.get("email3")+"\n");
		    
		    fname4.setText("Name          :  "+registerList.get("fname4")+"  ");
		    lname4.setText(registerList.get("lname4"));
		    college4.setText("College Name:  "+registerList.get("college4"));
		    mob_no4.setText("Contact      :  "+registerList.get("mob_no4"));
		    email4.setText("Email         :  "+registerList.get("email4")+"\n");
		
		    
		    feepaid.setText("Fee Paid     :  "+registerList.get("fee"));
		    feebal.setText("Fee Balance   :  "+registerList.get("bal"));
		    regmob.setText("Registered By :  "+registerList.get("regmob"));
		
		
	}
	public void callHomeActivity(View view) 
	{
		Intent objIntent = new Intent(getApplicationContext(), RegisterActivity.class);
		objIntent.putExtra("registerId", Id);
		startActivity(objIntent);
	}
}
