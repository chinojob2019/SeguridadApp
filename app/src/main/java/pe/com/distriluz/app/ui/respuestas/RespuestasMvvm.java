package pe.com.distriluz.app.ui.respuestas;

import android.content.Intent;

import androidx.databinding.ObservableBoolean;

import pe.com.distriluz.app.ui.base.view.MvvmView;
import pe.com.distriluz.app.ui.base.viewmodel.IViewModel;
import pe.com.distriluz.app.ui.respuestas.RespuestasObservableModel;

public interface RespuestasMvvm {
    interface View extends MvvmView {
        void changeGlobal();
        void habilitarbotones(Boolean valor);

    }

    interface ViewModel extends IViewModel<View> {

        @Override
        ObservableBoolean isLoaded();

        RespuestasObservableModel getModel();
        void onClickListadoRespuestas(RespuestasObservableModel.RespuestasItem item);

        void onClickOpenDrawer(android.view.View view);
void onClickBackFragment();
        void onClickAddRespuesta(android.view.View view);
        void onClickBackEditar(android.view.View view);
        void onClickMasivoActivar(android.view.View view);
        void onClickMasivoEliminar(android.view.View view);
        void onClickEditarPregunta(android.view.View view);
void onClickEditarRespuesta(RespuestasObservableModel.RespuestasItem item);


        void onActivityResult(int requestCode, int resultCode, Intent data);

    }
}
