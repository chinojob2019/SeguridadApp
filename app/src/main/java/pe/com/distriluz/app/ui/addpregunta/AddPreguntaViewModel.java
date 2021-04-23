package pe.com.distriluz.app.ui.addpregunta;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import com.miguelbcr.ui.rx_paparazzo2.RxPaparazzo;
import com.miguelbcr.ui.rx_paparazzo2.entities.FileData;
import com.miguelbcr.ui.rx_paparazzo2.entities.Response;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import pe.com.distriluz.app.ApplicationContext;
import pe.com.distriluz.app.injection.qualifier.AppContext;
import pe.com.distriluz.app.injection.scopes.PerActivity;
import pe.com.distriluz.app.ui.alerts.AlertLoadingDialog;
import pe.com.distriluz.app.ui.alerts.AlertSelectPhotoDialog;
import pe.com.distriluz.app.ui.base.BaseActivity;
import pe.com.distriluz.app.ui.base.navigator.Navigator;
import pe.com.distriluz.app.ui.base.viewmodel.BaseActivityViewModel;
import pe.com.distriluz.app.utils.Constantes;
import pe.com.distriluz.data.utiles.Utils;
import pe.com.distriluz.domain.interactor.AddPreguntaUseCase;
import pe.com.distriluz.domain.interactor.SaveInfoUserUseCase;
import pe.com.distriluz.domain.interactor.baseinteractors.DefaultObserverObservable;

@PerActivity
public class AddPreguntaViewModel extends BaseActivityViewModel<AddPreguntaMvvm.View> implements AddPreguntaMvvm.ViewModel {

    AddPreguntaObservableModel model;
    private AddPreguntaUseCase addPreguntaUseCase;
    private AlertLoadingDialog dialog;

    @Inject
    public AddPreguntaViewModel(@AppContext Context appContext, Navigator navigator, AddPreguntaUseCase saveInfoUserUseCase) {
        super(appContext, navigator);
        this.model = new AddPreguntaObservableModel(
             "","",1);
        this.addPreguntaUseCase  = saveInfoUserUseCase;
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
        if(validateSendinfo()){
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
            }, AddPreguntaUseCase.Params.datos(model.getDescripcion(), Integer.parseInt(model.getOrden()),model.getIdEstado()));
        }
    }


    private boolean validateSendinfo() {
        String vacio = "";

        return (!model.getDescripcion().equals(vacio) && !model.equals(vacio));
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

