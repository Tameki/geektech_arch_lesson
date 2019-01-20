package com.geektech.firstarchitecturelesson.data.user;

import android.support.annotation.Nullable;

import com.geektech.firstarchitecturelesson.data.user.model.User;

/**
 * Created by askar on 1/15/19
 * with Android Studio
 */
public interface UserDataSource {
    void setUser(User user);

    void clearUser();

    @Nullable
    User getUser();
}
