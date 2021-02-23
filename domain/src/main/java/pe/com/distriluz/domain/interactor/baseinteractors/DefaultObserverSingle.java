package pe.com.distriluz.domain.interactor.baseinteractors;

import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.DisposableSingleObserver;

/**
 * Default {@link DisposableObserver} base class to be used whenever you want default error handling.
 */
public class DefaultObserverSingle<T> extends DisposableSingleObserver<T> {

    @Override
    public void onSuccess(T t) {

    }

    @Override
    public void onError(Throwable e) {

    }
}
