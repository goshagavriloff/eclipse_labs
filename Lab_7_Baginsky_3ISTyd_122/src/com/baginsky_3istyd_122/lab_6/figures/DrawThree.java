package com.baginsky_3istyd_122.lab_6.figures;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class DrawThree extends View{
	Paint p;
	Rect rect;
	public DrawThree(Context context) {
		super(context);
		p = new Paint();
		rect = new Rect();
	}


	@Override
	protected void onDraw(Canvas canvas) {
	// заливка канвы цветом
	canvas.drawARGB(80, 102, 204, 255);
	// настройка кисти
	// красный цвет
	p.setColor(Color.RED);
	// толщина линии = 10
	p. setStrokeWidth(10);
	// рисуем точку (50,50)
	canvas.drawPoint(50, 50, p);
	// рисуем линию от (100,100) до (500,50)
	canvas.drawLine(100,100,500,50,p);
	// рисуем круг с центром в (100,200), радиус = 50
	canvas.drawCircle(100, 200, 50, p);
	// рисуем пр€моугольник
	// лева€ верхн€€ точка (200,150), нижн€€ права€ (400,200)
	canvas.drawRect(200, 150, 400, 200, p);
	// настройка объекта Rect
	// лева€ верхн€€ точка (250,300), нижн€€ права€ (350,500)
	rect.set(250, 300, 350, 500);
	// рисуем пр€моугольник из объекта rect
	canvas.drawRect(rect, p);
	}




}
