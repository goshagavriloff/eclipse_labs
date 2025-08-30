package com.baginsky_3istyd_122.lab_8;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;

public class HolderCallbackOne extends HolderCallback implements Callback {

	public HolderCallbackOne(Context context) {
		super(context);
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {


	}

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
        int height) {
    	CameraActivityOne c = (CameraActivityOne)this._context;

        c.camera.stopPreview();
        c.setCameraDisplayOrientation(c.CAMERA_ID);
        try {
            c.camera.setPreviewDisplay(c.holder);
            c.camera.startPreview();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {


	}

}
