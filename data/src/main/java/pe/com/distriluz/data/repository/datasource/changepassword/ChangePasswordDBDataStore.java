package pe.com.distriluz.data.repository.datasource.changepassword;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import pe.com.distriluz.data.utiles.Utils;

@Singleton
public class ChangePasswordDBDataStore implements ChangePasswordDataStore {

    private ChangePasswordDataMapper mapper;

    @Inject
    public ChangePasswordDBDataStore(ChangePasswordDataMapper mapper) {
        this.mapper = mapper;
    }



    @Override
    public Single<Boolean> enviarEmail(String email) {
        return Utils.defaultErrorBDSingle();
    }
}