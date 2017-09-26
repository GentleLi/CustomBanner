package com.gentler.custombanner;

import android.app.Application;

import com.gentler.custombanner.utils.Utils;

/**
 * Created by jiantao on 2017/9/26.
 */

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Utils.init(getApplicationContext());
    }
}
