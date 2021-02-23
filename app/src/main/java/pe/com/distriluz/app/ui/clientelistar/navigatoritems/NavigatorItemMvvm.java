package pe.com.distriluz.app.ui.clientelistar.navigatoritems;


import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;

import pe.com.distriluz.app.ui.base.view.MvvmView;
import pe.com.distriluz.app.ui.base.viewmodel.IViewModel;
import pe.com.distriluz.app.ui.clientelistar.ClienteListarObservableModel;


public interface NavigatorItemMvvm {

    interface View extends MvvmView {
        void setActive();
    }

    interface ViewModel extends IViewModel<View> {

        void onClickItem(android.view.View v);

        @Override
        ObservableBoolean isLoaded();

        ObservableField<Boolean> getIsActive();

        void update(ClienteListarObservableModel.NavigationItems servicio, boolean isActive, IViewModel listener);
        ClienteListarObservableModel.NavigationItems getModel();
    }
}
