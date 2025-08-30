package com.baginsky_3istyd_122.lab_5;

import java.util.ArrayList;

import com.baginsky_3istyd_122.lab_5.core.Controller;
import com.baginsky_3istyd_122.lab_5.core.IManager;

import android.app.Activity;
import android.content.ContentValues;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RecordActivity extends Activity{
	protected Controller c;
	protected IManager mgr;
	protected String uiid=null;
	protected EditText tFieldName,tFieldEmail;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        tFieldName = (EditText)findViewById(R.id.editText1);
        tFieldEmail = (EditText)findViewById(R.id.editText2);
        c=new Controller(this);
        mgr= c.getManager();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onBtnUpdateClick(View view){
    	ContentValues data=new ContentValues();
    	data.put("_id", uiid);
    	data.put("name", tFieldName.getText().toString());
    	data.put("email", tFieldEmail.getText().toString());
    	
    	mgr.update(data);
    	tFieldEmail.setText("");
    	tFieldName.setText("");
    }
    
    public void onBtnClearClick(View view){
    	mgr.clear();
    }
    
    public void onBtnDisplayClick(View view){
    	ArrayList<String> list=mgr.read();
    }
    
}
