package com.geektech.firstarchitecturelesson.data;

import android.content.Context;

import com.geektech.util.shared.SharedPrefsStorage;
import com.geektech.firstarchitecturelesson.data.user.UserDataSource;
import com.geektech.firstarchitecturelesson.data.user.UserRepository;
import com.geektech.firstarchitecturelesson.data.user.local.UserLocalDataSource;
import com.geektech.firstarchitecturelesson.data.user.remote.UserRemoteDataSource;

/**
 * Created by askar on 1/15/19
 * with Android Studio
 */
public class RepositoryProvider {
    public static UserDataSource getUserSource(Context context){
        return UserRepository.getInstance(
                UserLocalDataSource.getInstance(
                        SharedPrefsStorage.getInstance(context)
                ),
                UserRemoteDataSource.getInstance()
        );
    }
}
