package pe.com.distriluz.domain.repository;


import io.reactivex.Single;
import pe.com.distriluz.domain.model.Parametros;

public interface AuthRepository {

    Single<Boolean> login(String username, String pass, boolean session);

    Single<Boolean> enviarEmail(String email);

    Single<Boolean> verificaCodigo(String idUser, String codigo);

    Single<Boolean> restablecePass(String idUser, String clave);
    Single<Boolean> saveDataInfo(String direccion, String telefono, String photo, String email);

    Single<Parametros> getParametros();
}
