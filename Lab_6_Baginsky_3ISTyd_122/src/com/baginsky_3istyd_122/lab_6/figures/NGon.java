package com.baginsky_3istyd_122.lab_6.figures;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class NGon  extends View{
	private Paint paint;
    private Path path;
    private int numSides; 
    private float radius; 

    public NGon(Context context) {
        super(context);
        init();
    }

    public NGon(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public NGon(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5f);
        paint.setAntiAlias(true);

        path = new Path();
        numSides = 4; // Example: a square
        radius = 200f; // Example radius
    }

    public void setNumSides(int sides) {
        this.numSides = sides;
        invalidate(); 
    }

    public void setRadius(float radius) {
        this.radius = radius;
        invalidate(); 
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float centerX = getWidth() / 2f;
        float centerY = getHeight() / 2f;

        path.reset(); // Clear previous path data

        for (int i = 0; i < numSides; i++) {
            double angle = 2 * Math.PI * i / numSides;
            float x = (float) (centerX + radius * Math.cos(angle));
            float y = (float) (centerY + radius * Math.sin(angle));

            if (i == 0) {
                path.moveTo(x, y); // Start the path at the first vertex
            } else {
                path.lineTo(x, y); // Draw a line to subsequent vertices
            }
        }
        path.close(); // Close the path to form the polygon

        canvas.drawPath(path, paint);
    }
}
