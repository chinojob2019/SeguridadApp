package pe.com.distriluz.data.repository.datasource;

import pe.com.distriluz.data.net.auth.AuthRestApiImpl;
import pe.com.distriluz.data.utiles.Utils;

public abstract class BaseCloudDataStore {

    public AuthRestApiImpl restApiLogin;
    public Utils utils;

    public BaseCloudDataStore(AuthRestApiImpl restApiLogin, Utils utils) {
        this.restApiLogin = restApiLogin;
        this.utils = utils;
    }

//    protected <T> Single<T> relogin(Single<T> single){
//        return single.onErrorResumeNext(
//                throwable -> {
//                    Log.i("demo", "ingresa al onErrorResumeNext");
//                    if(throwable instanceof TokenException){
//                        Log.i("demo", "es un TokenException");
//                        return restApiLogin.login(utils.getUserLogin(), utils.getUserPassword(), utils.getIso())
//                                .flatMap(
//                                        aBoolean -> single
//                                );
//                    }else{
//                        Log.i("demo", "no es un TokenException");
//                        return Single.error(throwable);
//                    }
//                });
//    }
//
//    protected <T> Observable<T> relogin(Observable<T> single){
//        return single.onErrorResumeNext(
//                throwable -> {
//                    Log.i("demo", "ingresa al onErrorResumeNext");
//                    if(throwable instanceof TokenException){
//                        Log.i("demo", "es un TokenException");
//                        return restApiLogin.login(utils.getUserLogin(), utils.getUserPassword(), utils.getIso())
//                                .toObservable()
//                                .flatMap(
//                                        aBoolean -> single
//                                );
//                    }else{
//                        Log.i("demo", "no es un TokenException");
//                        return Observable.error(throwable);
//                    }
//                });
//    }
}
