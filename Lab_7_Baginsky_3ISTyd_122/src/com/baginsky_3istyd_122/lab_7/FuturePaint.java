package com.baginsky_3istyd_122.lab_7;

import java.util.Map;

import android.os.Bundle;
import android.view.View;

import com.baginsky_3istyd_122.lab_6.ActivityPaint;

public class FuturePaint extends ActivityPaint{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		for (Map.Entry<String, View> entry : figures.entrySet()) {
            String key = entry.getKey();
            View view = entry.getValue();
            figures.put(key,new MultiTouch<View>(this,view));
        }

		String figureName=(String)getIntent().getSerializableExtra("figure");
		
		setContentView(figures.get(figureName));
	}
	
}