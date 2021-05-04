package pe.com.distriluz.app.ui.respuestas.recyclerview;


import android.widget.CompoundButton;

import pe.com.distriluz.app.ui.base.view.MvvmView;
import pe.com.distriluz.app.ui.base.viewmodel.IViewModel;

import pe.com.distriluz.app.ui.respuestas.RespuestasObservableModel;


public interface RespuestaItemMvvm {

    interface View extends MvvmView {
    }

    interface ViewModel extends IViewModel<View> {

        void onClickItem(CompoundButton buttonView, boolean isChecked);
        void onClickListarRespuesta(android.view.View view);
        void updateSelecionado(int indice);
        void update(RespuestasObservableModel.RespuestasItem model);
        RespuestasObservableModel.RespuestasItem getModel();
    }
}
