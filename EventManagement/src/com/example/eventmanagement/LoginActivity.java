package com.example.eventmanagement;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {

	EditText pass;
	Button login;
	TextView tv1;
	String password="2016spectrum";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		pass=(EditText)findViewById(R.id.pass);
		tv1=(TextView)findViewById(R.id.textView1);
		login=(Button)findViewById(R.id.login);
		
		login.setOnClickListener(new OnClickListener() 
		{
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(password.equals(pass.getText().toString()))
				{
					Intent  in = new Intent(LoginActivity.this,MainActivity.class);
					finish();
					startActivity(in);
				}
				else
				{
					//Toast.makeText(getApplicationContext(), "Not Authinticated user",Toast.LENGTH_SHORT).show();
					tv1.setText(pass.getText().toString());
				}
					
					
			}
		});
	}

	
}
