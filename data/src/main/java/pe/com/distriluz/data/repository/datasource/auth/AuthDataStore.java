package pe.com.distriluz.data.repository.datasource.auth;


import io.reactivex.Single;

/**
 * Interface that represents a data store from where data is retrieved.
 */
public interface AuthDataStore {


    Single<Boolean> login(String username, String pass, boolean session);

    Single<Boolean> getDetailUser();

    Single<Boolean> enviarEmail(String email);

    Single<Boolean> verificaCodigo(String idUser, String codigo);

    Single<Boolean> restablecePass(String idUser, String clave);

    Single<Boolean> saveDataInfo(String direccion, String telefono);

    Single<Boolean> savePhoto(String base64);
}
