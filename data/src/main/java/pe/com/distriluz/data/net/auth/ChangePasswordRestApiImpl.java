package pe.com.distriluz.data.net.auth;


import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import pe.com.distriluz.data.net.BaseRestApiImpl;
import pe.com.distriluz.data.net.model.user.DetailUserResponse2;


@Singleton
public class ChangePasswordRestApiImpl extends BaseRestApiImpl {

    @Inject
    public ChangePasswordRestApiImpl(Context context) {
        super(context);
    }

    public Single<Boolean> login(String username, String pass, boolean session) {
        return Single.create(emitter -> {
//            if (isThereInternetConnection()) {
//                CompositeDisposable disposable = new CompositeDisposable();
//                AuthRestApi restApi = new BaseNet().createNotToken(Constantes.HOST, AuthRestApi.class);
//                disposable.add(restApi.login(username,pass).subscribe(
//                        serverResponse -> {
//                            if (serverResponse != null) {
//                                if(serverResponse.isSuccessful() && serverResponse.body()!=null){
//                                    Utils.saveSession(context,serverResponse.body(),username, pass,session);
//                                    emitter.onSuccess(true);
//                                }else{
//                                    ErrorResponse response =new Gson().fromJson(serverResponse.errorBody().charStream(), ErrorResponse.class);
//                                    emitter.onError(new ErrorException(response.getMesage()));
//                                }
//                            } else {
//                                emitter.onError(new ErrorException("Datos Nulos"));
//                            }
//                        }
//                        , emitter::onError
//                ));
//            } else {
//                emitter.onError(new NetworkConnectionException());
//            }
        });
    }
    public Single<DetailUserResponse2.Data> detailUser(int idUser) {
        return Single.create(emitter -> {
//            if (isThereInternetConnection()) {
//                CompositeDisposable disposable = new CompositeDisposable();
//                AuthRestApi restApi = new BaseNet().create(Constantes.HOST, AuthRestApi.class, Utils.getToken(context));
//                disposable.add(restApi.getDetail(idUser).subscribe(
//                        serverResponse -> {
////                            if (serverResponse != null) {
////                                if(serverResponse.isSuccessful()){
////                                    if(serverResponse.body().getResultcode()==200){
////                                        emitter.onSuccess(serverResponse.body().getData());
////                                    }else{
////                                        emitter.onError(new ErrorException(serverResponse.body().getMensaje()));
////                                    }
////                                }else if(serverResponse.code()==401){
////                                    LoginResponse response =new Gson().fromJson(serverResponse.errorBody().charStream(), LoginResponse.class);
////                                    emitter.onError(new TokenException(response.getMensaje()));
////                                }else{
////                                    LoginResponse response =new Gson().fromJson(serverResponse.errorBody().charStream(), LoginResponse.class);
////                                    emitter.onError(new ErrorException(response.getMensaje()));
////                                }
////                            } else {
////                                emitter.onError(new ErrorException("Datos Nulos"));
////                            }
//                        }
//                        , emitter::onError
//                ));
//            } else {
//                emitter.onError(new NetworkConnectionException());
//            }
        });
    }
    public Single<Boolean> followUser(int idUser) {
        return Single.create(emitter -> {
//            if (isThereInternetConnection()) {
//                CompositeDisposable disposable = new CompositeDisposable();
//                AuthRestApi restApi = new BaseNet().create(Constantes.HOST, AuthRestApi.class, Utils.getToken(context));
//                disposable.add(restApi.followUser(idUser).subscribe(
//                        serverResponse -> {
////                            if (serverResponse != null) {
////                                if(serverResponse.isSuccessful()){
////                                    if(serverResponse.body().getResultcode()==200){
////                                        emitter.onSuccess(serverResponse.body().getData().getResult()==1);
////                                    }else{
////                                        emitter.onError(new ErrorException(serverResponse.body().getMensaje()));
////                                    }
////                                }else if(serverResponse.code()==401){
////                                    LoginResponse response =new Gson().fromJson(serverResponse.errorBody().charStream(), LoginResponse.class);
////                                    emitter.onError(new TokenException(response.getMensaje()));
////                                }else{
////                                    LoginResponse response =new Gson().fromJson(serverResponse.errorBody().charStream(), LoginResponse.class);
////                                    emitter.onError(new ErrorException(response.getMensaje()));
////                                }
////                            } else {
////                                emitter.onError(new ErrorException("Datos Nulos"));
////                            }
//                        }
//                        , emitter::onError
//                ));
//            } else {
//                emitter.onError(new NetworkConnectionException());
//            }
        });
    }
    public Single<Boolean> unFollowUser(int idUser) {
        return Single.create(emitter -> {
//            if (isThereInternetConnection()) {
//                CompositeDisposable disposable = new CompositeDisposable();
//                AuthRestApi restApi = new BaseNet().create(Constantes.HOST, AuthRestApi.class, Utils.getToken(context));
//                disposable.add(restApi.unfollowUser(idUser).subscribe(
//                        serverResponse -> {
////                            if (serverResponse != null) {
////                                if(serverResponse.isSuccessful()){
////                                    if(serverResponse.body().getResultcode()==200){
////                                        emitter.onSuccess(serverResponse.body().getData().getResult()==1);
////                                    }else{
////                                        emitter.onError(new ErrorException(serverResponse.body().getMensaje()));
////                                    }
////                                }else if(serverResponse.code()==401){
////                                    LoginResponse response =new Gson().fromJson(serverResponse.errorBody().charStream(), LoginResponse.class);
////                                    emitter.onError(new TokenException(response.getMensaje()));
////                                }else{
////                                    LoginResponse response =new Gson().fromJson(serverResponse.errorBody().charStream(), LoginResponse.class);
////                                    emitter.onError(new ErrorException(response.getMensaje()));
////                                }
////                            } else {
////                                emitter.onError(new ErrorException("Datos Nulos"));
////                            }
//                        }
//                        , emitter::onError
//                ));
//            } else {
//                emitter.onError(new NetworkConnectionException());
//            }
        });
    }
}