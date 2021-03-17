package pe.com.distriluz.data.net.auth;


import java.util.List;

import io.reactivex.Observable;
import pe.com.distriluz.data.net.auth.model.BasicBodyRequest;
import pe.com.distriluz.data.net.auth.model.DetailUserResponse;
import pe.com.distriluz.data.net.auth.model.EditProfileRequest;
import pe.com.distriluz.data.net.auth.model.LoginRequest;
import pe.com.distriluz.data.net.auth.model.LoginResponse;
import pe.com.distriluz.data.net.auth.model.RefreshTokensRequest;
import pe.com.distriluz.data.net.auth.model.RefreshTokensResponse;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AuthRestApi {


    @POST("autenticacion")
    Observable<Response<LoginResponse>> login(@Body LoginRequest dataLogin);

    @GET("persona/datos/")
    Observable<Response<DetailUserResponse>> getDetailUser();

    @PUT("clave/envia/correo")
    Observable<Response<Void>> sendMailForgotPass(@Body BasicBodyRequest data);

    @PUT("clave/usuario/{idUser}/verifica/{codigo}")
    Observable<Response<Void>> verificaCodigo(@Path("idUser") String idUser, @Path("codigo") String codigo);

    @PUT("clave/usuario/{idUser}/reestablece")
    Observable<Response<Void>> restablecePass(@Path("idUser") String idUser, @Body BasicBodyRequest data);

    @PUT("persona/{idPersona}/datos/personales")
    Observable<Response<Void>> saveDataInfo(@Path("idPersona") String idPersona, @Body List<EditProfileRequest> data);

    @PUT("persona/{idPersona}/foto")
    Observable<Response<Void>> savePhoto(@Path("idPersona") String idPersona, @Body EditProfileRequest data);

    @POST("autenticacion/refresh/token")
    Observable<Response<RefreshTokensResponse>> refreshTokens(@Body RefreshTokensRequest dataRefreshTokens);

}