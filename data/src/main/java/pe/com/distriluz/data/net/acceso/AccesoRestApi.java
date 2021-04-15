package pe.com.distriluz.data.net.acceso;

import io.reactivex.Observable;
import pe.com.distriluz.data.net.acceso.model.OpcionesMenuResponse;
import pe.com.distriluz.data.net.auth.model.LoginRequest;
import pe.com.distriluz.data.net.auth.model.LoginResponse;
import pe.com.distriluz.data.utiles.Constantes;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface AccesoRestApi {


    @Headers({
            "Content-Type:application/json",
            "X-AppKey: " + Constantes.X_APPKEY,
            "X-AppCode: " + Constantes.X_APPCODE
    })
    @GET("acceso/usuarioopcionesmenu")
    Observable<Response<OpcionesMenuResponse>> obtenerListarOpcionesMenu();


}
