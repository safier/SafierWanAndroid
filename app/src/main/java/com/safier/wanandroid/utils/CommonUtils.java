package com.safier.wanandroid.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.safier.wanandroid.app.WanAndroidApp;

/**
 * @author safier
 * @date 2019/4/23
 */
public class CommonUtils {

    public static boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) WanAndroidApp.getContext().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connectivityManager != null;
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        return info != null && info.isConnected();
    }

    public static void hideKeyBoard(Context context, View view) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) context.getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager.isActive()) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }


}
