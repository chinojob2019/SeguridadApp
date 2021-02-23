package pe.com.distriluz.app.ui.base.viewmodel;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.Observable;

import pe.com.distriluz.app.ui.base.view.MvvmView;


public interface MvvmViewModel<V extends MvvmView> extends Observable {
    void attachView(V view, Bundle savedInstanceState);
    void detachView();
    void saveInstanceState(@NonNull Bundle outState);

    void onPermissionsSuccess();

    void isLoadViews();
}
