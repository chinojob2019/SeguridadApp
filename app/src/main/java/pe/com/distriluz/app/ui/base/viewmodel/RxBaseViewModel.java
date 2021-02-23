package pe.com.distriluz.app.ui.base.viewmodel;


import io.reactivex.disposables.CompositeDisposable;
import pe.com.distriluz.app.ui.base.view.MvvmView;

public abstract class RxBaseViewModel<T extends MvvmView> extends BaseViewModel<T> {

    protected final CompositeDisposable disposable = new CompositeDisposable();

    @Override
    public void detachView() {
        super.detachView();
        disposable.clear();
    }
}
