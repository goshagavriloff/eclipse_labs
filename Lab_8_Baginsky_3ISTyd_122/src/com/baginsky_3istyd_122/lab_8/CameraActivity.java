package com.baginsky_3istyd_122.lab_8;

import android.app.Activity;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.Window;
import android.view.WindowManager;
public class CameraActivity extends Activity{
	protected Integer  _layout=null;
	protected Integer  _surface=null;
	protected SurfaceView sv;
	protected SurfaceHolder holder;
	protected SurfaceHolder.Callback holderCallback;
	protected Camera camera;
	protected final int CAMERA_ID = 0;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(getLayout());
		sv = (SurfaceView) findViewById(getSurface());
		holder = sv.getHolder();
		holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
		SurfaceHolder.Callback holderCallback= getCallback();
		holder.addCallback(holderCallback);
    }
	@Override
	protected void onResume() {
		super.onResume();
		camera = Camera.open(CAMERA_ID);
	}
	@Override
	protected void onPause() {
		super.onPause();
		if (camera != null)
		camera.release();
		camera = null;
	}
	protected int getLayout(){
		return _layout;
	}
	
	protected int getSurface(){
		return _surface;
	}
	protected SurfaceHolder.Callback getCallback(){
		return null;	
	}
		
}
