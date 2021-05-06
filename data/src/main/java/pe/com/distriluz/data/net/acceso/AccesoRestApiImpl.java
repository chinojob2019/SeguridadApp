package pe.com.distriluz.data.net.acceso;

import android.content.Context;

import com.google.gson.Gson;

import java.net.SocketTimeoutException;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import pe.com.distriluz.data.exception.ErrorException;
import pe.com.distriluz.data.exception.NetworkConnectionException;
import pe.com.distriluz.data.exception.TokenException;
import pe.com.distriluz.data.net.BaseNet;
import pe.com.distriluz.data.net.BaseRestApiImpl;
import pe.com.distriluz.data.net.acceso.model.OpcionesMenuResponse;
import pe.com.distriluz.data.net.apps.AppsRestApi;
import pe.com.distriluz.data.net.apps.model.AppsResponse;
import pe.com.distriluz.data.net.auth.AuthRestApi;
import pe.com.distriluz.data.net.model.ErrorResponse;
import pe.com.distriluz.data.utiles.Constantes;
import pe.com.distriluz.data.utiles.Utils;
@Singleton
public class AccesoRestApiImpl extends BaseRestApiImpl {

    @Inject
    public AccesoRestApiImpl(Context context) {
        super(context);
    }


    public Single<OpcionesMenuResponse> getOpcionesMenu() {
        return Single.create(emitter -> {
            if (isThereInternetConnection()) {
                try{
                    CompositeDisposable disposable = new CompositeDisposable();
                    AccesoRestApi restApi = new BaseNet().create(Constantes.HOST_API_ACCESO,AccesoRestApi.class, getToken(), this.context);
                    disposable.add(restApi.obtenerListarOpcionesMenu().subscribe(
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




}
