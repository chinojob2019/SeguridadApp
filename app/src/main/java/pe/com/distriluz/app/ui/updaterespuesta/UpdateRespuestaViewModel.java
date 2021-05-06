package pe.com.distriluz.app.ui.updaterespuesta;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;

import javax.inject.Inject;

import io.reactivex.observers.DisposableSingleObserver;
import pe.com.distriluz.app.injection.qualifier.AppContext;
import pe.com.distriluz.app.injection.scopes.PerActivity;
import pe.com.distriluz.app.ui.alerts.AlertLoadingDialog;
import pe.com.distriluz.app.ui.base.navigator.Navigator;
import pe.com.distriluz.app.ui.base.viewmodel.BaseActivityViewModel;
import pe.com.distriluz.domain.interactor.UpdateRespuestaUseCase;

@PerActivity
public class UpdateRespuestaViewModel extends BaseActivityViewModel<UpdateRespuestaMvvm.View> implements UpdateRespuestaMvvm.ViewModel {

    UpdateRespuestaObservableModel model;
    private UpdateRespuestaUseCase updateRespuestaUseCase;
    private AlertLoadingDialog dialog;
private String respuesta;
private String pregunta;
private int idestado;
private int idRespuesta;
private int idPregunta;
private int orden;

    @Inject
    public UpdateRespuestaViewModel(@AppContext Context appContext, Navigator navigator, UpdateRespuestaUseCase saveInfoUserUseCase) {
        super(appContext, navigator);

        this.orden = navigator.getIntent().getIntExtra(Navigator.EXTRA_ORDEN_ARG,1);
        this.idestado = navigator.getIntent().getIntExtra(Navigator.EXTRA_IDESTADO_ARG,1);
        this.idRespuesta = navigator.getIntent().getIntExtra(Navigator.EXTRA_IDRESPUESTA_ARG,1);
        this.idPregunta = navigator.getIntent().getIntExtra(Navigator.EXTRA_IDPREGUNTA_ARG,1);
        this.respuesta = navigator.getIntent().getStringExtra(Navigator.EXTRA_DESCRIPCION_ARG);
        this.pregunta = navigator.getIntent().getStringExtra(Navigator.EXTRA_PREGUNTA_ARG);



        this.model = new UpdateRespuestaObservableModel(
             respuesta,pregunta, String.valueOf(orden) ,idestado, idestado == 1,"", idRespuesta,idPregunta);
        this.updateRespuestaUseCase  = saveInfoUserUseCase;

    }

    @Override
    public UpdateRespuestaObservableModel getModel() {
        return model;
    }


    @Override
    public void detachView() {
        updateRespuestaUseCase.dispose();
        super.detachView();
    }

    @Override
    public void onClickGuardar(View view) {
        if(validateSendinfo()){
            showLoading();
            this.updateRespuestaUseCase.execute(new DisposableSingleObserver<Boolean>() {
                @Override
                public void onSuccess(Boolean aBoolean) {
                    hideLoading();
                    toast("Tus cambios se han guardado.");
                    Intent resultIntent = new Intent();

                //    resultIntent.putExtra("Respuesta", model.getDescripcion());
                    navigator.setResult(Activity.RESULT_OK, null);
                    navigator.finishActivity();
                }

                @Override
                public void onError(Throwable e) {
                    hideLoading();
                    validateErrorToken(e);
                    showError(e);

                }
            }, UpdateRespuestaUseCase.Params.datos( model.getRespuesta(), Integer.parseInt(model.getOrden()), model.getIdEstado(),model.getIdPregunta(),model.getIdRespuesta()));
        }
    }

    @Override
    public void rememberMeChanged(CompoundButton buttonView, Boolean isChecked) {
if(isChecked)
{
    model.setIdEstado(1);
    //model.setRememberMe(true);

}else
{
    model.setIdEstado(0);
   // model.setRememberMe(false);
}



        Log.d("Logeando",  String.valueOf(isChecked));

    }


    private boolean validateSendinfo() {
        String vacio = "";
        boolean resultado=true;
        if( !model.getRespuesta().equals(vacio) && !model.getOrden().equals(vacio)){
            resultado=true;
        }else{
            resultado=false;
        toast("Ingresar Descripción y Orden");
        }

        return (resultado);
    }

    @Override
    public void onClickClose(View view) {
        navigator.finishActivity();
    }




    @Override
    protected void showLoading() {
        super.showLoading();
        if(dialog==null) {
            dialog = new AlertLoadingDialog();
            navigator.startDialog(dialog);
        }
    }

    @Override
    protected void hideLoading() {
        if(dialog!=null) {
            dialog.dismissAllowingStateLoss();
            dialog=null;
        }
    }
}

