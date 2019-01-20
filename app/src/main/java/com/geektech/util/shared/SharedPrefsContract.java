package com.geektech.util.shared;

/**
 * Created by askar on 1/18/19
 * with Android Studio
 */
public interface SharedPrefsContract {
    String getString(String key, String defaultValue);

    void setString(String key, String value);

    Boolean contains(String key);
}
