package pe.com.distriluz.app.ui.validatecode;


import androidx.databinding.ObservableBoolean;

import pe.com.distriluz.app.ui.base.view.MvvmView;
import pe.com.distriluz.app.ui.base.viewmodel.IViewModel;


public interface ValidateCodeMvvm {

    interface View extends MvvmView {

        String getCode();

        void clearText();
    }

    interface ViewModel extends IViewModel<View> {
        // Properties

        void onClickSendCode(android.view.View v);
        void onClickOpenKeyBoard(android.view.View v);

        @Override
        ObservableBoolean isLoaded();
    }
}
