package com.arrowwould.flashlightxt.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.arrowwould.flashlightxt.R;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;


public class FlashLightPro extends AppCompatActivity {

    ImageView bulbOnOff, btnOnOff;
    boolean state;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide status bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_flash_light_pro);

        btnOnOff = findViewById(R.id.btn_off); // Assuming IDs for the on/off button
        bulbOnOff = findViewById(R.id.light_off); // Assuming ID for the bulb image
        constraintLayout = findViewById(R.id.constraint_layout);

        Dexter.withContext(this)
                .withPermission(Manifest.permission.CAMERA)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        onOffFlashlight();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                        Toast.makeText(FlashLightPro.this, "Camera Permission required", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                        // Handle rationale if needed
                    }
                }).check();
    }

    private void onOffFlashlight() {
        btnOnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!state) {
                    // Turn on flashlight
                    CameraManager cameraManager = (CameraManager) getSystemService(CAMERA_SERVICE);
                    try {
                        String cameraID = cameraManager.getCameraIdList()[0];
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            cameraManager.setTorchMode(cameraID, true);
                        }
                        state = true;
                        btnOnOff.setImageResource(R.drawable.btnon); // Change the image to represent the on state
                        bulbOnOff.setImageResource(R.drawable.lighton); // Change the bulb image for the on state
                        constraintLayout.setBackgroundColor(getResources().getColor(R.color.yellow));
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                } else {
                    // Turn off flashlight
                    CameraManager cameraManager = (CameraManager) getSystemService(CAMERA_SERVICE);
                    try {
                        String cameraID = cameraManager.getCameraIdList()[0];
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            cameraManager.setTorchMode(cameraID, false);
                        }
                        state = false;
                        btnOnOff.setImageResource(R.drawable.btnoff); // Change the image to represent the off state
                        bulbOnOff.setImageResource(R.drawable.lightoff); // Change the bulb image for the off state
                        constraintLayout.setBackgroundColor(getResources().getColor(R.color.gray));
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
