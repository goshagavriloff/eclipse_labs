package com.baginsky_3istyd_122.lab_3;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class MainActivity extends Activity implements View.OnClickListener{
	int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mButton1=(Button) findViewById(R.id.buttonNext);
        Button mButton2=(Button) findViewById(R.id.buttonBack);
        TextView mTextView=(TextView) findViewById(R.id.textView1);
        mTextView.setText((String)getIntent().getSerializableExtra("message"));
        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton2.setText(String.format("Количество: %d", count));      
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
	@Override
	public void onClick(View v) {
		if (v.getId()==R.id.buttonNext){
			Intent intent=new Intent(getApplicationContext(),ActivityTwo.class);
			intent.putExtra("count",String.valueOf(count));
			startActivity(intent);
		} else if (v.getId()==R.id.buttonBack){
			count++;
			String txt=String.format("Количество: %d", count) ;
			((Button)v).setText(txt);
		}
	}
}
