package pe.com.distriluz.app.ui.codeconfirm;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;

import javax.inject.Inject;

import pe.com.distriluz.app.injection.qualifier.AppContext;
import pe.com.distriluz.app.injection.scopes.PerActivity;
import pe.com.distriluz.app.ui.base.navigator.Navigator;
import pe.com.distriluz.app.ui.base.viewmodel.BaseActivityViewModel;
import pe.com.distriluz.data.utiles.Utils;
import pe.com.distriluz.domain.interactor.ChangePasswordUseCase;
import pe.com.distriluz.domain.interactor.baseinteractors.DefaultObserverSingle;

@PerActivity
public class CodeConfirmViewModel extends BaseActivityViewModel<CodeConfirmMvvm.View> implements CodeConfirmMvvm.ViewModel {
    private CodeConfirmMapper mapper;
    private ChangePasswordUseCase  changePasswordUseCase;
    private CodeConfirmObservableModel model;
    private Resources resources;


    @Inject
    public CodeConfirmViewModel(@AppContext Context appContext, Navigator navigator,
                                Resources resources, CodeConfirmMapper mapper,
                                ChangePasswordUseCase changePasswordUseCase) {
        super(appContext, navigator);
            this.model = new CodeConfirmObservableModel("");
        this.resources=resources;
        this.mapper=mapper;
        this.changePasswordUseCase=changePasswordUseCase;
    }

    @Override
    public void detachView() {
        changePasswordUseCase.dispose();
        super.detachView();
    }

    @Override
    public CodeConfirmObservableModel getModel() {
        return model;
    }

    @Override
    public void onClickEnviarEmail(View v) {
        getView().ocultarKeyboard();
        changePasswordUseCase.execute(new DefaultObserverSingle<Boolean>(){
            @Override
            public void onError(Throwable e) {
                hideLoading();
                Log.e("onClickIniciarSesion", "onError: ",e );
                showError(e);
            }

            @Override
            public void onSuccess(Boolean aBoolean) {
                hideLoading();
                toast("Bienvenido/a "+ Utils.getfirstname(con));
                //   navigator.startActivity(MapActivity.class);
                // navigator.finishActivity();
            }
        }, ChangePasswordUseCase.Params.datos(model.getEmail()));

    }


}

