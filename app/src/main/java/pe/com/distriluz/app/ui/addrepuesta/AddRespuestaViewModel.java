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
import pe.com.distriluz.app.ui.addpregunta.AddPreguntaMvvm;
import pe.com.distriluz.app.ui.addpregunta.AddPreguntaObservableModel;
import pe.com.distriluz.app.ui.alerts.AlertLoadingDialog;
import pe.com.distriluz.app.ui.base.navigator.Navigator;
import pe.com.distriluz.app.ui.base.viewmodel.BaseActivityViewModel;
import pe.com.distriluz.domain.interactor.AddPreguntaUseCase;

@PerActivity
public class AddRespuestaViewModel extends BaseActivityViewModel<AddPreguntaMvvm.View> implements AddPreguntaMvvm.ViewModel {

    AddPreguntaObservableModel model;
    private AddPreguntaUseCase addPreguntaUseCase;
    private AlertLoadingDialog dialog;

    @Inject
    public AddRespuestaViewModel(@AppContext Context appContext, Navigator navigator, AddPreguntaUseCase saveInfoUserUseCase) {
        super(appContext, navigator);
        this.model = new AddPreguntaObservableModel(
                "", "", 1, true, "");
        this.addPreguntaUseCase = saveInfoUserUseCase;
    }

    @Override
    public AddPreguntaObservableModel getModel() {
        return model;
    }


    @Override
    public void detachView() {
        addPreguntaUseCase.dispose();
        super.detachView();
    }

    @Override
    public void onClickGuardar(View view) {
        if (validateSendinfo()) {
            showLoading();
            this.addPreguntaUseCase.execute(new DisposableSingleObserver<Boolean>() {
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
            }, AddPreguntaUseCase.Params.datos(model.getDescripcion(), Integer.parseInt(model.getOrden()), model.getIdEstado()));
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

