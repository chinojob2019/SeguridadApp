package pe.com.distriluz.data.net.auth;


import android.content.Context;

import com.google.gson.Gson;

import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import pe.com.distriluz.data.exception.ErrorException;
import pe.com.distriluz.data.exception.NetworkConnectionException;
import pe.com.distriluz.data.exception.TokenException;
import pe.com.distriluz.data.net.BaseNet;
import pe.com.distriluz.data.net.BaseRestApiImpl;
import pe.com.distriluz.data.net.auth.model.EditProfileRequest;
import pe.com.distriluz.data.net.auth.model.LoginRequest;
import pe.com.distriluz.data.net.auth.model.BasicBodyRequest;
import pe.com.distriluz.data.net.model.ErrorResponse;
import pe.com.distriluz.data.utiles.Constantes;
import pe.com.distriluz.data.utiles.Utils;


@Singleton
public class AuthRestApiImpl extends BaseRestApiImpl {

    @Inject
    public AuthRestApiImpl(Context context) {
        super(context);
    }

    public Single<Boolean> login(String username, String pass, boolean session) {
        return Single.create(emitter -> {
            if (isThereInternetConnection()) {
                try{
                    CompositeDisposable disposable = new CompositeDisposable();
                    AuthRestApi restApi = new BaseNet().createLogin(AuthRestApi.class);
                    disposable.add(restApi.login(new LoginRequest(username,pass)).subscribe(
                            serverResponse -> {
                                if (serverResponse != null) {
                                    if(serverResponse.isSuccessful() && serverResponse.body()!=null){
                                        Utils.saveSession(context,serverResponse.body(),username, pass,session, serverResponse.headers().get("Authorization"));
                                        emitter.onSuccess(true);
                                    }else{
                                        ErrorResponse response =new Gson().fromJson(serverResponse.errorBody().charStream(), ErrorResponse.class);
                                        emitter.onError(new ErrorException(response.getError().getMensaje()));
                                    }
                                } else {
                                    emitter.onError(new ErrorException("Datos Nulos"));
                                }
                            }
                            , error -> {
                                if(error instanceof SocketTimeoutException){
                                    emitter.onError(new NetworkConnectionException());
                                }else{

                                    emitter.onError(error);
                                }
                            }
                    ));
                }catch (Exception e){
                    e.printStackTrace();
                }
            } else {
                emitter.onError(new NetworkConnectionException());
            }
        });
    }
    public Single<Boolean> getDetailUser() {
        return Single.create(emitter -> {
            if (isThereInternetConnection()) {
                CompositeDisposable disposable = new CompositeDisposable();
                AuthRestApi restApi = new BaseNet().create(Constantes.HOST_API_D4,AuthRestApi.class, getToken(), this.context);
                disposable.add(restApi.getDetailUser().subscribe(
                        serverResponse -> {
                            if (serverResponse != null) {
                                if(serverResponse.isSuccessful() && serverResponse.body()!=null){
                                    Utils.saveInfo(context, serverResponse.body());
                                    emitter.onSuccess(true);
                                }else{
                                    ErrorResponse response =new Gson().fromJson(serverResponse.errorBody().charStream(), ErrorResponse.class);
                                    int code = serverResponse.code();
                                    if(code == Constantes.TYPE_ERROR_CODE_TOKEN){
                                        emitter.onError(new TokenException(response.getError().getTitulo()));
                                    }else {
                                        emitter.onError(new ErrorException(response.getError().getMensaje()));
                                    }
                                }
                            } else {
                                emitter.onError(new ErrorException("Datos Nulos"));
                            }
                        }
                        , error -> {
                            if(error instanceof SocketTimeoutException){
                                emitter.onError(new NetworkConnectionException());
                            }else{

                                emitter.onError(error);
                            }
                        }
                ));
            } else {
                emitter.onError(new NetworkConnectionException());
            }
        });
    }

    public Single<Boolean> sendMailForgotPass(String email) {
        return Single.create(emitter -> {
            if (isThereInternetConnection()) {
                CompositeDisposable disposable = new CompositeDisposable();
                AuthRestApi restApi = new BaseNet().createLogin(AuthRestApi.class);
                disposable.add(restApi.sendMailForgotPass(new BasicBodyRequest("Email",email)).subscribe(
                        serverResponse -> {
                            if (serverResponse != null) {
                                if(serverResponse.isSuccessful()){
                                    emitter.onSuccess(true);
                                }else{
                                    ErrorResponse response =new Gson().fromJson(serverResponse.errorBody().charStream(), ErrorResponse.class);
                                    emitter.onError(new ErrorException(response.getError().getMensaje()));
                                }
                            } else {
                                emitter.onError(new ErrorException("Datos Nulos"));
                            }
                        }
                        , error -> {
                            if(error instanceof SocketTimeoutException){
                                emitter.onError(new NetworkConnectionException());
                            }else{

                                emitter.onError(error);
                            }
                        }
                ));
            } else {
                emitter.onError(new NetworkConnectionException());
            }
        });
    }


