package com.baginsky_3istyd_122.lab_3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityThree extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_three);
	}
	public void back(View view){
		
		Intent intent=new Intent(ActivityThree.this,MainActivity.class);
		startActivity(intent);
	}

}
