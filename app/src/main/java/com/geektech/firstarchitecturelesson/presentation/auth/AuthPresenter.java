package com.geektech.firstarchitecturelesson.presentation.auth;

import com.geektech.firstarchitecturelesson.data.user.UserDataSource;
import com.geektech.firstarchitecturelesson.data.user.model.User;

/**
 * Created by askar on 1/18/19
 * with Android Studio
 */
public class AuthPresenter implements AuthContract.Presenter {
    private AuthContract.View mView;
    private UserDataSource mUserDataSource;

    public AuthPresenter(UserDataSource userDataSource) {
        this.mUserDataSource = userDataSource;
    }

    @Override
    public void onAuthClick(String name, String password) {
        mUserDataSource.setUser(new User(name, password));
        if (mView != null) {
            mView.onAuthSuccess();
            mView.finishView();
        }
    }

    @Override
    public void attachView(AuthContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