    public Single<Boolean> verificaCodigo(String idUser, String codigo) {
        return Single.create(emitter -> {
            if (isThereInternetConnection()) {
                CompositeDisposable disposable = new CompositeDisposable();
                AuthRestApi restApi = new BaseNet().createLogin(AuthRestApi.class);
                disposable.add(restApi.verificaCodigo(idUser ,codigo).subscribe(
                        serverResponse -> {
                            if (serverResponse != null) {
                                if(serverResponse.isSuccessful()){
                                    emitter.onSuccess(true);
                                }else{
                                    ErrorResponse response =new Gson().fromJson(serverResponse.errorBody().charStream(), ErrorResponse.class);
                                    emitter.onError(new ErrorException(response.getError().getMensaje()));
                                }
                            } else {
                                emitter.onError(new ErrorException("Datos Nulos"));
                            }
                        }
                        , error -> {
                            if(error instanceof SocketTimeoutException){
                                emitter.onError(new NetworkConnectionException());
                            }else{

                                emitter.onError(error);
                            }
                        }
                ));
            } else {
                emitter.onError(new NetworkConnectionException());
            }
        });
    }

    public Single<Boolean> restablecePass(String idUser, String clave) {
        return Single.create(emitter -> {
            if (isThereInternetConnection()) {
                CompositeDisposable disposable = new CompositeDisposable();
                AuthRestApi restApi = new BaseNet().createLogin(AuthRestApi.class);
                disposable.add(restApi.restablecePass(idUser ,new BasicBodyRequest("Clave", clave)).subscribe(
                        serverResponse -> {
                            if (serverResponse != null) {
                                if(serverResponse.isSuccessful()){
                                    emitter.onSuccess(true);
                                }else{
                                    ErrorResponse response =new Gson().fromJson(serverResponse.errorBody().charStream(), ErrorResponse.class);
                                    emitter.onError(new ErrorException(response.getError().getMensaje()));
                                }
                            } else {
                                emitter.onError(new ErrorException("Datos Nulos"));
                            }
                        }
                        , error -> {
                            if(error instanceof SocketTimeoutException){
                                emitter.onError(new NetworkConnectionException());
                            }else{

                                emitter.onError(error);
                            }
                        }
                ));
            } else {
                emitter.onError(new NetworkConnectionException());
            }
        });
    }

    public Single<Boolean> saveDataInfo(String direccion, String telefono) {
        if(direccion.isEmpty())
            direccion = Utils.getInfo(context).getPersonales().getDireccion();
        if(telefono.isEmpty())
            telefono = Utils.getInfo(context).getPersonales().getTelefono();

        String finalDireccion = direccion;
        String finalTelefono = telefono;
        return Single.create(emitter -> {
            if (isThereInternetConnection()) {
                CompositeDisposable disposable = new CompositeDisposable();
                AuthRestApi restApi = new BaseNet().create(Constantes.HOST_API_D4,AuthRestApi.class, getToken(), this.context);
                List<EditProfileRequest> data = new ArrayList<>();
                data.add(new EditProfileRequest("Direccion", finalDireccion));
                data.add(new EditProfileRequest("Telefono", finalTelefono));
                disposable.add(restApi.saveDataInfo(Utils.getIdPerson(context), data ).subscribe(
                        serverResponse -> {
                            if (serverResponse != null) {
                                if(serverResponse.isSuccessful()){
                                    emitter.onSuccess(true);
                                }else{
                                    ErrorResponse response =new Gson().fromJson(serverResponse.errorBody().charStream(), ErrorResponse.class);
                                    int code = serverResponse.code();
                                    if(code == Constantes.TYPE_ERROR_CODE_TOKEN){
                                        emitter.onError(new TokenException(response.getError().getTitulo()));
                                    }else {
                                        emitter.onError(new ErrorException(response.getError().getMensaje()));
                                    }
                                }
                            } else {
                                emitter.onError(new ErrorException("Datos Nulos"));
                            }
                        }
                        , error -> {
                            if(error instanceof SocketTimeoutException){
                                emitter.onError(new NetworkConnectionException());
                            }else{

                                emitter.onError(error);
                            }
                        }
                ));
            } else {
                emitter.onError(new NetworkConnectionException());
            }
        });
    }

    public Single<Boolean> savePhoto(String base64) {
        return Single.create(emitter -> {
            if (isThereInternetConnection()) {
                CompositeDisposable disposable = new CompositeDisposable();
                AuthRestApi restApi = new BaseNet().create(Constantes.HOST_API_D4,AuthRestApi.class, getToken(), this.context);
                disposable.add(restApi.savePhoto(Utils.getIdPerson(context), new EditProfileRequest("Foto",base64) ).subscribe(
                        serverResponse -> {
                            if (serverResponse != null) {
                                if(serverResponse.isSuccessful()){
                                    emitter.onSuccess(true);
                                }else{
                                    ErrorResponse response =new Gson().fromJson(serverResponse.errorBody().charStream(), ErrorResponse.class);
                                    int code = serverResponse.code();
                                    if(code == Constantes.TYPE_ERROR_CODE_TOKEN){
                                        emitter.onError(new TokenException(response.getError().getTitulo()));
                                    }else {
                                        emitter.onError(new ErrorException(response.getError().getMensaje()));
                                    }
                                }
                            } else {
                                emitter.onError(new ErrorException("Datos Nulos"));
                            }
                        }
                        , error -> {
                            if(error instanceof SocketTimeoutException){
                                emitter.onError(new NetworkConnectionException());
                            }else{

                                emitter.onError(error);
                            }
                        }
                ));
            } else {
                emitter.onError(new NetworkConnectionException());
            }
        });
    }

}