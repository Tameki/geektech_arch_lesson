package com.geektech.firstarchitecturelesson.data.user.local;

import android.support.annotation.Nullable;

import com.geektech.util.shared.SharedPrefsContract;
import com.geektech.firstarchitecturelesson.data.user.UserDataSource;
import com.geektech.firstarchitecturelesson.data.user.model.User;

/**
 * Created by askar on 1/15/19
 * with Android Studio
 */
public class UserLocalDataSource implements UserDataSource {

    @Nullable
    private SharedPrefsContract mSharedStorage;

    private UserLocalDataSource(
            SharedPrefsContract sharedPrefsStorage
    ) {
        mSharedStorage = sharedPrefsStorage;
    }

    //region Static

    private static UserDataSource INSTANCE;
    private static String PREF_NAME = "user_name";
    private static String PREF_PASSWORD = "user_password";

    public static UserDataSource getInstance(
            SharedPrefsContract sharedPrefsStorage
    ){
        if (INSTANCE == null) {
            INSTANCE = new UserLocalDataSource(sharedPrefsStorage);
        }
        return INSTANCE;
    }

    //endregion

    //region Private

    private User loadUser(){
        return new User(
                "Tameki",
                "123456789"
        );
    }

    //endregion

    //region Contract

    @Override
    public void setUser(User user) {
        //TODO: Write to Shared prefs
    }

    @Override
    public void clearUser() {

        //TODO: CLear Shared prefs
    }

    @Nullable
    @Override
    public User getUser() {
        return loadUser();
    }

    //endregion

}
