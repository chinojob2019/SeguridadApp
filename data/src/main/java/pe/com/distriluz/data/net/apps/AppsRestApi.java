package pe.com.distriluz.data.net.apps;


import java.util.List;

import io.reactivex.Observable;
import pe.com.distriluz.data.net.apps.model.ActualizarPreguntaRequest;
import pe.com.distriluz.data.net.apps.model.AppsResponse;
import pe.com.distriluz.data.net.apps.model.NuevaPreguntaRequest;
import pe.com.distriluz.data.net.apps.model.PreguntasResponse;
import pe.com.distriluz.data.net.auth.model.EditProfileRequest;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
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


    @POST("preguntasfrecuentes/nuevo")
    Observable<Response<Void>> addPregunta(@Body NuevaPreguntaRequest data);

    @PUT("preguntasfrecuentes/{idPregunta}")
    Observable<Response<Void>> updatePregunta(@Path("idPregunta") int idPregunta,@Body ActualizarPreguntaRequest data);




}