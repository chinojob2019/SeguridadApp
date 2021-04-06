package pe.com.distriluz.app.ui.login;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import javax.inject.Inject;

import pe.com.distriluz.app.BuildConfig;
import pe.com.distriluz.app.injection.qualifier.AppContext;
import pe.com.distriluz.app.injection.scopes.PerActivity;
import pe.com.distriluz.app.ui.base.navigator.Navigator;
import pe.com.distriluz.app.ui.base.viewmodel.BaseActivityViewModel;
import pe.com.distriluz.app.ui.changepassword.ChangePasswordActivity;
import pe.com.distriluz.app.ui.clientelistar.ClienteListarActivity;
import pe.com.distriluz.data.exception.NetworkConnectionException;
import pe.com.distriluz.data.utiles.Utils;
import pe.com.distriluz.domain.interactor.LoginUseCase;
import pe.com.distriluz.domain.interactor.baseinteractors.DefaultObserverSingle;

@PerActivity
public class LoginViewModel extends BaseActivityViewModel<LoginMvvm.View> implements LoginMvvm.ViewModel {
    private LoginMapper mapper;
    private LoginUseCase loginUseCase;
    private LoginObservableModel model;
    private Resources resources;

    // TODO falta crear obserbale string
    @Inject
    public LoginViewModel(@AppContext Context appContext, Navigator navigator,
                          Resources resources, LoginMapper mapper,
                          LoginUseCase loginUseCase) {
        super(appContext, navigator);
        this.resources=resources;
        this.mapper=mapper;
        this.loginUseCase=loginUseCase;
        if(BuildConfig.DEBUG){
            this.model = new LoginObservableModel("@dministr4dOr2", "rmorales");
//            onClickIniciarSesion(null);
        }else {
            this.model = new LoginObservableModel("", "");
        }
    }

    @Override
    public void attachView(LoginMvvm.View mvvmView, @Nullable Bundle savedInstanceState) {
        validateSession();
        super.attachView(mvvmView, savedInstanceState);
    }

    private void validateSession() {
        if(  navigator.isLoggin()) {
            navigator.startActivity(ClienteListarActivity.class);
            navigator.finishActivity();
        }
    }

    @Override
    public void detachView() {
        loginUseCase.dispose();
        super.detachView();
    }

    @Override
    public LoginObservableModel getModel() {
        return model;
    }

    @Override
    public void onClickIniciarSesion(View v) {
        showLoading();
        navigator.getActivity().hideKeyboard();
        loginUseCase.execute(new DefaultObserverSingle<Boolean>(){
            @Override
            public void onError(Throwable e) {
                hideLoading();
                Log.e("onClickIniciarSesion", "onError: ",e );
                showError((e instanceof NetworkConnectionException) ? "¡Ocurrió un error!" :"¡Credenciales Incorrectas!",e.getMessage(), "Volver a intentar");
            }

            @Override
            public void onSuccess(Boolean aBoolean) {
//                hideLoading();
                toast("Bienvenido/a "+ Utils.getfirstname(con));
                navigator.startActivity(ClienteListarActivity.class);
                navigator.finishActivity();
//                hideLoading();
            }
        }, LoginUseCase.Params.datos(model.getUser(),model.getPass(),true));
    }

    @Override
    public void onClickForgotPassword(View v) {
       navigator.startActivity(ChangePasswordActivity.class);
    }

    @Override
    public void onClickShowList(View v) {

    }
}

