package pe.com.distriluz.app.ui.preguntas.recyclerview;


import android.widget.CompoundButton;

import pe.com.distriluz.app.ui.base.view.MvvmView;
import pe.com.distriluz.app.ui.base.viewmodel.IViewModel;
import pe.com.distriluz.app.ui.preguntas.PreguntasObservableModel;


public interface PreguntaItemMvvm {

    interface View extends MvvmView {
        void onclickListaRespuestas(PreguntasObservableModel.PreguntasfrecuentesObservable item);

    }

    interface ViewModel extends IViewModel<View> {

        void onClickItem(CompoundButton buttonView, boolean isChecked);
        void onClickListarRespuesta(android.view.View view);
        void updateSelecionado(int indice);
        void update(PreguntasObservableModel.PreguntasfrecuentesObservable model);
        PreguntasObservableModel.PreguntasfrecuentesObservable getModel();
    }
}
