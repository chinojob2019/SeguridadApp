package pe.com.distriluz.data.net.auth;


import io.reactivex.Observable;
import pe.com.distriluz.data.net.auth.model.LoginResponse;
import pe.com.distriluz.data.net.model.GenericResponse;
import pe.com.distriluz.data.net.model.user.DetailUserResponse2;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ChangePasswordRestApi {


    @FormUrlEncoded
    @POST("/api/login")
    Observable<Response<LoginResponse>> login(@Body @Field("Login") String username, @Field("Password") String pass);

    @PUT("/api/users/follow/{idUser}")
    Observable<Response<GenericResponse>> followUser(@Path("idUser") int idUser);

    @PUT("/api/users/unfollow/{idUser}")
    Observable<Response<GenericResponse>> unfollowUser(@Path("idUser") int idUser);

    @GET("/api/users/{idUser}")
    Observable<Response<DetailUserResponse2>> getDetail(@Path("idUser") int idUser);


}