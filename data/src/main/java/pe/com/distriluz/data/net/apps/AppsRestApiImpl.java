package pe.com.distriluz.data.net.apps;


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
import pe.com.distriluz.data.net.apps.model.ActualizarPreguntaRequest;
import pe.com.distriluz.data.net.apps.model.ActualizarRespuestaRequest;
import pe.com.distriluz.data.net.apps.model.AppsResponse;
import pe.com.distriluz.data.net.apps.model.NuevaPreguntaRequest;
import pe.com.distriluz.data.net.apps.model.NuevaRespuestaRequest;
import pe.com.distriluz.data.net.apps.model.PreguntasResponse;
import pe.com.distriluz.data.net.auth.AuthRestApi;
import pe.com.distriluz.data.net.auth.model.EditProfileRequest;
import pe.com.distriluz.data.net.model.ErrorResponse;
import pe.com.distriluz.data.utiles.Constantes;
import pe.com.distriluz.data.utiles.Utils;
import retrofit2.http.Body;
import retrofit2.http.Query;


@Singleton
public class AppsRestApiImpl extends BaseRestApiImpl {

    @Inject
    public AppsRestApiImpl(Context context) {
        super(context);
    }

    public Single<AppsResponse> getApps() {
        return Single.create(emitter -> {
            if (isThereInternetConnection()) {
                try{
                    CompositeDisposable disposable = new CompositeDisposable();
                    AppsRestApi restApi = new BaseNet().create(Constantes.HOST_API_D4,AppsRestApi.class, getToken(), this.context);
                    disposable.add(restApi.getApps().subscribe(
                            serverResponse -> {
                                if (serverResponse != null) {
                                    if(serverResponse.isSuccessful() && serverResponse.body()!=null){
                                        emitter.onSuccess(serverResponse.body());
                                    }else{
                                        int code = serverResponse.code();
                                        ErrorResponse response =new Gson().fromJson(serverResponse.errorBody().charStream(), ErrorResponse.class);
                                        if(code == Constantes.TYPE_ERROR_CODE_TOKEN || response.getError().getCodigo().equals(Constantes.ERROR_CODE_TOKEN_EXPIRADO)){
                                            emitter.onError(new TokenException(code == Constantes.TYPE_ERROR_CODE_TOKEN ?response.getError().getTitulo(): response.getError().getMensaje()));
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
                }catch (Exception e){
                    e.printStackTrace();
                }
            } else {
                emitter.onError(new NetworkConnectionException());
            }
        });
    }

    public Single<Boolean> setDestacado(String idApp, String value) {
        return Single.create(emitter -> {
            if (isThereInternetConnection()) {
                CompositeDisposable disposable = new CompositeDisposable();
                AppsRestApi restApi = new BaseNet().create(Constantes.HOST_API_D4,AppsRestApi.class, getToken(), this.context);
                disposable.add(restApi.setDestacado(idApp, value).subscribe(
                        serverResponse -> {
                            if (serverResponse != null) {
                                if(serverResponse.isSuccessful()){
                                    emitter.onSuccess(true);
                                }else{
                                    ErrorResponse response =new Gson().fromJson(serverResponse.errorBody().charStream(), ErrorResponse.class);
                                    int code = serverResponse.code();
                                    if(code == Constantes.TYPE_ERROR_CODE_TOKEN || response.getError().getCodigo().equals(Constantes.ERROR_CODE_TOKEN_EXPIRADO)){
                                        emitter.onError(new TokenException(code == Constantes.TYPE_ERROR_CODE_TOKEN ?response.getError().getTitulo(): response.getError().getMensaje()));
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

    public Single<Boolean> addContador(String idApp) {
        return Single.create(emitter -> {
            if (isThereInternetConnection()) {
                CompositeDisposable disposable = new CompositeDisposable();
                AppsRestApi restApi = new BaseNet().create(Constantes.HOST_API_D4,AppsRestApi.class, getToken(), this.context);
                disposable.add(restApi.addContador(idApp).subscribe(
                        serverResponse -> {
                            if (serverResponse != null) {
                                if(serverResponse.isSuccessful()){
                                    emitter.onSuccess(true);
                                }else{
                                    ErrorResponse response =new Gson().fromJson(serverResponse.errorBody().charStream(), ErrorResponse.class);
                                    int code = serverResponse.code();
                                    if(code == Constantes.TYPE_ERROR_CODE_TOKEN || response.getError().getCodigo().equals(Constantes.ERROR_CODE_TOKEN_EXPIRADO)){
                                        emitter.onError(new TokenException(code == Constantes.TYPE_ERROR_CODE_TOKEN ?response.getError().getTitulo(): response.getError().getMensaje()));
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


    public Single<PreguntasResponse> getPreguntasFrecuentes() {
        return Single.create(emitter -> {
            if (isThereInternetConnection()) {
                CompositeDisposable disposable = new CompositeDisposable();
                AppsRestApi restApi = new BaseNet().create(Constantes.HOST_API_D4,AppsRestApi.class, getToken(), this.context);
                disposable.add(restApi.getPreguntasFrecuentes().subscribe(
                        serverResponse -> {
                            if (serverResponse != null) {
                                if(serverResponse.isSuccessful() && serverResponse.body() != null){
                                    emitter.onSuccess(serverResponse.body());
                                }else{
                                    ErrorResponse response =new Gson().fromJson(serverResponse.errorBody().charStream(), ErrorResponse.class);
                                    int code = serverResponse.code();
                                    if(code == Constantes.TYPE_ERROR_CODE_TOKEN || response.getError().getCodigo().equals(Constantes.ERROR_CODE_TOKEN_EXPIRADO)){
                                        emitter.onError(new TokenException(code == Constantes.TYPE_ERROR_CODE_TOKEN ?response.getError().getTitulo(): response.getError().getMensaje()));
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

    public Single<Boolean> addPregunta(String descripcion, int orden , int idEstado) {

        NuevaPreguntaRequest nuevaPreguntaRequest = new NuevaPreguntaRequest();
        nuevaPreguntaRequest.setIdPregunta(0);
        nuevaPreguntaRequest.setDescripcion(descripcion);
        nuevaPreguntaRequest.setIdEstado(idEstado);
        nuevaPreguntaRequest.setOrden(orden);

        return Single.create(emitter -> {
            if (isThereInternetConnection()) {
                CompositeDisposable disposable = new CompositeDisposable();
                AppsRestApi restApi = new BaseNet().create(Constantes.HOST_API_D4,AppsRestApi.class, getToken(), this.context);

                disposable.add(restApi.addPregunta( nuevaPreguntaRequest ).subscribe(
                        serverResponse -> {
                            if (serverResponse != null) {
                                if(serverResponse.isSuccessful()){
                                    emitter.onSuccess(true);
                                }else{
                                    ErrorResponse response =new Gson().fromJson(serverResponse.errorBody().charStream(), ErrorResponse.class);
                                    int code = serverResponse.code();
                                    if(code == Constantes.TYPE_ERROR_CODE_TOKEN || response.getError().getCodigo().equals(Constantes.ERROR_CODE_TOKEN_EXPIRADO)){
                                        emitter.onError(new TokenException(code == Constantes.TYPE_ERROR_CODE_TOKEN ?response.getError().getTitulo(): response.getError().getMensaje()));
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

    public Single<Boolean> updatePregunta(int idPregunta, String descripcion, int orden , int idEstado) {

        ActualizarPreguntaRequest actualizarPreguntaRequest = new ActualizarPreguntaRequest();
        actualizarPreguntaRequest.setIdPregunta(idPregunta);
        actualizarPreguntaRequest.setDescripcion(descripcion);
        actualizarPreguntaRequest.setIdEstado(idEstado);
        actualizarPreguntaRequest.setOrden(orden);

        return Single.create(emitter -> {
            if (isThereInternetConnection()) {
                CompositeDisposable disposable = new CompositeDisposable();
                AppsRestApi restApi = new BaseNet().create(Constantes.HOST_API_D4,AppsRestApi.class, getToken(), this.context);

                disposable.add(restApi.updatePregunta( idPregunta, actualizarPreguntaRequest ).subscribe(
                        serverResponse -> {
                            if (serverResponse != null) {
                                if(serverResponse.isSuccessful()){
                                    emitter.onSuccess(true);
                                }else{
                                    ErrorResponse response =new Gson().fromJson(serverResponse.errorBody().charStream(), ErrorResponse.class);
                                    int code = serverResponse.code();
                                    if(code == Constantes.TYPE_ERROR_CODE_TOKEN || response.getError().getCodigo().equals(Constantes.ERROR_CODE_TOKEN_EXPIRADO)){
                                        emitter.onError(new TokenException(code == Constantes.TYPE_ERROR_CODE_TOKEN ?response.getError().getTitulo(): response.getError().getMensaje()));
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

    public Single<Boolean> updateMasivoPreguntas(int tipo, int idEstado  ,  List<Integer> data) {



        return Single.create(emitter -> {
            if (isThereInternetConnection()) {
                CompositeDisposable disposable = new CompositeDisposable();
                AppsRestApi restApi = new BaseNet().create(Constantes.HOST_API_D4,AppsRestApi.class, getToken(), this.context);

                disposable.add(restApi.updateMasivoPreguntas( tipo, idEstado,data ).subscribe(
                        serverResponse -> {
                            if (serverResponse != null) {
                                if(serverResponse.isSuccessful()){
                                    emitter.onSuccess(true);
                                }else{
                                    ErrorResponse response =new Gson().fromJson(serverResponse.errorBody().charStream(), ErrorResponse.class);
                                    int code = serverResponse.code();
                                    if(code == Constantes.TYPE_ERROR_CODE_TOKEN || response.getError().getCodigo().equals(Constantes.ERROR_CODE_TOKEN_EXPIRADO)){
                                        emitter.onError(new TokenException(code == Constantes.TYPE_ERROR_CODE_TOKEN ?response.getError().getTitulo(): response.getError().getMensaje()));
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


    public Single<Boolean> addRespuesta(String descripcion, int orden , int idEstado, int idPregunta) {

        NuevaRespuestaRequest nuevaRespuestaRequest = new NuevaRespuestaRequest();
        nuevaRespuestaRequest.setIdRespuesta(0);
        nuevaRespuestaRequest.setDescripcion(descripcion);
        nuevaRespuestaRequest.setIdEstado(idEstado);
        nuevaRespuestaRequest.setOrden(orden);

        return Single.create(emitter -> {
            if (isThereInternetConnection()) {
                CompositeDisposable disposable = new CompositeDisposable();
                AppsRestApi restApi = new BaseNet().create(Constantes.HOST_API_D4,AppsRestApi.class, getToken(), this.context);

                disposable.add(restApi.addRespuesta(idPregunta,nuevaRespuestaRequest ).subscribe(
                        serverResponse -> {
                            if (serverResponse != null) {
                                if(serverResponse.isSuccessful()){
                                    emitter.onSuccess(true);
                                }else{
                                    ErrorResponse response =new Gson().fromJson(serverResponse.errorBody().charStream(), ErrorResponse.class);
                                    int code = serverResponse.code();
                                    if(code == Constantes.TYPE_ERROR_CODE_TOKEN || response.getError().getCodigo().equals(Constantes.ERROR_CODE_TOKEN_EXPIRADO)){
                                        emitter.onError(new TokenException(code == Constantes.TYPE_ERROR_CODE_TOKEN ?response.getError().getTitulo(): response.getError().getMensaje()));
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

    public Single<Boolean> updateRespuesta(int idPregunta, String descripcion, int orden , int idEstado, int idRespuesta) {

        ActualizarRespuestaRequest actualizarRespuestaRequest = new ActualizarRespuestaRequest();
        actualizarRespuestaRequest.setIdRespuesta(idRespuesta);
        actualizarRespuestaRequest.setDescripcion(descripcion);
        actualizarRespuestaRequest.setIdEstado(idEstado);
        actualizarRespuestaRequest.setOrden(orden);

        return Single.create(emitter -> {
            if (isThereInternetConnection()) {
                CompositeDisposable disposable = new CompositeDisposable();
                AppsRestApi restApi = new BaseNet().create(Constantes.HOST_API_D4,AppsRestApi.class, getToken(), this.context);

                disposable.add(restApi.updateRespuesta( idPregunta,idRespuesta, actualizarRespuestaRequest ).subscribe(
                        serverResponse -> {
                            if (serverResponse != null) {
                                if(serverResponse.isSuccessful()){
                                    emitter.onSuccess(true);
                                }else{
                                    ErrorResponse response =new Gson().fromJson(serverResponse.errorBody().charStream(), ErrorResponse.class);
                                    int code = serverResponse.code();
                                    if(code == Constantes.TYPE_ERROR_CODE_TOKEN || response.getError().getCodigo().equals(Constantes.ERROR_CODE_TOKEN_EXPIRADO)){
                                        emitter.onError(new TokenException(code == Constantes.TYPE_ERROR_CODE_TOKEN ?response.getError().getTitulo(): response.getError().getMensaje()));
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