package pe.com.distriluz.app.ui.changepassword;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;

import javax.inject.Inject;

import pe.com.distriluz.app.injection.qualifier.AppContext;
import pe.com.distriluz.app.injection.scopes.PerActivity;
import pe.com.distriluz.app.ui.base.navigator.Navigator;
import pe.com.distriluz.app.ui.base.viewmodel.BaseActivityViewModel;
import pe.com.distriluz.domain.interactor.ChangePasswordUseCase;
import pe.com.distriluz.domain.interactor.baseinteractors.DefaultObserverSingle;

@PerActivity
public class ChangePasswordViewModel extends BaseActivityViewModel<ChangePasswordMvvm.View> implements ChangePasswordMvvm.ViewModel {
    private ChangePasswordUseCase  changePasswordUseCase;
    private Resources resources;
    private ChangePasswordObservableModel model =  new ChangePasswordObservableModel("");
    // TODO falta crear obserbale string
    @Inject
    public ChangePasswordViewModel(@AppContext Context appContext, Navigator navigator,
                                   Resources resources,
                                   ChangePasswordUseCase changePasswordUseCase) {
        super(appContext, navigator);
        this.resources=resources;
        this.changePasswordUseCase=changePasswordUseCase;
    }

    @Override
    public void detachView() {
        changePasswordUseCase.dispose();
        super.detachView();
    }

    @Override
    public ChangePasswordObservableModel getModel() {
        return model;
    }

    @Override
    public void onClickEnviarEmail(View v) {
        navigator.getActivity().hideKeyboard();
        showLoading();
        changePasswordUseCase.execute(new DefaultObserverSingle<Boolean>(){
            @Override
            public void onError(Throwable e) {
                hideLoading();
                showError(e);
            }

            @Override
            public void onSuccess(Boolean aBoolean) {
                hideLoading();
                toast("Se Enviaran instrucciones a su correo");
                navigator.finishActivity();
            }
        }, ChangePasswordUseCase.Params.datos(getModel().getEmail()));

    }


}

