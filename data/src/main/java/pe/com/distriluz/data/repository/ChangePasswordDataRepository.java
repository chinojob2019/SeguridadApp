package pe.com.distriluz.data.repository;


import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import pe.com.distriluz.data.repository.datasource.changepassword.ChangePasswordDataMapper;
import pe.com.distriluz.data.repository.datasource.changepassword.ChangePasswordDataStore;
import pe.com.distriluz.data.repository.datasource.changepassword.ChangePasswordDataStoreFactory;
import pe.com.distriluz.domain.repository.ChangePasswordRepository;

@Singleton
public class ChangePasswordDataRepository implements ChangePasswordRepository {

    private ChangePasswordDataStoreFactory factory;
    private ChangePasswordDataMapper mapper;

    @Inject
    public ChangePasswordDataRepository(ChangePasswordDataStoreFactory factory, ChangePasswordDataMapper mapper) {
        this.factory = factory;
        this.mapper = mapper;
    }




    @Override
    public Single<Boolean> enviarEmail(String email) {
        ChangePasswordDataStore dataStore = this.factory.createCloudDataStore();
        return dataStore.enviarEmail(email);

    }
}
