package com.geektech.firstarchitecturelesson.presentation.login;

import com.geektech.core.mvp.BaseMVPContract;

/**
 * Created by askar on 1/11/19
 * with Android Studio
 */
public interface LoginContract {
    interface View extends BaseMVPContract.View<Presenter> {
        void onLoginSuccess();

        void onLoginFailure(String message);

        void openAuth();
    }

    interface Presenter extends BaseMVPContract.Presenter<View> {
        void onLoginClick(String name, String password);

        void onForgetPassword();
    }
}
