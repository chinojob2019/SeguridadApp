package pe.com.distriluz.app.ui.addrepuesta;

import android.app.Activity;
import android.content.Context;
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
import pe.com.distriluz.domain.interactor.AddPreguntaUseCase;
import pe.com.distriluz.domain.interactor.AddRespuestaUseCase;

@PerActivity
public class AddRespuestaViewModel extends BaseActivityViewModel<AddRespuestaMvvm.View> implements AddRespuestaMvvm.ViewModel {

    AddRespuestaObservableModel model;
    private AddRespuestaUseCase addRespuestaUseCase;
    private AlertLoadingDialog dialog;
private int maximoOrden=0;
private String pregunta="";
private int idpregunta=0;
    @Inject
    public AddRespuestaViewModel(@AppContext Context appContext, Navigator navigator, AddRespuestaUseCase saveInfoUserUseCase) {
        super(appContext, navigator);

        this.maximoOrden = navigator.getIntent().getIntExtra(Navigator.EXTRA_ORDEN_ARG,1);
this.pregunta = navigator.getIntent().getStringExtra(Navigator.EXTRA_DESCRIPCION_ARG);
this.idpregunta =navigator.getIntent().getIntExtra(Navigator.EXTRA_IDPREGUNTA_ARG,1);


        this.model = new AddRespuestaObservableModel(
                "", String.valueOf(maximoOrden), 1, true, "",idpregunta,pregunta);
        this.addRespuestaUseCase = saveInfoUserUseCase;
    }

    @Override
    public AddRespuestaObservableModel getModel() {
        return model;
    }


    @Override
    public void detachView() {
        addRespuestaUseCase.dispose();
        super.detachView();
    }

    @Override
    public void onClickGuardar(View view) {
        if (validateSendinfo()) {
            showLoading();
            this.addRespuestaUseCase.execute(new DisposableSingleObserver<Boolean>() {
                @Override
                public void onSuccess(Boolean aBoolean) {
                    hideLoading();
                    toast("Tus cambios se han guardado.");
                    navigator.setResult(Activity.RESULT_OK, null);
                    navigator.finishActivity();
                }

                @Override
                public void onError(Throwable e) {
                    hideLoading();
                    validateErrorToken(e);
                    showError(e);

                }
            }, AddRespuestaUseCase.Params.datos(model.getDescripcion(), Integer.parseInt(model.getOrden()), model.getIdEstado(), model.getIdpregunta()));
        }
    }

    @Override
    public void rememberMeChanged(CompoundButton buttonView, Boolean isChecked) {
        if (isChecked) {
            model.setIdEstado(1);
            //model.setRememberMe(true);
        } else {
            model.setIdEstado(0);
            // model.setRememberMe(false);
        }
        Log.d("Logeando", String.valueOf(isChecked));

    }


    private boolean validateSendinfo() {
        String vacio = "";
        boolean resultado = true;
        if (!model.getDescripcion().equals(vacio) && !model.getOrden().equals(vacio)) {
            resultado = true;
        } else {
            resultado = false;
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
        if (dialog == null) {
            dialog = new AlertLoadingDialog();
            navigator.startDialog(dialog);
        }
    }

    @Override
    protected void hideLoading() {
        if (dialog != null) {
            dialog.dismissAllowingStateLoss();
            dialog = null;
        }
    }
}

