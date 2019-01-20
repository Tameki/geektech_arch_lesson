package com.geektech.firstarchitecturelesson.data.user.remote;

import android.support.annotation.Nullable;

import com.geektech.firstarchitecturelesson.data.user.UserDataSource;
import com.geektech.firstarchitecturelesson.data.user.model.User;

/**
 * Created by askar on 1/15/19
 * with Android Studio
 */
public class UserRemoteDataSource implements UserDataSource {

    //region Static

    private static UserDataSource INSTANCE;

    public static UserDataSource getInstance(){
        if (INSTANCE == null) {
            INSTANCE = new UserRemoteDataSource();
        }
        return INSTANCE;
    }

    //endregion


    @Override
    public void setUser(User user) {

    }

    @Override
    public void clearUser() {

    }

    @Nullable
    @Override
    public User getUser() {
        return null;
    }
}
