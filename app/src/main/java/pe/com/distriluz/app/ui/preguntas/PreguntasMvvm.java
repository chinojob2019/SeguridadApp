package pe.com.distriluz.app.ui.preguntas;

import android.content.Intent;
import android.view.View;

import androidx.databinding.ObservableBoolean;

import pe.com.distriluz.app.ui.base.view.MvvmView;
import pe.com.distriluz.app.ui.base.viewmodel.IViewModel;
import pe.com.distriluz.app.ui.clientelistar.ClienteListarObservableModel;

public interface PreguntasMvvm {
    interface View extends MvvmView {
        void changeGlobal();
    }

    interface ViewModel extends IViewModel<View> {

        @Override
        ObservableBoolean isLoaded();

        PreguntasObservableModel getModel();

        void onClickOpenDrawer(android.view.View view);

        void onClickAddPregunta(android.view.View view);
        void onClickBackEditar(android.view.View view);

        void onActivityResult(int requestCode, int resultCode, Intent data);

    }
}
