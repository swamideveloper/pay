package com.test.myapp.vcall.tumsehi;

import static com.test.myapp.vcall.shyame.aakhometeri.native_ShowAds;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.ads.sdk.IntertitialAdsEvent;
import com.ads.sdk.new_configs.Data_Preference;
import com.test.myapp.vcall.R;


public class tujanena extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thankyou);


        IntertitialAdsEvent.ShowInterstitialAdsOnCreate(this);
        if (new Data_Preference(this).getKeyOnresumenativeshow().equals("0")) {
            native_ShowAds(this, findViewById(R.id.native_container), 1);
        }

        findViewById(R.id.llYes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });

        findViewById(R.id.llNo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    @Override
    public void onBackPressed() {
        IntertitialAdsEvent.ShowInterstitialAdsOnBack(this);
    }
}