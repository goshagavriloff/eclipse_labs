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
import android.widget.TextView;

public class ActivityCompas extends Activity  implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor magneticSensor, accelerometerSensor;

    private float[] gravityValues = new float[3];
    private float[] geomagneticValues = new float[3];

    private TextView directionTextView;
    private String direction;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compas);

        directionTextView = (TextView) findViewById(R.id.TextView1);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (sensorManager != null) {
            magneticSensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
            accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (magneticSensor != null) {
            sensorManager.registerListener(this, magneticSensor, SensorManager.SENSOR_DELAY_UI);
        }
        if (accelerometerSensor != null) {
            sensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_UI);
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
            System.arraycopy(event.values, 0, gravityValues, 0, event.values.length);
        } else if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
            System.arraycopy(event.values, 0, geomagneticValues, 0, event.values.length);
        }

        if (gravityValues != null && geomagneticValues != null) {
            float[] R = new float[9];
            float[] I = new float[9];

            boolean success = SensorManager.getRotationMatrix(R, I, gravityValues, geomagneticValues);
            if (success) {
                float[] orientation = new float[3];
                SensorManager.getOrientation(R, orientation);

                // Азимут (направление относительно северного полюса)
                float azimuthRad = orientation[0];
                float azimuthDeg = (float) Math.toDegrees(azimuthRad);
                if (azimuthDeg < 0) {
                    azimuthDeg += 360;
                }
                updateDirection(azimuthDeg);
            }
        }
    }
    
    private void updateDirection(float azimuthDeg) {
        
        if (azimuthDeg >= 337.5 || azimuthDeg < 22.5) {
            direction = "Север";
        } else if (azimuthDeg >= 22.5 && azimuthDeg < 67.5) {
            direction = "Северо-Восток";
        } else if (azimuthDeg >= 67.5 && azimuthDeg < 112.5) {
            direction = "Восток";
        } else if (azimuthDeg >= 112.5 && azimuthDeg < 157.5) {
            direction = "Юго-Восток";
        } else if (azimuthDeg >= 157.5 && azimuthDeg < 202.5) {
            direction = "Юг";
        } else if (azimuthDeg >= 202.5 && azimuthDeg < 247.5) {
            direction = "Юго-Запад";
        } else if (azimuthDeg >= 247.5 && azimuthDeg < 292.5) {
            direction = "Запад";
        } else {
            direction = "Северо-Запад";
        }

        runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				directionTextView.setText("Направление: " + direction);
			} 
        });
    }

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}
}
