package com.example.eventmanagement;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class SplashActivity extends Activity {
	
	
	String imei;
	String im1="911363957420565";
    String im2="911363957622566";
    String im3="911416956079772";
    String im4="911416956180802";
    String im5="355672055919440";
    String im6="867371029078240";
    String im7="867371029078232";
    String im8="355672055919432";
	
	protected void onCreate(Bundle savedInstanceState) 
	{
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		 
		TelephonyManager tm = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);

	    // get IMEI
	    imei = tm.getDeviceId();

		Thread t1=new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(im1.equals(imei)||im2.equals(imei)||im3.equals(imei)||im4.equals(imei)||im5.equals(imei)||im6.equals(imei)||im7.equals(imei)||im8.equals(imei))
				{
					Intent i= new Intent(SplashActivity.this,LoginActivity.class);
					startActivity(i);
				
				}
				/*else
				{
					Toast.makeText(getApplicationContext(), "Not Authinticated user",Toast.LENGTH_SHORT).show();
				}*/
			                
				/*Intent i= new Intent(SplashActivity.this,MainActivity.class);
				startActivity(i);*/
				finish();
				
			}
			};
			t1.start();
	}

 
}

