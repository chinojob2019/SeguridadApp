package pe.com.distriluz.app.ui.preguntaslectura.recyclerview;


import pe.com.distriluz.app.ui.base.view.MvvmView;
import pe.com.distriluz.app.ui.base.viewmodel.IViewModel;
import pe.com.distriluz.app.ui.preguntaslectura.PreguntasLecturaObservableModel;


public interface PreguntaLecturaItemMvvm {

    interface View extends MvvmView {
    }

    interface ViewModel extends IViewModel<View> {

        void onClickItem(android.view.View v);

        void update(PreguntasLecturaObservableModel.PreguntasfrecuentesObservable model);
        PreguntasLecturaObservableModel.PreguntasfrecuentesObservable getModel();
    }
}
