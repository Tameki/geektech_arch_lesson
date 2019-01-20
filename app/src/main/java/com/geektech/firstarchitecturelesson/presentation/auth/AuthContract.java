package com.geektech.firstarchitecturelesson.presentation.auth;

import com.geektech.core.mvp.BaseMVPContract;

/**
 * Created by askar on 1/18/19
 * with Android Studio
 */
public interface AuthContract {
    interface View extends BaseMVPContract.View<Presenter> {
        void onAuthSuccess();

        void onAuthFailure(String message);
    }

    interface Presenter extends BaseMVPContract.Presenter<View> {
        void onAuthClick(String name, String password);
    }
}
