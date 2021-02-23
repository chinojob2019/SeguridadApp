package pe.com.distriluz.data.repository.datasource.changepassword;


import io.reactivex.Single;
import pe.com.distriluz.data.net.auth.ChangePasswordRestApiImpl;

public class ChangePasswordCloudDataStore implements ChangePasswordDataStore {

    private ChangePasswordRestApiImpl restApi;
    private ChangePasswordDataMapper mapper;

    public ChangePasswordCloudDataStore(ChangePasswordRestApiImpl restApi, ChangePasswordDataMapper mapper) {
        this.restApi = restApi;
        this.mapper = mapper;
    }


    @Override
    public Single<Boolean> enviarEmail(String email) {
        return null;
    }
}