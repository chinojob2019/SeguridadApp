package pe.com.distriluz.app.services;

import io.reactivex.Observable;

/**
 * Created by pedro.zevallos on 10/01/2018.
 */

public interface IGpsServices {

    Observable<Boolean> observePressure();
    Observable<String> info();
}
