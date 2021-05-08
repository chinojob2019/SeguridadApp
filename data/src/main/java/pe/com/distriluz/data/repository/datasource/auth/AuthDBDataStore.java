package pe.com.distriluz.data.repository.datasource.auth;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import pe.com.distriluz.data.net.auth.model.ParametrosResponse;
import pe.com.distriluz.data.utiles.Utils;
import pe.com.distriluz.domain.model.Parametros;

@Singleton
public class AuthDBDataStore implements AuthDataStore {

    private AuthDataMapper mapper;

    @Inject
    public AuthDBDataStore(AuthDataMapper mapper) {
        this.mapper = mapper;
    }


    @Override
    public Single<Boolean> login(String username, String pass, boolean session) {
        return Utils.defaultErrorBDSingle();
    }

    @Override
    public Single<Boolean> getDetailUser() {
        return null;
    }

    @Override
    public Single<Boolean> enviarEmail(String email) {
        return Utils.defaultErrorBDSingle();
    }

    @Override
    public Single<Boolean> verificaCodigo(String idUser, String codigo) {
        return null;
    }

    @Override
    public Single<Boolean> restablecePass(String idUser, String clave) {
        return null;
    }

    @Override
    public Single<Boolean> saveDataInfo(String direccion, String telefono, String email) {
        return null;
    }

    @Override
    public Single<Boolean> savePhoto(String base64) {
        return null;
    }

    @Override
    public Single<Parametros> getParametros() {
        return Utils.defaultErrorBDSingle();
    }

}