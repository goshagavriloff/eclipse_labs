package com.baginsky_3istyd_122.lab_8;

import java.io.IOException;

import android.content.Context;
import android.view.SurfaceHolder;

public class HolderCallback implements SurfaceHolder.Callback{
	protected Context _context;
	public HolderCallback(Context context){
		this._context=context;
	}

	@Override
    public void surfaceCreated(SurfaceHolder holder) {
		CameraActivity c = (CameraActivity)this._context;
        try {
            c.camera.setPreviewDisplay(holder);
            c.camera.startPreview();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format,int width, int height) {}

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {}
	
}
