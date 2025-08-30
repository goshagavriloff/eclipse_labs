package com.baginsky_3istyd_122.lab_6;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity implements OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setup();
    }
    public void setup(){
    	ArrayList<Button> buttons=getButtons();
    	for (Button button : buttons) {
    		button.setOnClickListener(this);
		}
    }
    public ArrayList<Button> getButtons() {
        ArrayList<Button> buttons = new ArrayList<Button>();
        ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
        findButtons(viewGroup, buttons);
        return buttons;
    }
    private static void findButtons(ViewGroup viewGroup,ArrayList<Button> buttons) {
        for (int i = 0, N = viewGroup.getChildCount(); i < N; i++) {
            View child = viewGroup.getChildAt(i);
            if (child instanceof ViewGroup) {
                findButtons((ViewGroup) child, buttons);
            } else if (child instanceof Button) {
                buttons.add((Button) child);
            }
        }
    }
	@Override
	public void onClick(View v) {
		Button button=(Button) v;
		Intent intent_1 = new Intent(MainActivity.this, ActivityPaint.class);
		String value=(String) button.getText();	
		intent_1.putExtra("figure", value);
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
