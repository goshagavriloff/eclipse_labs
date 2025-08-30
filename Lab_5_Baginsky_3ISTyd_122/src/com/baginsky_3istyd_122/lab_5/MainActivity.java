package com.baginsky_3istyd_122.lab_5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity {
	Button B1,B2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        B1 = (Button)findViewById(R.id.button1);
        B2 = (Button)findViewById(R.id.button2);
        
        B1.setOnClickListener(new OnClickListener(){
         	 public void onClick(View v){
            		Intent intent_1 = new Intent(MainActivity.this, RecordActivity.class);
            	    startActivity(intent_1);
              }}) ; 
        
        B2.setOnClickListener(new OnClickListener(){
        	 public void onClick(View v){
           		Intent intent_1 = new Intent(MainActivity.this, TableActivity.class);
           	    startActivity(intent_1);
             }}) ; 
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
}
