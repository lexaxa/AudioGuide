package ru.lavue.audioguide;

import android.graphics.Rect;
import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class CameraPreviewActivity extends AppCompatActivity {

    private Camera mCamera;
    private CameraPreview mPreview;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_preview);

        // Create an instance of Camera
        mCamera = getCameraInstance();
        if(mCamera == null){
            Toast.makeText(this,"Camera not available",Toast.LENGTH_LONG).show();
            Log.d(TAG, "Camera not available");

        }else{
            Log.d(TAG, "Camera available");
// Create an instance of Camera
            mCamera = getCameraInstance();

// set Camera parameters
//            Camera.Parameters params = mCamera.getParameters();
//
//            if (params.getMaxNumMeteringAreas() > 0){ // check that metering areas are supported
//                List<Camera.Area> meteringAreas = new ArrayList<>();
//
//                Rect areaRect1 = new Rect(-100, -100, 100, 100);    // specify an area in center of image
//                meteringAreas.add(new Camera.Area(areaRect1, 600)); // set weight to 60%
//                Rect areaRect2 = new Rect(800, -1000, 1000, -800);  // specify an area in upper right of image
//                meteringAreas.add(new Camera.Area(areaRect2, 400)); // set weight to 40%
//                params.setMeteringAreas(meteringAreas);
//            }
//
//            mCamera.setParameters(params);

            // Create our Preview view and set it as the content of our activity.
            mPreview = new CameraPreview(this, mCamera);
            FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);
            preview.addView(mPreview);
        }
    }
    /** A safe way to get an instance of the Camera object. */
    public static Camera getCameraInstance(){
        Camera c = null;
        try {
            c = Camera.open(); // attempt to get a Camera instance
        }
        catch (Exception e){
            // Camera is not available (in use or does not exist)
        }
        return c; // returns null if camera is unavailable
    }

}
