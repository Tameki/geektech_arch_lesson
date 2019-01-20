package com.geektech.firstarchitecturelesson.presentation.auth;

import android.support.v4.app.Fragment;

import com.geektech.firstarchitecturelesson.presentation.main.MainActivity;

/**
 * Created by askar on 1/18/19
 * with Android Studio
 */
public class AuthFragment extends Fragment
        implements AuthContract.View {

    @Override
    public void onAuthSuccess() {
        if (getActivity() != null) {
            MainActivity.start(getActivity());
        }
    }

    @Override
    public void onAuthFailure(String message) {

    }

    @Override
    public void finishView() {

    }

    @Override
    public void attachPresenter(AuthContract.Presenter presenter) {

    }
}
