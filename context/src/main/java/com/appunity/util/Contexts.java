package com.appunity.util;

import android.app.ActivityThread;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;

/**
 * Access a global {@link Application} context from anywhere, such as getting a context in a Library
 * module without attaching it from App module.
 *
 * <p>
 * Note:
 * <br/>
 * The current implementation uses the non-SDK interface. I have reviewed the change history
 * of ActivityThread.java to ensure that it works fine under existing Android,
 * but may not be usable in future versions (current time 20190828).
 * And may not work in some cases,such as working with a hotfix framework or access when the
 * App is terminated
 * </p>
 * before use , you should read the following:<br/>
 * Restrictions on non-SDK interfaces<br/>
 * https://developer.android.com/distribute/best-practices/develop/restrictions-non-sdk-interfaces<br/>
 * <p>
 * Test pass:
 * Android 10
 * Android 9
 *
 * @author zhangzhenli
 */
public class Contexts {
    private static final String TAG = "Contexts";
    private static final boolean DEBUG = true;


    private static Application application;

    private static Object lock = new Object();

    /**
     * Get context.
     *
     * @return context
     */
    public static Context getContext() {
        if (application == null) {
            initContext();
        }
        return application;
    }

    private static synchronized void initContext() {
        if (application != null) {
            return;
        }
        final Application[] app = new Application[1];
        // before android 	4.3 ( target 18）ActivityThread hold instance in ThreadLocal
        // https://github.com/aosp-mirror/platform_frameworks_base/blob/jb-mr1.1-release/core/java/android/app/ActivityThread.java
        // https://github.com/aosp-mirror/platform_frameworks_base/blob/jb-mr2-release/core/java/android/app/ActivityThread.java
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2 || isMainThread()) {
            ActivityThread activityThread = ActivityThread.currentActivityThread();
            app[0] = ActivityThread.currentApplication();
        } else {
            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(new Runnable() {
                @Override
                public void run() {
                    synchronized (lock) {
                        app[0] = ActivityThread.currentApplication();
                        lock.notifyAll();
                    }
                }
            });
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        application = app[0];
    }

    private static boolean isMainThread() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                ? Looper.getMainLooper().isCurrentThread()
                : Thread.currentThread() == Looper.getMainLooper().getThread();
    }
}
