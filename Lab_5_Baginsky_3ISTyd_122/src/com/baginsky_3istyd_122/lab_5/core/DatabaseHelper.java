package com.baginsky_3istyd_122.lab_5.core;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {
	 private static final String DATABASE_NAME = "baginsky_database.db";
	    private static final int DATABASE_VERSION = 1;

	    // Table and column names as constants (optional but recommended)
	    public static final String TABLE_NAME = "mytable";
	    public static final String COLUMN_ID = "_id";
	    public static final String COLUMN_NAME = "name";
	    public static final String COLUMN_EMAIL = "email";

	    
	    public DatabaseHelper(Context context) {
	        super(context, DATABASE_NAME, null, DATABASE_VERSION);
	    }

	    @Override
	    public void onCreate(SQLiteDatabase db) {
	    	myLogger.log(this.getClass().getSimpleName(), "--- onCreate database ---");
	        // Create table
	        String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
	                                  COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
	                                  COLUMN_NAME + " TEXT," +
	                                  COLUMN_EMAIL + " TEXT)";
	        db.execSQL(CREATE_TABLE_SQL);
	    }

	    @Override
	    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	        // Handle database upgrades (e.g., dropping and recreating tables)
	        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
	        onCreate(db);
	    }
	    public Cursor selectAll(SQLiteDatabase db)  {
	        return db.rawQuery("SELECT * FROM "+ TABLE_NAME,null); 
	    }
}
