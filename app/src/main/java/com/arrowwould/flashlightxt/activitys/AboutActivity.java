package com.arrowwould.flashlightxt.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.arrowwould.flashlightxt.R;
import com.arrowwould.flashlightxt.ads.Control;
import com.arrowwould.flashlightxt.databinding.ActivityAboutBinding;
import com.google.android.ads.nativetemplates.NativeTemplateStyle;
import com.google.android.ads.nativetemplates.TemplateView;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.nativead.NativeAd;

public class AboutActivity extends AppCompatActivity {

    private ActivityAboutBinding binding;
    private Control control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAboutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        control = new Control(this);
        control.loadBannerAd(binding.bannerLayout);

        String nativeAdUnitId = getResources().getString(R.string.native_ad_unit_id);
// Use nativeAdUnitId in the AdmobNativeAdAdapter setup
        AdLoader adLoader = new AdLoader.Builder(this, nativeAdUnitId)
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        NativeTemplateStyle styles = new
                                NativeTemplateStyle.Builder().build();
                        TemplateView template = findViewById(R.id.my_template);
                        template.setStyles(styles);
                        template.setNativeAd(nativeAd);
                    }
                })
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());

        binding.privacypolicyBtutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                privacypolicy();
            }
        });

        binding.desclaimerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                desclaimer();
            }
        });

        binding.githubButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                githubOpen();
            }
        });
    }

    public void privacypolicy() {
        Intent intent = new Intent(this, PrivacyPolicyActivity.class);
        startActivity(intent);
    }

    public void desclaimer() {
        Intent intent = new Intent(this, DisclaimerActivity.class);
        startActivity(intent);
    }

    public void githubOpen() {
        Intent intent = new Intent(this, GithubActivity.class);
        startActivity(intent);
    }
}
