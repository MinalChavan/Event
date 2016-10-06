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

public class ThirdActivity extends Activity {
	
	TextView t1;
	Button edit,details;
	
	String Id;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_third);
	
		 
		 t1=(TextView)findViewById(R.id.textView2);
		edit=(Button)findViewById(R.id.edit_button);
		details=(Button)findViewById(R.id.info_button);
		
		Id=getIntent().getStringExtra("registerId");
		
		edit.setOnClickListener(new OnClickListener() 
		{
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent  objIndent = new Intent(ThirdActivity.this,EditRegisterActivity.class);
					
					objIndent.putExtra("registerId", Id); 
			
				  startActivity(objIndent);
				  
			}
		});
		
		details.setOnClickListener(new OnClickListener() 
		{
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 
				Intent  objIndent = new Intent(getApplicationContext(),RegisterInfoActivity.class);
					
					objIndent.putExtra("registerId", Id); 
			
				  startActivity(objIndent);
				 
			}
		});
		
		
	}
	
	
}
