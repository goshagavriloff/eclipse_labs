package com.baginsky_3istyd_122.lab_5;

import java.util.ArrayList;

import com.baginsky_3istyd_122.lab_5.core.Controller;
import com.baginsky_3istyd_122.lab_5.core.IManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;

public class TableActivity extends Activity implements OnItemClickListener{
	private GridView gridView;  
	private ArrayList<String> list;
	private ArrayAdapter<String> adapter; 
	protected Controller c;
	protected IManager mgr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        
    	c=new Controller(this);
    	mgr=c.getManager();
        
        gridView=(GridView) findViewById(R.id.gridView1);  
  	  	gridView.setVerticalSpacing(25);

  	   list=mgr.read();  
  	   adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,list);  
  	   gridView=(GridView) findViewById(R.id.gridView1); 
  	   gridView.setAdapter(adapter);
  	   gridView.setOnItemClickListener(this);
    }  
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		int numColumns = gridView.getNumColumns();
	    int row = position / numColumns;
	    int col = position % numColumns;
	    int posId=numColumns*(row);
	    String uid=(String) parent.getItemAtPosition(posId);
	    Intent intent_1 = new Intent(TableActivity.this, FutureActivity.class);
	    intent_1.putExtra("uid",uid);
   	    startActivity(intent_1);
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
