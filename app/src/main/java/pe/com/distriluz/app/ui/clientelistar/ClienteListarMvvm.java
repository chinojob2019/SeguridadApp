package pe.com.distriluz.app.ui.clientelistar;


import androidx.databinding.ObservableBoolean;

import pe.com.distriluz.app.ui.base.view.MvvmView;
import pe.com.distriluz.app.ui.base.viewmodel.IViewModel;


public interface ClienteListarMvvm {

    interface View extends MvvmView {

        void ocultarKeyboard();

        void updateAdapter();
    }

    interface ViewModel extends IViewModel<View> {
        // Properties
        ClienteListarObservableModel getModel();

        @Override
        ObservableBoolean isLoaded();

        void onClickOpenDrawer (android.view.View view);
        void onClickOpenProfile (android.view.View view);
    }
}
