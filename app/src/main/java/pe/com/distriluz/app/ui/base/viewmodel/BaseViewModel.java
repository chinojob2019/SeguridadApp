package pe.com.distriluz.app.ui.base.viewmodel;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;

import pe.com.distriluz.app.ui.base.MvvmViewNotAttachedException;
import pe.com.distriluz.app.ui.base.view.MvvmView;


/**
 * Base class that implements the ViewModel interface and provides a base implementation for
 * attachView() and detachView(). It also handles keeping a reference to the mvvmView that
 * can be accessed from the children classes by calling getMvpView().
 * <p>
 * When saving state is required, restoring is handled automatically when calling attachView().
 * However, saveInstanceState() must still be called in the corresponding lifecycle callback.
 */
public abstract class BaseViewModel<V extends MvvmView> extends BaseObservable implements MvvmViewModel<V> {

    private V mvvmView;
    protected boolean isPermissionValid=true;

    @Override
    @CallSuper
    public void attachView(V mvvmView, @Nullable Bundle savedInstanceState) {
        this.mvvmView = mvvmView;
        if (savedInstanceState != null) {
            restoreInstanceState(savedInstanceState);
        }
    }

    @Override
    @CallSuper
    public void detachView() {
        mvvmView = null;
    }

    protected void restoreInstanceState(@NonNull Bundle savedInstanceState) {
    }

    public void saveInstanceState(Bundle outState) {
    }

    public final boolean isViewAttached() {
        return mvvmView != null;
    }

    public final V getView() {
        return mvvmView;
    }

    public final void checkViewAttached() {
        if (!isViewAttached()) throw new MvvmViewNotAttachedException();
    }

    protected void toast(Context con, String mensaje) {
        Toast.makeText(con, mensaje, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPermissionsSuccess() {

    }

    @Override
    public void isLoadViews() {

    }
}
