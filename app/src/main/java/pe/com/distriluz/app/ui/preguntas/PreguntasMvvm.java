package pe.com.distriluz.app.ui.preguntas;

import android.view.View;

import androidx.databinding.ObservableBoolean;

import pe.com.distriluz.app.ui.base.view.MvvmView;
import pe.com.distriluz.app.ui.base.viewmodel.IViewModel;

public interface PreguntasMvvm {
    interface View extends MvvmView {
    }

    interface ViewModel extends IViewModel<View> {

        @Override
        ObservableBoolean isLoaded();

        PreguntasObservableModel getModel();

        void onClickOpenDrawer(android.view.View view);
    }
}
