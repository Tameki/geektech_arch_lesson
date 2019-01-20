package com.geektech.util.shared;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by askar on 1/18/19
 * with Android Studio
 */
public class SharedPrefsStorage implements SharedPrefsContract{

    private SharedPreferences mShared;

    private SharedPrefsStorage(Context context) {
        mShared = context.getSharedPreferences(
                "shared",
                Context.MODE_PRIVATE
        );
    }

    //region Static

    private static SharedPrefsContract INSTANCE;

    public static SharedPrefsContract getInstance(
            Context context
    ){
        if (INSTANCE == null) {
            INSTANCE = new SharedPrefsStorage(context);
        }
        return INSTANCE;
    }

    //endregion

    @Override
    public String getString(String key, String defaultValue) {
        return mShared.getString(key, defaultValue);
    }

    @Override
    public void setString(String key, String value) {
        //TODO: Save to Shared
    }

    @Override
    public Boolean contains(String key) {
        return mShared.contains(key);
    }
}
