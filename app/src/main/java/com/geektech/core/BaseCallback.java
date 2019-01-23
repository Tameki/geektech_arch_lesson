package com.geektech.core;

/**
 * Created by askar on 1/22/19
 * with Android Studio
 */
public interface BaseCallback<T> {
    void onSuccess(T result);

    void onFail(String message);
}
