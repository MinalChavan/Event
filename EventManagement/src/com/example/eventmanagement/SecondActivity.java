package com.example.eventmanagement;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends Activity {
	
	TextView t1;
	Button edit,details,reg;
	String EventId;
	String Id;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
	
		 
		 t1=(TextView)findViewById(R.id.textView2);
		edit=(Button)findViewById(R.id.edit_button);
		details=(Button)findViewById(R.id.info_button);
		reg=(Button)findViewById(R.id.reg_button);
		Id=getIntent().getStringExtra("eventId");
		
		 

		
        edit.setOnClickListener(new OnClickListener() 
        {
			
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				
				Intent  objIndent = new Intent(SecondActivity.this,EditEventActivity.class);
					
					objIndent.putExtra("eventId", Id); 
			
				  startActivity(objIndent);
				
			}
		});
		
		details.setOnClickListener(new OnClickListener() 
		{
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 
				Intent  objIndent = new Intent(getApplicationContext(),InfoActivity.class);
					
					objIndent.putExtra("eventId", Id); 
			
				  startActivity(objIndent);
				
			}
		});
		
		reg.setOnClickListener(new OnClickListener() 
		{
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent  objIndent = new Intent(SecondActivity.this,RegisterActivity.class);
				
				objIndent.putExtra("eventId", Id); 
		
			  startActivity(objIndent);
			}
		});
	}
	
	
}
