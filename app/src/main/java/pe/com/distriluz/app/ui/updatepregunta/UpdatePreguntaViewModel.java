package pe.com.distriluz.app.ui.updatepregunta;

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

import pe.com.distriluz.domain.interactor.UpdatePreguntaUseCase;

@PerActivity
public class UpdatePreguntaViewModel extends BaseActivityViewModel<UpdatePreguntaMvvm.View> implements UpdatePreguntaMvvm.ViewModel {

    UpdatePreguntaObservableModel model;
    private UpdatePreguntaUseCase updatePreguntaUseCase;
    private AlertLoadingDialog dialog;
private String descripcion;
private int idestado;
private int idpregunta;
private int orden;

    @Inject
    public UpdatePreguntaViewModel(@AppContext Context appContext, Navigator navigator, UpdatePreguntaUseCase saveInfoUserUseCase) {
        super(appContext, navigator);

        this.orden = navigator.getIntent().getIntExtra(Navigator.EXTRA_ORDEN_ARG,1);
        this.idestado = navigator.getIntent().getIntExtra(Navigator.EXTRA_IDESTADO_ARG,1);
        this.idpregunta = navigator.getIntent().getIntExtra(Navigator.EXTRA_IDPREGUNTA_ARG,1);
        this.descripcion = navigator.getIntent().getStringExtra(Navigator.EXTRA_DESCRIPCION_ARG);


        this.model = new UpdatePreguntaObservableModel(
             descripcion, String.valueOf(orden) ,idestado, idestado == 1,"", idpregunta);
        this.updatePreguntaUseCase  = saveInfoUserUseCase;

    }

    @Override
    public UpdatePreguntaObservableModel getModel() {
        return model;
    }


    @Override
    public void detachView() {
        updatePreguntaUseCase.dispose();
        super.detachView();
    }

    @Override
    public void onClickGuardar(View view) {
        if(validateSendinfo()){
            showLoading();
            this.updatePreguntaUseCase.execute(new DisposableSingleObserver<Boolean>() {
                @Override
                public void onSuccess(Boolean aBoolean) {
                    hideLoading();
                    toast("Tus cambios se han guardado.");
                    Intent resultIntent = new Intent();

                    resultIntent.putExtra("pregunta", model.getDescripcion());
                    navigator.setResult(Activity.RESULT_OK, resultIntent);
                    navigator.finishActivity();
                }

                @Override
                public void onError(Throwable e) {
                    hideLoading();



                    if( !validateErrorToken(e))
                    {
                        e.printStackTrace();
                        showError(e);

                    }


                }
            }, UpdatePreguntaUseCase.Params.datos(model.getIdPregunta(),model.getDescripcion(), Integer.parseInt(model.getOrden()),model.getIdEstado()));
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
        if( !model.getDescripcion().equals(vacio) && !model.getOrden().equals(vacio)){
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
        super.hideLoading();
        if(dialog!=null) {
            dialog.dismissAllowingStateLoss();
            dialog=null;
        }
    }
}

