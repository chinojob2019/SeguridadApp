package pe.com.distriluz.app.ui.login;


import androidx.databinding.ObservableBoolean;

import pe.com.distriluz.app.ui.base.view.MvvmView;
import pe.com.distriluz.app.ui.base.viewmodel.IViewModel;




public interface LoginMvvm {

    interface View extends MvvmView {

    }

    interface ViewModel extends IViewModel<View> {
        // Properties
        LoginObservableModel getModel();

        void onClickIniciarSesion(android.view.View v);


        void onClickForgotPassword(android.view.View v);

        void onClickShowList(android.view.View v);



        @Override
        ObservableBoolean isLoaded();
    }
}
