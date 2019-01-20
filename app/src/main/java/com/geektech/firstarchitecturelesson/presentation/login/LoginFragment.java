package com.geektech.firstarchitecturelesson.presentation.login;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.geektech.firstarchitecturelesson.R;
import com.geektech.firstarchitecturelesson.presentation.main.MainActivity;

/**
 * Created by askar on 1/11/19
 * with Android Studio
 */
public class LoginFragment extends Fragment
        implements LoginContract.View, View.OnClickListener {

    private LoginContract.Presenter mPresenter = null;

    private EditText mNameInput, mPasswordInput;
    private Button mLoginBtn;

    public static LoginFragment newInstance() {
        Bundle args = new Bundle();
        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }

    //region Lifecycle

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.fragment_login,
                container,
                false
        );

        init(rootView);

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    //endregion

    //region Private

    private void init(View view) {
        mNameInput = view.findViewById(R.id.fragment_login_name_input);
        mPasswordInput = view.findViewById(R.id.fragment_login_password_input);
        mLoginBtn = view.findViewById(R.id.fragment_login_btn);

        mLoginBtn.setOnClickListener(this);
    }

    //endregion

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fragment_login_btn:
                onLoginClick();
                break;
        }
    }

    private void onLoginClick() {
        mPresenter.onLoginClick(
                mNameInput.getText().toString(),
                mPasswordInput.getText().toString()
        );
    }

    //region Contract

    @Override
    public void openAuth() {

    }

    @Override
    public void attachPresenter(LoginContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onLoginSuccess() {
        if (getActivity() != null) {
            MainActivity.start(getActivity());
        }
    }

    @Override
    public void onLoginFailure(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    public void finishView() {
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    //endregion
}
