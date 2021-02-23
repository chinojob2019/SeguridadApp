package pe.com.distriluz.app.ui.codeconfirm;


import androidx.databinding.ObservableBoolean;

import pe.com.distriluz.app.ui.base.view.MvvmView;
import pe.com.distriluz.app.ui.base.viewmodel.IViewModel;


public interface CodeConfirmMvvm {

    interface View extends MvvmView {

        void ocultarKeyboard();
    }

    interface ViewModel extends IViewModel<View> {
        // Properties
        CodeConfirmObservableModel getModel();


        void onClickEnviarEmail(android.view.View v);



        @Override
        ObservableBoolean isLoaded();
    }
}
