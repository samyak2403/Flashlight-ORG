package com.arrowwould.flashlightxt.activitys;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.arrowwould.flashlightxt.R;
import com.arrowwould.flashlightxt.ads.Control;
import com.arrowwould.flashlightxt.databinding.ActivityDisclaimerBinding;


public class DisclaimerActivity extends AppCompatActivity {

    private Control control;

    private ActivityDisclaimerBinding binding; // Declare the binding variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDisclaimerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        control = new Control(this);
        control.loadBannerAd(binding.bannerLayout);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Disclaimer");
        }

        TextView disclaimerText = binding.disclaimerText;
        disclaimerText.setText(R.string.flashlight_disclaimer);
    }
}
