package pe.com.distriluz.data.net.apps;


import io.reactivex.Observable;
import pe.com.distriluz.data.net.apps.model.AppsResponse;
import pe.com.distriluz.data.net.apps.model.PreguntasResponse;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AppsRestApi {


    @GET("aplicacion/listado/")
    Observable<Response<AppsResponse>> getApps();


    @PUT("aplicacion/{idApp}/contadores")
    Observable<Response<Void>> addContador(@Path("idApp") String idApp);


    @PUT("aplicacion/{idApp}/destacado/{value}")
    Observable<Response<Void>> setDestacado(@Path("idApp") String idApp, @Path("value") String value);

    @GET("preguntasfrecuentes")
    Observable<Response<PreguntasResponse>> getPreguntasFrecuentes();


}