package com.arrowwould.flashlightxt.activitys;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.arrowwould.flashlightxt.R;
import com.arrowwould.flashlightxt.ads.Control;
import com.arrowwould.flashlightxt.databinding.ActivityPrivacyPolicyBinding;

public class PrivacyPolicyActivity extends AppCompatActivity {

    private ActivityPrivacyPolicyBinding binding; // Declare the binding variable
    private Control control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPrivacyPolicyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        control = new Control(this);
        control.loadBannerAd(binding.bannerLayout);


        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("About");
        }

        // Set the privacy policy text
        binding.aboutText.setText(R.string.privacy_policy);
    }
}
