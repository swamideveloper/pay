package com.test.myapp.vcall.tumsehi;

import static com.test.myapp.vcall.tumsehi.haifasle.incoming_counter;
import static com.test.myapp.vcall.tumsehi.haifasle.isVectorShow;
import static com.test.myapp.vcall.shyame.aakhometeri.native_ShowAds;
import static com.test.myapp.vcall.surmesham.tumpass.connectInComing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.ads.sdk.IntertitialAdsEvent;
import com.ads.sdk.new_configs.Data_Preference;
import com.test.myapp.vcall.R;
import com.test.myapp.vcall.harghadi.teraname;

public class milokefasle extends AppCompatActivity {

    private LinearLayout room1, room2, room3, room4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);

        if (!isVectorShow) {
            ((ImageView) findViewById(R.id.vector_pro)).setVisibility(View.GONE);
        }

        incoming_counter++;

        Data_Preference.show_anim_header(this, (RelativeLayout) findViewById(R.id.rl_anim_header));
        IntertitialAdsEvent.ShowInterstitialAdsOnCreate(this);
        if (new Data_Preference(this).getKeyOnresumenativeshow().equals("0")) {
            native_ShowAds(this, findViewById(R.id.native_container), 1);
        }


        room1 = findViewById(R.id.room1);
        room2 = findViewById(R.id.room2);
        room3 = findViewById(R.id.room3);
        room4 = findViewById(R.id.room4);

        room1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });
        room2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });
        room3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });
        room4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });
    }

    private void next() {
        if (new Data_Preference(milokefasle.this).getIncoming_Counter().equalsIgnoreCase(String.valueOf(incoming_counter))) {
            connectInComing(milokefasle.this);
        } else {
            startActivity(new Intent(milokefasle.this, teraname.class));
        }
    }

    @Override
    public void onBackPressed() {
        IntertitialAdsEvent.ShowInterstitialAdsOnBack(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (new Data_Preference(this).getKeyOnresumenativeshow().equals("1")) {
            native_ShowAds(this, findViewById(R.id.native_container), 1);
        }
    }
}