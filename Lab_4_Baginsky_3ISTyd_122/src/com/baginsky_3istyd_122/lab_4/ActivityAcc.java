package com.baginsky_3istyd_122.lab_4;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.FrameLayout;

public class ActivityAcc extends Activity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor accelerometer;
    private Button button1;
    private FrameLayout layout;

    private float accelX, accelY; 

    private float buttonX, buttonY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acc); 

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (sensorManager != null) {
            accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        }


        button1 = (Button) findViewById(R.id.button1);
        layout = (FrameLayout) findViewById(R.id.root_layout);


        layout.post(new Runnable() {
			@Override
			public void run() {
				buttonX = (layout.getWidth() - button1.getWidth()) / 2f;
	            buttonY = (layout.getHeight() - button1.getHeight()) / 2f;
	            button1.setX(buttonX);
	            button1.setY(buttonY);
			}
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (accelerometer != null) {
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_UI);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            accelX = event.values[0];
            accelY = event.values[1];

            moveButton(accelX, accelY);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    private void moveButton(float accelX, float accelY) {
        // Множитель для чувствительности
        float sensitivity = 5f;

        // Обновление координат кнопки
        buttonX -= accelX * sensitivity;
        buttonY += accelY * sensitivity;

        // Ограничение по границам layout
        if (buttonX < 0) buttonX = 0;
        if (buttonY < 0) buttonY = 0;
        if (buttonX > layout.getWidth() - button1.getWidth())
            buttonX = layout.getWidth() - button1.getWidth();
        if (buttonY > layout.getHeight() - button1.getHeight())
            buttonY = layout.getHeight() - button1.getHeight();

        // Обновляем позицию кнопки
        runOnUiThread(new Runnable() {
			@Override
			public void run() {
				button1.setX(buttonX);
	            button1.setY(buttonY);
			}
		});
        
    }
}