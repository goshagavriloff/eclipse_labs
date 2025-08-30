package com.baginsky_3istyd_122.lab_7;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class InfoActivity extends Activity implements OnTouchListener {
	  StringBuilder sb = new StringBuilder();
	  TextView tv;
	  int upPI = 0;
	  int downPI = 0;
	  boolean inTouch = false;
	  String result = "";
	  /** Called when the activity is first created. */
	  @Override
	  public void onCreate(Bundle savedInstancestate) {
	    super.onCreate(savedInstancestate);
	    tv = new TextView(this);
	    tv.setTextSize(30);
	    tv.setOnTouchListener(this);
	    setContentView(tv);
	  }
	  @Override
	  public boolean onTouch(View view, MotionEvent event) {
	    // событие
	    int actionMask = event.getActionMasked();
	    // индекс касания
	    int pointerIndex = event.getActionIndex();
	    // число касаний
	    int pointerCount = event.getPointerCount();
	    switch (actionMask) {
	    case MotionEvent.ACTION_DOWN: // первое касание
	      inTouch = true;
	    case MotionEvent.ACTION_POINTER_DOWN: // последующие касания
	      downPI = pointerIndex;
	      break;
	    case MotionEvent.ACTION_UP: // прерывание последнего касания
	      inTouch = false;
	      sb.setLength(0);
	    case MotionEvent.ACTION_POINTER_UP: // прерывания касаний
	      upPI = pointerIndex;
	      break;
	    case MotionEvent.ACTION_MOVE: // движение
	      sb.setLength(0);
	      for (int i = 0; i < 10; i++) {
	        sb.append("Index = " + i);
	        if (i < pointerCount) {
	          sb.append(", 10 = " + event.getPointerId(i));
	          sb.append(", x = " + event.getX(i));
	          sb.append(", Y = " + event.getY(i));
	        } else {
	          sb.append(", 10 = ");
	          sb.append(", x = ");
	          sb.append(", y = ");
	        }
	        sb.append("\r\n");
	      }
	      break;
	    }
	    result = "down: " + downPI + "\n" + "up: " + upPI + "\n";
	    if (inTouch) {
	      result += "pointerCount = " + pointerCount + "\n" + sb.toString();
	    }
	    tv.setText(result);
	    return true;
	  }
	}
