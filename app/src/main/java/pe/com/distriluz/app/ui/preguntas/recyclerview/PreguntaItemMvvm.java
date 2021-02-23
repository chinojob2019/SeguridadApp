package pe.com.distriluz.app.ui.preguntas.recyclerview;


import pe.com.distriluz.app.ui.base.view.MvvmView;
import pe.com.distriluz.app.ui.base.viewmodel.IViewModel;
import pe.com.distriluz.app.ui.preguntas.PreguntasObservableModel;


public interface PreguntaItemMvvm {

    interface View extends MvvmView {
    }

    interface ViewModel extends IViewModel<View> {

        void onClickItem(android.view.View v);

        void update(PreguntasObservableModel.PreguntasfrecuentesObservable model);
        PreguntasObservableModel.PreguntasfrecuentesObservable getModel();
    }
}
