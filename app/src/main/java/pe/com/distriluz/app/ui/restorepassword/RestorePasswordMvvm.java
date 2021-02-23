package pe.com.distriluz.app.ui.restorepassword;


import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;

import pe.com.distriluz.app.ui.base.view.MvvmView;
import pe.com.distriluz.app.ui.base.viewmodel.IViewModel;


public interface RestorePasswordMvvm {

    interface View extends MvvmView {

    }

    interface ViewModel extends IViewModel<View> {
        // Properties

        RestorePasswordObservableModel getModel();

        void onClickEnviarPass(android.view.View v);

        @Override
        ObservableBoolean isLoaded();
    }
}
