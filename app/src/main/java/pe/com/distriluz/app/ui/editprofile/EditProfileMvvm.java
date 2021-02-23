package pe.com.distriluz.app.ui.editprofile;


import androidx.databinding.ObservableBoolean;

import pe.com.distriluz.app.ui.base.view.MvvmView;
import pe.com.distriluz.app.ui.base.viewmodel.IViewModel;


public interface EditProfileMvvm {

    interface View extends MvvmView {

    }

    interface ViewModel extends IViewModel<View> {
        // Properties

        @Override
        ObservableBoolean isLoaded();

        EditProfileObservableModel getModel();

        void onClickGuardar(android.view.View view);
        void onClickClose(android.view.View view);
        void onClickChangePhoto(android.view.View view);
    }
}
