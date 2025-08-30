package com.baginsky_3istyd_122.lab_6.figures;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.View;

public class DrawOne extends View{

	public DrawOne(Context context) {
		super(context);
	}
	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawColor(Color.GREEN);
	}

}
