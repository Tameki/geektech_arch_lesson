package com.geektech.core.mvp;

/**
 * Created by askar on 1/11/19
 * with Android Studio
 */
public interface BaseMVPContract {

    interface View<T extends Presenter> {
        void finishView();

        void attachPresenter(T presenter);
    }

    interface Presenter<T extends View> {
        void attachView(T view);

        void detachView();
    }

}
