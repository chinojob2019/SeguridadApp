package pe.com.distriluz.app.ui.restorepassword;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;

import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;

import javax.inject.Inject;

import pe.com.distriluz.app.injection.qualifier.AppContext;
import pe.com.distriluz.app.injection.scopes.PerActivity;
import pe.com.distriluz.app.ui.base.navigator.Navigator;
import pe.com.distriluz.app.ui.base.viewmodel.BaseActivityViewModel;
import pe.com.distriluz.app.ui.okrestorepass.OkRestorePassActivity;
import pe.com.distriluz.domain.interactor.RestablecePassUseCase;
import pe.com.distriluz.domain.interactor.baseinteractors.DefaultObserverSingle;

@PerActivity
public class RestorePasswordViewModel extends BaseActivityViewModel<RestorePasswordMvvm.View> implements RestorePasswordMvvm.ViewModel {
    private RestablecePassUseCase  restablecePassUseCase;
    private Resources resources;
    private RestorePasswordObservableModel model = new RestorePasswordObservableModel("");
    private String idUser = "";

    // TODO falta crear obserbale string
    @Inject
    public RestorePasswordViewModel(@AppContext Context appContext, Navigator navigator,
                                    Resources resources,
                                    RestablecePassUseCase restablecePassUseCase) {
        super(appContext, navigator);
        this.resources=resources;
        this.restablecePassUseCase=restablecePassUseCase;
        this.idUser = navigator.getIntent().getStringExtra(Navigator.EXTRA_ARG);
    }

    @Override
    public void detachView() {
        restablecePassUseCase.dispose();
        super.detachView();
    }

    @Override
    public RestorePasswordObservableModel getModel() {
        return model;
    }

    @Override
    public void onClickEnviarPass(View v) {
        showLoading();
        navigator.getActivity().hideKeyboard();
        restablecePassUseCase.execute(new DefaultObserverSingle<Boolean>(){
            @Override
            public void onError(Throwable e) {
                hideLoading();
                Log.e("onClickEnviarPass", "onError: ",e );
                showError(e);
            }

            @Override
            public void onSuccess(Boolean aBoolean) {
                hideLoading();
                toast("Contraseña restablecida correctamente");
                navigator.startActivity(OkRestorePassActivity.class);
                navigator.finishActivity();
            }
        }, RestablecePassUseCase.Params.datos(this.idUser,model.getPass()));

    }


}

