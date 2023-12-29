package com.test.myapp.vcall.surmesham;

import android.app.Activity;
import android.content.Intent;

import com.test.myapp.vcall.harghadi.musiconly;

public class tumpass {

    public static void connectInComing(Activity context) {
        context.startActivity(new Intent(context, musiconly.class));
    }
}
