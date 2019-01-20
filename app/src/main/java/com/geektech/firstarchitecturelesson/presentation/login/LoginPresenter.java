package com.geektech.firstarchitecturelesson.presentation.login;

import com.geektech.firstarchitecturelesson.data.user.UserDataSource;
import com.geektech.firstarchitecturelesson.data.user.model.User;

/**
 * Created by askar on 1/11/19
 * with Android Studio
 */
public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View mView = null;
    private UserDataSource mUserDataSource;

    public LoginPresenter(UserDataSource userDataSource) {
        this.mUserDataSource = userDataSource;
    }

    @Override
    public void onLoginClick(String name, String password) {
        if (mView != null) {
            User user = mUserDataSource.getUser();

            if (user != null) {
                if (user.getName().equals(name) &&
                        user.getPassword().equals(password)) {
                    mView.onLoginSuccess();
                    mView.finishView();
                } else {
                    mView.onLoginFailure("Login failed!");
                }
            } else {
                mView.onLoginFailure("User not valid!");
            }
        }
    }

    @Override
    public void onForgetPassword() {

    }

    @Override
    public void attachView(LoginContract.View view) {
        this.mView = view;
        view.attachPresenter(this);
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
