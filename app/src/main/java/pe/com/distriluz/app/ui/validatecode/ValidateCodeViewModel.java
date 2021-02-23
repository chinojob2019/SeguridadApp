package pe.com.distriluz.app.ui.validatecode;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Base64;
import android.util.Log;
import android.view.View;

import java.io.UnsupportedEncodingException;

import javax.inject.Inject;

import io.reactivex.observers.DisposableSingleObserver;
import pe.com.distriluz.app.R;
import pe.com.distriluz.app.injection.qualifier.AppContext;
import pe.com.distriluz.app.injection.scopes.PerActivity;
import pe.com.distriluz.app.ui.base.navigator.Navigator;
import pe.com.distriluz.app.ui.base.viewmodel.BaseActivityViewModel;
import pe.com.distriluz.app.ui.restorepassword.RestorePasswordActivity;
import pe.com.distriluz.domain.interactor.VerificaCodigoUseCase;

@PerActivity
public class ValidateCodeViewModel extends BaseActivityViewModel<ValidateCodeMvvm.View> implements ValidateCodeMvvm.ViewModel {
    private VerificaCodigoUseCase  verificaCodigoUseCase;
    private Resources resources;
    private ValidateCodeObservableModel model;
    private String idUser = "";

    // TODO falta crear obserbale string
    @Inject
    public ValidateCodeViewModel(@AppContext Context appContext, Navigator navigator,
                                 Resources resources,
                                 VerificaCodigoUseCase verificaCodigoUseCase) {
        super(appContext, navigator);
        this.resources=resources;
        this.verificaCodigoUseCase=verificaCodigoUseCase;
        deepLink();
    }

    private void deepLink() {
        Uri appLinkData = navigator.getIntent().getData();
        if(appLinkData!= null){
            String idUser = appLinkData.getQueryParameter("q");
            if(idUser!= null && !idUser.isEmpty()){
                byte[] data = Base64.decode(idUser, Base64.DEFAULT);
                try {
                    this.idUser = new String(data, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    this.closeValidateCode();
                }
            }else{
                this.closeValidateCode();
            }
        }
    }

    private void closeValidateCode() {
        toast("No se adjunta datos correctos");
        navigator.finishActivity();
    }

    @Override
    public void detachView() {
        verificaCodigoUseCase.dispose();
        super.detachView();
    }

    @Override
    public void onClickSendCode(View v) {
        if(!getView().getCode().isEmpty() && getView().getCode().length() == 4 ){
            navigator.hideKeyboard();
            showLoading();
            verificaCodigoUseCase.execute(new DisposableSingleObserver<Boolean>() {
                @Override
                public void onSuccess(Boolean aBoolean) {
                    hideLoading();
                    navigator.startActivity(RestorePasswordActivity.class,idUser);
                    navigator.finishActivity();
                }

                @Override
                public void onError(Throwable e) {
                    hideLoading();
                    Log.e("onClickSendCode", "onError: ",e );
                    getView().clearText();
                    showError( e);
                }
            }, VerificaCodigoUseCase.Params.datos(idUser,getView().getCode()));
        }
    }

    @Override
    public void onClickOpenKeyBoard(View v) {
        navigator.showKeyboard();
    }


}

