package com.baginsky_3istyd_122.lab_8;

import java.io.File;
import java.io.FileOutputStream;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.os.Bundle;
import android.os.Environment;
import android.view.SurfaceHolder;
import android.view.View;

public class CameraActivityTwo extends CameraActivity{
	File photoFile;
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        File pictures = Environment
	        		.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
	        		photoFile = new File(pictures, "myphoto.jpg");
	    }
	    @Override
	    protected int getLayout() {
	        if (_layout == null) {
	            _layout = R.layout.activity_camera_two;
	        }
	        return super.getLayout();
	    }
	    @Override
	    protected int getSurface() {
	        if (_surface == null) {
	            _surface = R.id.surface_2;
	        }
	        return super.getSurface();
	    }

	    @Override
	    protected SurfaceHolder.Callback getCallback() {
	        return new HolderCallbackTwo(this);
	    }

	    public void onClickPicture(View view) {
	        camera.takePicture(null, null, new PictureCallback() {
	            @Override
	            public void onPictureTaken(byte[] data, Camera camera) {
	                try {
	                    FileOutputStream fos = new FileOutputStream(photoFile);
	                    fos.write(data);
	                    fos.close();
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	    }
}
