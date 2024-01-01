package com.arrowwould.flashlightxt.activitys;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import com.arrowwould.flashlightxt.R;
import com.arrowwould.flashlightxt.ads.Control;
import com.arrowwould.flashlightxt.databinding.ActivityGithubBinding;

public class GithubActivity extends AppCompatActivity {
    private ActivityGithubBinding binding; // Declare the binding variable
    private Control control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGithubBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        control = new Control(this);
        control.loadBannerAd(binding.bannerLayout);

        // Access the WebView from the binding
        binding.webView.getSettings().setJavaScriptEnabled(true); // Enable JavaScript (if required)

        // Load the URL of the website you want to display
        binding.webView.loadUrl("https://github.com/samyak2403/");
    }

    // Handle back button press to navigate within WebView
    @Override
    public void onBackPressed() {
        if (binding.webView.canGoBack()) {
            binding.webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
