package pe.com.distriluz.app.ui.editprofile;

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
import pe.com.distriluz.data.utiles.Utils;
import pe.com.distriluz.domain.interactor.SaveInfoUserUseCase;
import pe.com.distriluz.domain.interactor.baseinteractors.DefaultObserverObservable;

@PerActivity
public class EditProfileViewModel extends BaseActivityViewModel<EditProfileMvvm.View> implements EditProfileMvvm.ViewModel {

    EditProfileObservableModel model;
    private SaveInfoUserUseCase saveInfoUserUseCase;
    private AlertLoadingDialog dialog;

    @Inject
    public EditProfileViewModel(@AppContext Context appContext, Navigator navigator, SaveInfoUserUseCase saveInfoUserUseCase) {
        super(appContext, navigator);
        this.model = new EditProfileObservableModel(
                Utils.getInfo(ApplicationContext.getInstance()).getPersonales().getDireccion(),
                Utils.getInfo(ApplicationContext.getInstance()).getPersonales().getTelefono(),
                Utils.getInfo(ApplicationContext.getInstance()).getPersonales().getFoto()
        );
        this.saveInfoUserUseCase  = saveInfoUserUseCase;
    }

    @Override
    public EditProfileObservableModel getModel() {
        return model;
    }


    @Override
    public void detachView() {
        saveInfoUserUseCase.dispose();
        super.detachView();
    }

    @Override
    public void onClickGuardar(View view) {
        if(validateSendinfo()){
            showLoading();
            this.saveInfoUserUseCase.execute(new DisposableSingleObserver<Boolean>() {
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
            }, SaveInfoUserUseCase.Params.datos(getDireccion(), getTelefono(), getPhoto()));
        }
    }

    private String getDireccion() {
        if(model.getDireccion().equals(Utils.getInfo(ApplicationContext.getInstance()).getPersonales().getDireccion())) {
            return "";
        }
        return model.getDireccion();
    }

    private String getTelefono() {
        if(model.getTelefono().equals(Utils.getInfo(ApplicationContext.getInstance()).getPersonales().getTelefono())) {
            return "";
        }
        return model.getTelefono();
    }

    private String getPhoto() {
        if(model.getNewFoto()  == null) {
            return "";
        }
        return Utils.toBase64(model.getNewFoto().getAbsolutePath());
    }

    private boolean validateSendinfo() {
        return !model.getDireccion().equals(Utils.getInfo(ApplicationContext.getInstance()).getPersonales().getDireccion()) ||
                !model.getTelefono().equals(Utils.getInfo(ApplicationContext.getInstance()).getPersonales().getTelefono()) ||
                model.getNewFoto()  != null;
    }

    @Override
    public void onClickClose(View view) {
        navigator.finishActivity();
    }

    @Override
    public void onClickChangePhoto(View view) {
        navigator.startDialog(new AlertSelectPhotoDialog(this));
    }

    @Override
    public void openGallery() {

        RxPaparazzo.single(navigator.getActivity())
                .usingGallery()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new DefaultObserverObservable<Response<BaseActivity, FileData>>() {

                            @Override
                            public void onNext(Response<BaseActivity, FileData> response) {
                                if (response.resultCode() != Activity.RESULT_OK) {
//                                    camaraCancel();
                                    return;
                                }
                                model.setNewFoto(response.data().getFile());
                            }

                            @Override
                            public void onError(Throwable e) {
                                showError(e);
                            }

                        });
    }

    @Override
    public void openCamera() {
        RxPaparazzo.single(navigator.getActivity())
                .usingCamera()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new DefaultObserverObservable<Response<BaseActivity, FileData>>() {

                            @Override
                            public void onNext(Response<BaseActivity, FileData> response) {
                                if (response.resultCode() != Activity.RESULT_OK) {
//                                    camaraCancel();
                                    return;
                                }
                                model.setNewFoto(response.data().getFile());
                            }

                            @Override
                            public void onError(Throwable e) {
                                showError(e);
                            }

                        });
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

