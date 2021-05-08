package pe.com.distriluz.data.repository.datasource.auth;


import io.reactivex.Single;
import pe.com.distriluz.data.net.auth.AuthRestApiImpl;
import pe.com.distriluz.data.net.auth.model.ParametrosResponse;
import pe.com.distriluz.domain.model.Parametros;

public class AuthCloudDataStore implements AuthDataStore {

    private AuthRestApiImpl restApi;
    private AuthDataMapper mapper;

    public AuthCloudDataStore(AuthRestApiImpl restApi, AuthDataMapper mapper) {
        this.restApi = restApi;
        this.mapper = mapper;
    }

    @Override
    public Single<Boolean> login(String username, String pass, boolean session) {
        return restApi.login(username, pass,session);
    }

    @Override
    public Single<Boolean> getDetailUser() {
        return restApi.getDetailUser();
    }

    @Override
    public Single<Boolean> enviarEmail(String email) {
        return restApi.sendMailForgotPass(email);
    }

    @Override
    public Single<Boolean> verificaCodigo(String idUser, String codigo) {
        return restApi.verificaCodigo(idUser, codigo);
    }

    @Override
    public Single<Boolean> restablecePass(String idUser, String clave) {
        return restApi.restablecePass(idUser,clave);
    }

    @Override
    public Single<Boolean> saveDataInfo(String direccion, String telefono, String email) {
        return restApi.saveDataInfo(direccion, telefono, email);
    }

    @Override
    public Single<Boolean> savePhoto(String base64) {
        return restApi.savePhoto(base64);
    }

    @Override
    public Single<Parametros> getParametros() {
        return restApi.getParametros().map(mapper::mapperParametros);
    }

}