package pe.com.distriluz.app.ui.base.viewmodel;

import pe.com.distriluz.app.ui.base.view.MvvmView;


public interface DinamicFormMvvmViewModel<V extends MvvmView> extends IViewModel<V> {

    void onClickChangeDate(android.view.View v);
    void onClickList(android.view.View v);

    void destroy();
}
