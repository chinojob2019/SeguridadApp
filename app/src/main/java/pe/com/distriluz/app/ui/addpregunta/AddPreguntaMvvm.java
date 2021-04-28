package pe.com.distriluz.app.ui.addpregunta;


import android.widget.CompoundButton;

import androidx.databinding.ObservableBoolean;

import pe.com.distriluz.app.ui.base.view.MvvmView;
import pe.com.distriluz.app.ui.base.viewmodel.IViewModel;


public interface AddPreguntaMvvm {

    interface View extends MvvmView {

    }

    interface ViewModel extends IViewModel<View> {
        // Properties

        @Override
        ObservableBoolean isLoaded();

        AddPreguntaObservableModel getModel();

        void onClickGuardar(android.view.View view);
        void rememberMeChanged(CompoundButton buttonView,  Boolean isChecked) ;

        void onClickClose(android.view.View view);

    }
}
