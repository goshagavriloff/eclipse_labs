package com.baginsky_3istyd_122.lab_6;

import java.util.HashMap;

import com.baginsky_3istyd_122.lab_6.figures.DrawFive;
import com.baginsky_3istyd_122.lab_6.figures.DrawFour;
import com.baginsky_3istyd_122.lab_6.figures.DrawOne;
import com.baginsky_3istyd_122.lab_6.figures.DrawThree;
import com.baginsky_3istyd_122.lab_6.figures.DrawTwo;
import com.baginsky_3istyd_122.lab_6.figures.Hexagon;
import com.baginsky_3istyd_122.lab_6.figures.Pentagon;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class ActivityPaint extends Activity{
	private HashMap<String,View> figures=new HashMap<String, View>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		figures.put("Первое окно",new DrawOne(this));
		figures.put("Второе окно",new DrawTwo(this));
		figures.put("Третье окно",new DrawThree(this));
		figures.put("Четвертое окно",new DrawFour(this));
		figures.put("Пятое окно",new DrawFive(this));
		figures.put("Пятиугольник",new Pentagon(this));
		figures.put("Шестиугольник",new Hexagon(this));
		

		String figureName=(String)getIntent().getSerializableExtra("figure");
		
		setContentView(figures.get(figureName));
	}
	
}
