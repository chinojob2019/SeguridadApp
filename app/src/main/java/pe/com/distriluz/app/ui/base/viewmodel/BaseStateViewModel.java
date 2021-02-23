

package pe.com.distriluz.app.ui.base.viewmodel;

import android.os.Bundle;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;

import org.parceler.Parcels;

import javax.inject.Inject;

import pe.com.distriluz.app.ui.base.MvvmViewNotAttachedException;
import pe.com.distriluz.app.ui.base.view.MvvmView;

/**
 * Base class that implements the ViewModel interface and provides a base implementation for
 * attachView() and detachView(). It also handles keeping a reference to the mvvmView that
 * can be accessed from the children classes by calling getMvpView().
 * <p>
 * When saving state is required, restoring is handled automatically when calling attachView().
 * However, saveInstanceState() must still be called in the corresponding lifecycle callback.
 * <p>
 * Create an inner class in your view model implementations that keeps the view state, so that
 * it can be injected here. Also, state saving/restoring is automatically handled by this base class.
 */
public abstract class BaseStateViewModel<T extends MvvmView, S> extends BaseObservable implements MvvmViewModel<T> {

    private final String KEY_STATE = "state";
    @Inject
    protected S state;
    private T mvvmView;

    @Override
    @CallSuper
    public void attachView(T mvpView, @Nullable Bundle savedInstanceState) {
        mvvmView = mvpView;
        if (savedInstanceState != null) {
            restoreInstanceState(savedInstanceState);
        }
    }

    @Override
    @CallSuper
    public void detachView() {
        mvvmView = null;
    }

    @Override
    public void saveInstanceState(Bundle outState) {
        outState.putParcelable(KEY_STATE, Parcels.wrap(state));
    }

    protected void restoreInstanceState(@NonNull Bundle savedInstanceState) {
        if (savedInstanceState.containsKey(KEY_STATE)) {
            state = Parcels.unwrap(savedInstanceState.getParcelable(KEY_STATE));
        }
    }

    public final boolean isViewAttached() {
        return mvvmView != null;
    }

    public final T getMvvmView() {
        return mvvmView;
    }

    public final void checkViewAttached() {
        if (!isViewAttached()) throw new MvvmViewNotAttachedException();
    }

    public S getState() {
        return state;
    }

    @Override
    public void onPermissionsSuccess() {

    }

    @Override
    public void isLoadViews() {

    }
}

