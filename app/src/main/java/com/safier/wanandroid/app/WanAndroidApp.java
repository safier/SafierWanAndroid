package com.safier.wanandroid.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * @author safier
 * @date 2019/4/23
 */
public class WanAndroidApp extends Application implements HasActivityInjector{

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

    }

    @Inject
    DispatchingAndroidInjector<Activity> mAndroidInjector;

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return mAndroidInjector;
    }

    public static Context getContext() {
        return context;
    }
}
