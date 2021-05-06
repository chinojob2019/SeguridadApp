package pe.com.distriluz.app.ui.updaterespuesta;


import android.widget.CompoundButton;

import androidx.databinding.ObservableBoolean;

import pe.com.distriluz.app.ui.base.view.MvvmView;
import pe.com.distriluz.app.ui.base.viewmodel.IViewModel;


public interface UpdateRespuestaMvvm {

    interface View extends MvvmView {

    }

    interface ViewModel extends IViewModel<View> {
        // Properties

        @Override
        ObservableBoolean isLoaded();

        UpdateRespuestaObservableModel getModel();

        void onClickGuardar(android.view.View view);
        void rememberMeChanged(CompoundButton buttonView,  Boolean isChecked) ;

        void onClickClose(android.view.View view);

    }
}
