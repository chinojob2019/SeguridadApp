package pe.com.distriluz.app.ui.updatepregunta;


import android.widget.CompoundButton;

import androidx.databinding.ObservableBoolean;

import pe.com.distriluz.app.ui.base.view.MvvmView;
import pe.com.distriluz.app.ui.base.viewmodel.IViewModel;


public interface UpdatePreguntaMvvm {

    interface View extends MvvmView {

    }

    interface ViewModel extends IViewModel<View> {
        // Properties

        @Override
        ObservableBoolean isLoaded();

        UpdatePreguntaObservableModel getModel();

        void onClickGuardar(android.view.View view);
        void rememberMeChanged(CompoundButton buttonView,  Boolean isChecked) ;

        void onClickClose(android.view.View view);

    }
}
