package pe.com.distriluz.app.ui.preguntas.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.CompoundButton;

import javax.inject.Inject;

import pe.com.distriluz.app.injection.qualifier.AppContext;
import pe.com.distriluz.app.injection.scopes.PerViewHolder;
import pe.com.distriluz.app.ui.base.navigator.Navigator;
import pe.com.distriluz.app.ui.base.viewmodel.BaseViewHolderViewModel;
import pe.com.distriluz.app.ui.preguntas.PreguntasObservableModel;


@PerViewHolder
public class PreguntaItemViewModel extends BaseViewHolderViewModel<PreguntaItemMvvm.View> implements PreguntaItemMvvm.ViewModel {

    private PreguntasObservableModel.PreguntasfrecuentesObservable model;

    @Inject
    public PreguntaItemViewModel(@AppContext Context context, Navigator navigator) {
        super(context, navigator);
    }

    @Override
    public void onClickItem(CompoundButton buttonView, boolean isChecked) {
        model.setSeleccionado(isChecked);

       // model.setOpen(!model.getOpen());
    }

    @Override
    public void onClickListarRespuesta(View view) {
        getView().onclickListaRespuestas(model);

    }

    @Override
    public void updateSelecionado(int indice) {
      //  model.setSeleccionado(true);
    }

    @Override
    public void update(PreguntasObservableModel.PreguntasfrecuentesObservable model) {
        this.model=model;
        notifyChange();
    }

    @Override
    public PreguntasObservableModel.PreguntasfrecuentesObservable getModel() {
        return model;
    }
}
