package pe.com.distriluz.app.ui.editprofile;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

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
import pe.com.distriluz.domain.interactor.GetParametrosUseCase;
import pe.com.distriluz.domain.interactor.SaveInfoUserUseCase;
import pe.com.distriluz.domain.interactor.baseinteractors.DefaultObserverObservable;
import pe.com.distriluz.domain.interactor.baseinteractors.DefaultObserverSingle;
import pe.com.distriluz.domain.model.Apps;
import pe.com.distriluz.domain.model.Parametros;

@PerActivity
public class EditProfileViewModel extends BaseActivityViewModel<EditProfileMvvm.View> implements EditProfileMvvm.ViewModel {

    EditProfileObservableModel model;
    private SaveInfoUserUseCase saveInfoUserUseCase;
    private GetParametrosUseCase getParametrosUseCase;
    private AlertLoadingDialog dialog;

    @Inject
    public EditProfileViewModel(@AppContext Context appContext, Navigator navigator, SaveInfoUserUseCase saveInfoUserUseCase, GetParametrosUseCase getParametrosUseCase) {
        super(appContext, navigator);
        this.model = new EditProfileObservableModel(
                Utils.getInfo(ApplicationContext.getInstance()).getPersonales().getDireccion(),
                Utils.getInfo(ApplicationContext.getInstance()).getPersonales().getTelefono(),
                Utils.getInfo(ApplicationContext.getInstance()).getPersonales().getFoto(),
                Utils.getInfo(ApplicationContext.getInstance()).getPersonales().getEmail());
        this.saveInfoUserUseCase = saveInfoUserUseCase;
        this.getParametrosUseCase = getParametrosUseCase;




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
    public void attachView(EditProfileMvvm.View mvvmView, @Nullable Bundle savedInstanceState) {
        getParametrosUseCase.execute(new DefaultObserverSingle<Parametros>() {
            @Override
            public void onSuccess(Parametros parametros) {


                int maxSizeKB = 150;
                String tipoDato = "";
                for (Parametros.ParametrosItem item : parametros.getParametros()) {
                    if (item.getLlave().equals("FotoTamanioMaximoKB")) {
                        maxSizeKB = Integer.parseInt(item.getValor().toString().trim());
                    }
                    if (item.getLlave().equals("FotoTipoImagen")) {
                        tipoDato = item.getValor().trim();
                    }
                }
                Utils.setTamanioFoto(con, maxSizeKB);
                Utils.setTipoImagen(con, tipoDato);
            }

            @Override
            public void onError(Throwable e) {
                hideLoading();
                //     if(!validateErrorToken(e)){
                e.printStackTrace();
                showError(e);
                //    }

            }
        }, null);

        super.attachView(mvvmView, savedInstanceState);
    }

    @Override
    public void onClickGuardar(View view) {

        if (validarParametros()) {
            if (validateSendinfo()) {
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
                        if (!validateErrorToken(e)) {
                            showError(e);

                        }

                    }
                }, SaveInfoUserUseCase.Params.datos(getDireccion(), getTelefono(), getPhoto(), getEmail()));
            }
        } else {
            toast("Error al adjuntar imagen. El tamaño no puede exceder a " + Utils.get_Tamaniofoto(con) + " KB y debe ser de tipo " + Utils.getTipoImagen(con) + ", intente nuevamente ");


        }
    }

    private String getDireccion() {
        if (model.getDireccion().equals(Utils.getInfo(ApplicationContext.getInstance()).getPersonales().getDireccion())) {
            return "";
        }
        return model.getDireccion();
    }

    private String getEmail() {
        if (model.getEmail().equals(Utils.getInfo(ApplicationContext.getInstance()).getPersonales().getEmail())) {
            return "";
        }
        return model.getEmail();
    }

    private String getTelefono() {
        if (model.getTelefono().equals(Utils.getInfo(ApplicationContext.getInstance()).getPersonales().getTelefono())) {
            return "";
        }
        return model.getTelefono();
    }

    private String getPhoto() {
        if (model.getNewFoto() == null) {
            return "";
        }
        return Utils.toBase64(model.getNewFoto().getAbsolutePath());
    }

    private boolean validateSendinfo() {
        String vacio = "";

        return (!model.getDireccion().equals(Utils.getInfo(ApplicationContext.getInstance()).getPersonales().getDireccion()) ||
                !model.getTelefono().equals(Utils.getInfo(ApplicationContext.getInstance()).getPersonales().getTelefono()) ||
                !model.getEmail().equals(Utils.getInfo(ApplicationContext.getInstance()).getPersonales().getEmail()) ||
                model.getNewFoto() != null) &&
                (!model.getDireccion().equals(vacio) &&
                        !model.getTelefono().equals(vacio) &&
                        !model.getEmail().equals(vacio) &&
                        model.getEmail().matches(Constantes.EMAIL_PATTERN));
    }


    private boolean validarParametros() {
        boolean resultado = true;
        if (model.getNewFoto() != null) {
            double valor = (model.getNewFoto().length()) / 1024.0;
            if (valor > Utils.get_Tamaniofoto(con)) {
                resultado = false;
            }
            String cadena = "";
            cadena = Utils.getTipoImagen(con);
            String[] tipos = cadena.split(",");

            boolean incluido = false;
            for (String item : tipos) {
                if (item.trim().equals(model.getMimetype().trim())) {
                    incluido = true;
                }
            }
            if (!incluido) {
                resultado = false;
            }
        }
        return resultado;
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
                                model.setMimetype(response.data().getMimeType());
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
                                model.setMimetype(response.data().getMimeType());
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

