package pe.com.distriluz.app.ui.preguntaslectura;

import androidx.databinding.ObservableBoolean;

import pe.com.distriluz.app.ui.base.view.MvvmView;
import pe.com.distriluz.app.ui.base.viewmodel.IViewModel;

public interface PreguntasLecturaMvvm {
    interface View extends MvvmView {
    }

    interface ViewModel extends IViewModel<View> {

        @Override
        ObservableBoolean isLoaded();

        PreguntasLecturaObservableModel getModel();

        void onClickOpenDrawer(android.view.View view);

    }
}
