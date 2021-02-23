package pe.com.distriluz.app.ui.changepassword;


import androidx.databinding.ObservableBoolean;

import pe.com.distriluz.app.ui.base.view.MvvmView;
import pe.com.distriluz.app.ui.base.viewmodel.IViewModel;


public interface ChangePasswordMvvm {

    interface View extends MvvmView {

    }

    interface ViewModel extends IViewModel<View> {
        // Properties

        ChangePasswordObservableModel getModel();

        void onClickEnviarEmail(android.view.View v);

        @Override
        ObservableBoolean isLoaded();
    }
}
