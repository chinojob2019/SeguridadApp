package pe.com.distriluz.app.ui.appslista.recyclerView;


import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;

import pe.com.distriluz.app.ui.appslista.AppsObservableModel;
import pe.com.distriluz.app.ui.base.view.MvvmView;
import pe.com.distriluz.app.ui.base.viewmodel.IViewModel;
import pe.com.distriluz.app.ui.clientelistar.ClienteListarObservableModel;


public interface AppsItemMvvm {

    interface View extends MvvmView {
        void reloadApps();
    }

    interface ViewModel extends IViewModel<View> {

        void onClickItem(android.view.View v);
        void onClickApp(android.view.View v);

        @Override
        ObservableBoolean isLoaded();

        void update(AppsObservableModel.AppObservable app);

        AppsObservableModel.AppObservable getModel();
    }
}
