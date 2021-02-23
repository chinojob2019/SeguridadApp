package pe.com.distriluz.app.ui.appslista;

import androidx.databinding.ObservableBoolean;

import pe.com.distriluz.app.ui.base.view.MvvmView;
import pe.com.distriluz.app.ui.base.viewmodel.IViewModel;
import pe.com.distriluz.app.ui.clientelistar.ClienteListarObservableModel;

public interface AppListaMvvm {
    interface View extends MvvmView {
        void updateAdapter();

        void reloadListApps();
    }

    interface ViewModel extends IViewModel<View> {

        @Override
        ObservableBoolean isLoaded();

        AppsObservableModel getModel();

        void getAllApps();

        void onClickShowGrid(android.view.View view);

        void onClickShowList(android.view.View view);

        void onClickOpenDrawer(android.view.View view);

        void setActivityModel(ClienteListarObservableModel activityModel);
        ClienteListarObservableModel getActivityModel();
    }
}
