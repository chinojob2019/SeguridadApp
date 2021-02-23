package pe.com.distriluz.domain.repository;

import io.reactivex.Single;

public interface ChangePasswordRepository {

    Single<Boolean> enviarEmail(String email);
}
