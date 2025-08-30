package com.baginsky_3istyd_122.lab_5.core;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class DatabaseManager implements IManager {
	protected DatabaseHelper _dbHelper;
    protected SQLiteDatabase _db=null;
    protected Context _context;
    private String _className;
    
	public DatabaseManager(Context context) {
		_context=context;
		_className=this.getClass().getSimpleName();
	}

	@Override
	public void open() {
		_dbHelper=new DatabaseHelper(_context);
        _db=_dbHelper.getWritableDatabase(); 	
	}

	@Override
	public void close() {
		_db.close();
		
	}
	@Override
	public void clear(){
		int clearCount = _db.delete(_dbHelper.TABLE_NAME, null, null);
		String resetSequence=String.format("UPDATE sqlite_sequence SET seq = 0 WHERE name = '%s'", _dbHelper.TABLE_NAME);
	    
		_db.execSQL(resetSequence);
		myLogger.log(_className,String.format("--- Clear %s: ---", _dbHelper.TABLE_NAME));
		myLogger.log(_className,String.format("rows deleted %s", clearCount));
    }

	@Override
    public ArrayList<String> read(){
        Cursor c=_dbHelper.selectAll(_db);
		myLogger.log(_className,String.format(" --- Rows in %s: ---", _dbHelper.TABLE_NAME));
		ArrayList<String> result=getQueryResult(c);		
		return result;       
    }
	@Override
    public long update(ContentValues data){		
		long id=_db.replace(_dbHelper.TABLE_NAME, null, data);
		myLogger.log(_className,String.format("--- Insert in %s: ---", _dbHelper.TABLE_NAME));
		myLogger.log(_className,String.format("row inserted %s", id));
		
		return id;
    }

	protected ArrayList<String> getQueryResult(Cursor c){
		ArrayList<String> result=new ArrayList<String>();
		
		if(c.moveToFirst())  
	      {
			result.add("ID");  
			result.add("Name"); 
			result.add("Email"); 
	         do  
	         {  
	            String ide=c.getString(c.getColumnIndex("_id"));  
	            String name=c.getString(c.getColumnIndex("name"));  
	            String email=c.getString(c.getColumnIndex("email")); 
	            String message=String.format("ID=%s, name=%s, email=%s", ide,name,email);
	            //add in to array list  
	            result.add(ide);  
	            result.add(name);  
	            result.add(email);  
	          
	            Toast.makeText(_context, "This data found", Toast.LENGTH_LONG).show();

	            myLogger.log(_className, message);
	         
	         }while(c.moveToNext());//Move the cursor to the next row.  
	      }  
	      else  
	      {  
	         Toast.makeText(_context, "No data found", Toast.LENGTH_LONG).show();  
	         myLogger.log(_className, "No data found");
	      }  
        return result;
	}

	@Override
	public ArrayList<String> read(ContentValues data) {
		Object _uid=data.get("_id");
		
		String[] columns = {_dbHelper.COLUMN_ID, _dbHelper.COLUMN_NAME, _dbHelper.COLUMN_EMAIL};
		String selection = _dbHelper.COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(_uid)};
        
		Cursor c=_db.query(_dbHelper.TABLE_NAME, columns, selection, selectionArgs, null, null, null);
		myLogger.log(_className,String.format(" --- Rows in %s: ---", _dbHelper.TABLE_NAME));
		ArrayList<String> result=getQueryResult(c);
		return result;
	}

	@Override
	public void clear(ContentValues data) {
		Object _uid=data.get("_id");
		String whereClause = String.format("%s = ?", _dbHelper.COLUMN_ID);
		String[] whereArgs = {String.valueOf(_uid)}; 

		int rowsAffected = _db.delete(_dbHelper.TABLE_NAME, whereClause, whereArgs);
		
		myLogger.log(_className,String.format("--- Clear %s: ---", _dbHelper.TABLE_NAME));
		myLogger.log(_className,String.format("row deleted (ID=%s)", rowsAffected));

	}
}
