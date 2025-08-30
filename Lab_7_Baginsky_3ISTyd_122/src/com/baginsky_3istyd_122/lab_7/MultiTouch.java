package com.baginsky_3istyd_122.lab_7;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;

public class MultiTouch<T extends View> extends View {
    private T innerView;
	private Paint paint;
    private SparseArray<Path> activePaths;

    public MultiTouch(Context context, T view) {
        super(context);
        this.innerView = view;
		init();
    }

	private void init() {
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(8f);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);

        activePaths = new SparseArray<Path>();
    }

	
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

		for (int i = 0; i < activePaths.size(); i++) {
            Path path = activePaths.valueAt(i);
            if (path != null) {
                canvas.drawPath(path, paint);
            }
        }

        innerView.draw(canvas);
    }

 @Override
    public boolean onTouchEvent(MotionEvent event) {
        int pointerIndex = event.getActionIndex();
        int pointerId = event.getPointerId(pointerIndex);

        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN: {
                // Начинаем новый путь для каждого касания
                Path path = new Path();
                path.moveTo(event.getX(pointerIndex), event.getY(pointerIndex));
                activePaths.put(pointerId, path);
                invalidate();
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                // Обновляем путь для каждого активного указателя
                for (int i = 0; i < event.getPointerCount(); i++) {
                    int id = event.getPointerId(i);
                    Path path = activePaths.get(id);
                    if (path != null) {
                        path.lineTo(event.getX(i), event.getY(i));
                    }
                }
                invalidate();
                break;
            }
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
            case MotionEvent.ACTION_CANCEL: {
                // Удаляем путь для отпущенного указателя
                activePaths.remove(pointerId);
                invalidate();
                break;
            }
        }
        return true;
    }

}

