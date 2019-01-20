package com.geektech.firstarchitecturelesson.data.user;

import android.support.annotation.Nullable;

import com.geektech.firstarchitecturelesson.data.user.model.User;

/**
 * Created by askar on 1/15/19
 * with Android Studio
 */
public class UserRepository implements UserDataSource {
    @Nullable
    private UserDataSource mRemote;
    @Nullable
    private UserDataSource mLocal;

    private UserRepository(
            UserDataSource local,
            UserDataSource remote
    ) {
        this.mLocal = local;
        this.mRemote = remote;
    }

    //region Static

    private static UserRepository INSTANCE;

    public static UserDataSource getInstance(
            UserDataSource local,
            UserDataSource remote
    ){
        if (INSTANCE == null) {
            INSTANCE = new UserRepository(local, remote);
        }

        return INSTANCE;
    }

    //endregion

    //region Contract

    @Override
    public void setUser(User user) {
        if (mLocal != null) {
            mLocal.setUser(user);
        }
    }

    @Override
    public void clearUser() {
        if (mLocal != null) {
            mLocal.clearUser();
        }
    }

    @Nullable
    @Override
    public User getUser() {
        if (mLocal != null) {
            return mLocal.getUser();
        }

        return null;
    }

    //endregion
}
