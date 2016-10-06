package com.example.eventmanagement;

import java.util.ArrayList;
import java.util.HashMap;

import android.util.Log;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBController  extends SQLiteOpenHelper {
	private static final String LOGCAT = null;

	public DBController(Context applicationcontext) {
        super(applicationcontext, "androidsqlite.db", null, 1);
        Log.d(LOGCAT,"Created");
    }
	
	
	@Override
	public void onCreate(SQLiteDatabase database) {
		String query1,query2;
		query1 = "CREATE TABLE event ( eventId INTEGER PRIMARY KEY, eventName TEXT,date TEXT,location TEXT,fee TEXT)";
        database.execSQL(query1);
        Log.d(LOGCAT,"event Created");
        query2 = "CREATE TABLE register ( registerId INTEGER PRIMARY KEY,eventId INTEGER,fname1  TEXT ,lname1  TEXT , college1  TEXT ,mob_no1  TEXT ,email1  TEXT,fname2 TEXT,lname2 TEXT, college2 TEXT,mob_no2 TEXT,email2 TEXT,fname3 TEXT,lname3 TEXT, college3 TEXT,mob_no3 TEXT,email3 TEXT,fname4 TEXT,lname4 TEXT, college4 TEXT,mob_no4 TEXT,email4 TEXT,fee TEXT,bal TEXT,registered_date TEXT,regmob TEXT )";
        database.execSQL(query2);
        Log.d(LOGCAT,"register Created");
	}
	@Override
	public void onUpgrade(SQLiteDatabase database, int version_old, int current_version) 
	{
		String query;
		query = "DROP TABLE IF EXISTS event";
		database.execSQL(query);
        onCreate(database);
	}
	
	public void insertevent(HashMap<String, String> queryValues) 
	{
		SQLiteDatabase database = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("eventName", queryValues.get("eventName"));
		values.put("date", queryValues.get("date"));
		values.put("location", queryValues.get("location"));
		values.put("fee", queryValues.get("fee"));
		database.insert("event", null, values);
		database.close();
	}
	
	public int updateevent(HashMap<String, String> queryValues) 
	{
		SQLiteDatabase database = this.getWritableDatabase();	 
	    ContentValues values = new ContentValues();
	    values.put("eventName", queryValues.get("eventName"));
	    values.put("date", queryValues.get("date"));
	    values.put("location", queryValues.get("location"));
	    values.put("fee", queryValues.get("fee"));
	    return database.update("event", values, "eventId" + " = ?", new String[] { queryValues.get("eventId") });
	    //String updateQuery = "Update  words set txtWord='"+word+"' where txtWord='"+ oldWord +"'";
	    //Log.d(LOGCAT,updateQuery);
	    //database.rawQuery(updateQuery, null);
	    //return database.update("words", values, "txtWord  = ?", new String[] { word });
	}
	
	public void deleteevent(String id) 
	{
		Log.d(LOGCAT,"delete");
		SQLiteDatabase database = this.getWritableDatabase();	 
		String deleteQuery = "DELETE FROM  event where eventId='"+ id +"'";
		Log.d("query",deleteQuery);		
		database.execSQL(deleteQuery);
	}
	
	public ArrayList<HashMap<String, String>> getAllevents() 
	{
		ArrayList<HashMap<String, String>> wordList=new ArrayList<HashMap<String, String>>();
		String selectQuery = "SELECT  * FROM event";
	    SQLiteDatabase database = this.getWritableDatabase();
	    Cursor cursor = database.rawQuery(selectQuery, null);
	    if (cursor.moveToFirst()) {
	        do {
	        	HashMap<String, String> map = new HashMap<String, String>();
	        	map.put("eventId", cursor.getString(0));
	        	map.put("eventName", cursor.getString(1));
                wordList.add(map);
	        } while (cursor.moveToNext());
	    }
	 
	    // return contact list
	    return wordList;
	}
	
	public HashMap<String, String> geteventInfo(String id) 
	{
		HashMap<String, String> wordList = new HashMap<String, String>();
		SQLiteDatabase database = this.getReadableDatabase();
		String selectQuery = "SELECT * FROM event where eventId='"+id+"'";
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
	        do {
				HashMap<String, String> map = new HashMap<String, String>();
	        	wordList.put("eventName", cursor.getString(1));
	        	wordList.put("date", cursor.getString(2));
	        	wordList.put("location", cursor.getString(3));
	        	wordList.put("fee", cursor.getString(4));
				
				  // wordList.add(map);
	        } while (cursor.moveToNext());
	    }				    
	return wordList;
	}	
	
	//register table--------------------------------------------------------------------------
	public void onUpgradereg(SQLiteDatabase database, int version_old, int current_version) 
	{
		String query;
		query = "DROP TABLE IF EXISTS register";
		database.execSQL(query);
        onCreate(database);
	}
	
	public void insertregister(HashMap<String, String> queryValues) 
	{
		SQLiteDatabase database = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("eventId", queryValues.get("eventId"));
		
		values.put("fname1", queryValues.get("fname1"));
		values.put("lname1", queryValues.get("lname1"));
		values.put("college1", queryValues.get("college1"));
		values.put("mob_no1", queryValues.get("mob_no1"));
		values.put("email1", queryValues.get("email1"));
		
		values.put("fname2", queryValues.get("fname2"));
		values.put("lname2", queryValues.get("lname2"));
		values.put("college2", queryValues.get("college2"));
		values.put("mob_no2", queryValues.get("mob_no2"));
		values.put("email2", queryValues.get("email2"));
		
		values.put("fname3", queryValues.get("fname3"));
		values.put("lname3", queryValues.get("lname3"));
		values.put("college3", queryValues.get("college3"));
		values.put("mob_no3", queryValues.get("mob_no3"));
		values.put("email3", queryValues.get("email3"));
		
		values.put("fname4", queryValues.get("fname4"));
		values.put("lname4", queryValues.get("lname4"));
		values.put("college4", queryValues.get("college4"));
		values.put("mob_no4", queryValues.get("mob_no4"));
		values.put("email4", queryValues.get("email4"));
		
		values.put("fee", queryValues.get("fee"));
		values.put("bal", queryValues.get("bal"));
		values.put("registered_date", queryValues.get("registered_date"));
		values.put("regmob", queryValues.get("regmob"));
		
		database.insert("register", null, values);
		database.close();
	}
	
	
	public int updateregister(HashMap<String, String> queryValues) 
	{
		SQLiteDatabase database = this.getWritableDatabase();	 
	    ContentValues values = new ContentValues();
	    values.put("fname1", queryValues.get("fname1"));
		values.put("lname1", queryValues.get("lname1"));
		values.put("college1", queryValues.get("college1"));
		values.put("mob_no1", queryValues.get("mob_no1"));
		values.put("email1", queryValues.get("email1"));
		
		values.put("fname2", queryValues.get("fname2"));
		values.put("lname2", queryValues.get("lname2"));
		values.put("college2", queryValues.get("college2"));
		values.put("mob_no2", queryValues.get("mob_no2"));
		values.put("email2", queryValues.get("email2"));
		
		values.put("fname3", queryValues.get("fname3"));
		values.put("lname3", queryValues.get("lname3"));
		values.put("college3", queryValues.get("college3"));
		values.put("mob_no3", queryValues.get("mob_no3"));
		values.put("email3", queryValues.get("email3"));
		
		values.put("fname4", queryValues.get("fname4"));
		values.put("lname4", queryValues.get("lname4"));
		values.put("college4", queryValues.get("college4"));
		values.put("mob_no4", queryValues.get("mob_no4"));
		values.put("email4", queryValues.get("email4"));
		
		values.put("fee", queryValues.get("fee"));
		values.put("bal", queryValues.get("bal"));
		values.put("registered_date", queryValues.get("registered_date"));
		values.put("regmob", queryValues.get("regmob"));
	    return database.update("register", values, "registerId" + " = ?", new String[] { queryValues.get("registerId") });
	    //String updateQuery = "Update  words set txtWord='"+word+"' where txtWord='"+ oldWord +"'";
	    //Log.d(LOGCAT,updateQuery);
	    //database.rawQuery(updateQuery, null);
	    //return database.update("words", values, "txtWord  = ?", new String[] { word });
	}
	
	public void deleteregister(String id) 
	{
		Log.d(LOGCAT,"delete");
		SQLiteDatabase database = this.getWritableDatabase();	 
		String deleteQuery = "DELETE FROM  register where registerId='"+ id +"'";
		Log.d("query",deleteQuery);		
		database.execSQL(deleteQuery);
	}
	
	public ArrayList<HashMap<String, String>> getAllregisters(String eId) 
	{
		ArrayList<HashMap<String, String>> wordList;
		wordList = new ArrayList<HashMap<String, String>>();
		String selectQuery = "SELECT * FROM register where eventId='"+eId+"'";
	    SQLiteDatabase database = this.getWritableDatabase();
	    Cursor cursor = database.rawQuery(selectQuery, null);
	    if (cursor.moveToFirst()) {
	        do {
	        	HashMap<String, String> map = new HashMap<String, String>();
	        	map.put("registerId", cursor.getString(0));
	        	map.put("fname1", cursor.getString(2));
	        	map.put("lname1", cursor.getString(3));
                wordList.add(map);
	        } while (cursor.moveToNext());
	    }
	 
	    // return contact list
	    return wordList;
	}
	
	public HashMap<String, String> getregisterInfo(String id) 
	{
		HashMap<String, String> wordList = new HashMap<String, String>();
		SQLiteDatabase database = this.getReadableDatabase();
		String selectQuery = "SELECT * FROM register where registerId='"+id+"'";
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
	        do {
				HashMap<String, String> map = new HashMap<String, String>();
				wordList.put("eventId", cursor.getString(1));
	        	wordList.put("fname1", cursor.getString(2));
	        	wordList.put("lname1", cursor.getString(3));
	        	wordList.put("college1", cursor.getString(4));
	        	wordList.put("mob_no1", cursor.getString(5));
	        	wordList.put("email1", cursor.getString(6));
	        	
	        	wordList.put("fname2", cursor.getString(7));
	        	wordList.put("lname2", cursor.getString(8));
	        	wordList.put("college2", cursor.getString(9));
	        	wordList.put("mob_no2", cursor.getString(10));
	        	wordList.put("email2", cursor.getString(11));
	        	
	        	wordList.put("fname3", cursor.getString(12));
	        	wordList.put("lname3", cursor.getString(13));
	        	wordList.put("college3", cursor.getString(14));
	        	wordList.put("mob_no3", cursor.getString(15));
	        	wordList.put("email3", cursor.getString(16));
	        	
	        	wordList.put("fname4", cursor.getString(17));
	        	wordList.put("lname4", cursor.getString(18));
	        	wordList.put("college4", cursor.getString(19));
	        	wordList.put("mob_no4", cursor.getString(20));
	        	wordList.put("email4", cursor.getString(21));
				
	        	wordList.put("fee", cursor.getString(22));
	        	wordList.put("bal", cursor.getString(23));
	        	wordList.put("registered_date", cursor.getString(24));
	        	wordList.put("regmob", cursor.getString(25));
	        	
				  // wordList.add(map);
	        } while (cursor.moveToNext());
	    }				    
	return wordList;
	}	

}

