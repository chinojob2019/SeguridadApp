package pe.com.distriluz.app.ui.preguntaslectura.recyclerview;

import android.content.Context;
import android.view.View;

import javax.inject.Inject;

import pe.com.distriluz.app.injection.qualifier.AppContext;
import pe.com.distriluz.app.injection.scopes.PerViewHolder;
import pe.com.distriluz.app.ui.base.navigator.Navigator;
import pe.com.distriluz.app.ui.base.viewmodel.BaseViewHolderViewModel;
import pe.com.distriluz.app.ui.preguntaslectura.PreguntasLecturaObservableModel;


@PerViewHolder
public class PreguntaLecturaItemViewModel extends BaseViewHolderViewModel<PreguntaLecturaItemMvvm.View> implements PreguntaLecturaItemMvvm.ViewModel {

    private PreguntasLecturaObservableModel.PreguntasfrecuentesObservable model;

    @Inject
    public PreguntaLecturaItemViewModel(@AppContext Context context, Navigator navigator) {
        super(context, navigator);
    }

    @Override
    public void onClickItem(View v) {
        model.setOpen(!model.getOpen());
    }

    @Override
    public void update(PreguntasLecturaObservableModel.PreguntasfrecuentesObservable model) {
        this.model=model;
        notifyChange();
    }

    @Override
    public PreguntasLecturaObservableModel.PreguntasfrecuentesObservable getModel() {
        return model;
    }
}
