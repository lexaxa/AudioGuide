package ru.lavue.audioguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
    }
    public void emojifyMe(View view) {
        // Check for the external storage permission

            // Launch the camera if the permission exists
            Intent intent = new Intent(this, CameraPreviewActivity.class);
            startActivity(intent);
    }
}
