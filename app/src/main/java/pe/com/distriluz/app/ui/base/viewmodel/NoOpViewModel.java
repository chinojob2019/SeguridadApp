package pe.com.distriluz.app.ui.base.viewmodel;

import android.os.Bundle;

import androidx.databinding.BaseObservable;

import javax.inject.Inject;

import pe.com.distriluz.app.ui.base.view.MvvmView;

public final class NoOpViewModel extends BaseObservable implements MvvmViewModel<MvvmView> {

    @Inject
    public NoOpViewModel() {
    }

    @Override
    public void attachView(MvvmView mvvmView, Bundle savedInstanceState) {
    }

    @Override
    public void saveInstanceState(Bundle outState) {
    }

    @Override
    public void onPermissionsSuccess() {

    }

    @Override
    public void isLoadViews() {

    }

    @Override
    public void detachView() {
    }


}