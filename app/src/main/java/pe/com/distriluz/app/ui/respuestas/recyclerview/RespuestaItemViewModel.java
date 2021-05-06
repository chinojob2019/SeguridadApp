package pe.com.distriluz.app.ui.respuestas.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.CompoundButton;

import javax.inject.Inject;

import pe.com.distriluz.app.injection.qualifier.AppContext;
import pe.com.distriluz.app.injection.scopes.PerViewHolder;
import pe.com.distriluz.app.ui.base.navigator.Navigator;
import pe.com.distriluz.app.ui.base.viewmodel.BaseViewHolderViewModel;
import pe.com.distriluz.app.ui.respuestas.RespuestasObservableModel;
import pe.com.distriluz.app.ui.respuestas.recyclerview.RespuestaItemMvvm;


@PerViewHolder
public class RespuestaItemViewModel extends BaseViewHolderViewModel<RespuestaItemMvvm.View> implements RespuestaItemMvvm.ViewModel {

    private RespuestasObservableModel.RespuestasItem model;

    @Inject
    public RespuestaItemViewModel(@AppContext Context context, Navigator navigator) {
        super(context, navigator);
    }

    @Override
    public void onClickItem(CompoundButton buttonView, boolean isChecked) {
        model.setSeleccionado(isChecked);

       // model.setOpen(!model.getOpen());
    }

    @Override
    public void onClickListarRespuesta(View view) {

    }

    @Override
    public void updateSelecionado(int indice) {
      //  model.setSeleccionado(true);
    }

    @Override
    public void update(RespuestasObservableModel.RespuestasItem model) {
        this.model=model;
        notifyChange();
    }

    @Override
    public void onClicUpdateRespuesta(View view) {

        getView().updateRespuesta(model);

    }


    @Override
    public RespuestasObservableModel.RespuestasItem getModel() {
        return model;
    }
}
