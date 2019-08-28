package com.example.myapplication;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;

public class MyApp extends Application {
    private static final String TAG = "MyApp";
    private static final boolean DEBUG = true;


    @Override
    protected void attachBaseContext(Context base) {
        Log.d(TAG, "attachBaseContext() called with: base = [" + base + "]");
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate() called");
        super.onCreate();
      /*  Retrofits.init("http://www.baidu.com", new ParamProvider() {
            @Override
            public Object getHeaderParam(String paramName) {
                Log.d(TAG, "getHeaderParam() called with: paramName = [" + paramName + "]");
                return null;
            }

            @Override
            public Object getUrlParam(String paramName) {
                Log.d(TAG, "getUrlParam() called with: paramName = [" + paramName + "]");
                return null;
            }

            @Override
            public Object getQueryParam(String paramName) {
                Log.d(TAG, "getQueryParam() called with: paramName = [" + paramName + "]");
                return null;
            }
        });*/
    }

    @Override
    public void onTerminate() {
        Log.d(TAG, "onTerminate() called");
        super.onTerminate();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.d(TAG, "onConfigurationChanged() called with: newConfig = [" + newConfig + "]");
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory() {
        Log.d(TAG, "onLowMemory() called");
        super.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        Log.d(TAG, "onTrimMemory() called with: level = [" + level + "]");
        super.onTrimMemory(level);
    }
}
