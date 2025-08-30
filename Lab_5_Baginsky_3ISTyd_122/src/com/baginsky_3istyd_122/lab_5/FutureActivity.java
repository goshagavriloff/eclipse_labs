package com.baginsky_3istyd_122.lab_5;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FutureActivity extends RecordActivity {
	ContentValues data;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		uiid=(String)getIntent().getSerializableExtra("uid");
		data=new ContentValues();
    	data.put("_id", uiid); 
    	this.render();
    	((Button)findViewById(R.id.button_insert)).setText("Редактировать");
    	((Button)findViewById(R.id.button_clear)).setText("Удалить");
    	((Button)findViewById(R.id.button_display)).setText("Назад");
	}
	private void render(){
		ArrayList<String> arr=mgr.read(data);
		if (arr.size()>=6){
	    	tFieldName.setText(arr.get(4).toString());
	    	tFieldEmail.setText(arr.get(5).toString());
		}
    	
	}
	private void backToTable(){
		Intent intent_1 = new Intent(FutureActivity.this, TableActivity.class);
   	    startActivity(intent_1);
	}
	@Override
	public void onBtnClearClick(View view) {
    	mgr.clear(data);
    	backToTable();
	}
	
	@Override
	public void onBtnDisplayClick(View view) {
		backToTable();
	}
	@Override
	public void onBtnUpdateClick(View view) {
		super.onBtnUpdateClick(view);
		this.render();
	}
}
