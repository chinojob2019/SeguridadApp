package pe.com.distriluz.app.ui.base.viewmodel;


import io.reactivex.disposables.CompositeDisposable;
import pe.com.distriluz.app.ui.base.view.MvvmView;

public abstract class RxBaseStateViewModel<T extends MvvmView, S> extends BaseStateViewModel<T, S> {

    protected final CompositeDisposable disposable = new CompositeDisposable();

    @Override
    public void detachView() {
        super.detachView();
        disposable.clear();
    }
}
