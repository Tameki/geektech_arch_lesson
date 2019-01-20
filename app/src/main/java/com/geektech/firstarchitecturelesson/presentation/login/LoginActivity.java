package com.geektech.firstarchitecturelesson.presentation.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.geektech.firstarchitecturelesson.data.RepositoryProvider;

/**
 * Created by askar on 1/11/19
 * with Android Studio
 */
public class LoginActivity extends AppCompatActivity {
    private LoginContract.Presenter mPresenter = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LoginFragment fragment = new LoginFragment();

        mPresenter = new LoginPresenter(
                RepositoryProvider.getUserSource(getApplicationContext())
        );

        mPresenter.attachView(fragment);

        getSupportFragmentManager()
                .beginTransaction()
                .add(android.R.id.content, fragment)
                .commit();
    }
}
