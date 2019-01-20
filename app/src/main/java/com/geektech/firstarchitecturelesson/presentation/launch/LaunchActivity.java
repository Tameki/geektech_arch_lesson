package com.geektech.firstarchitecturelesson.presentation.launch;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.geektech.firstarchitecturelesson.data.RepositoryProvider;
import com.geektech.firstarchitecturelesson.presentation.auth.AuthActivity;
import com.geektech.firstarchitecturelesson.presentation.login.LoginActivity;

/**
 * Created by askar on 1/15/19
 * with Android Studio
 */
public class LaunchActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (RepositoryProvider.getUserSource(getApplicationContext())
                .getUser() != null) {
//            LoginActivity.start(this);
        } else {
//            AuthActivity.start(this);
        }
    }
}
