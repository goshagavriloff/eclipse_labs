package com.baginsky_3istyd_122.lab_3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityTwo extends Activity {
	EditText mEditText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two);
		TextView mTextView=(TextView) findViewById(R.id.textView2);
		String count=(String)getIntent().getSerializableExtra("count");
		String txt=String.format("%s %s", mTextView.getText(),count);
		mTextView.setText(txt);
	}
	
	public void back(View view){
		mEditText=(EditText) findViewById(R.id.editText);
		String message=mEditText.getText().toString();
		Intent intent=new Intent(ActivityTwo.this,MainActivity.class);
		intent.putExtra("message",message);
		startActivity(intent);
	}
	
	public void next(View view){
		Intent intent=new Intent(getApplicationContext(),ActivityThree.class);
		startActivity(intent);
	}
}
