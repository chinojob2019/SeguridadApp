package pe.com.distriluz.data.repository;


import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import pe.com.distriluz.data.repository.datasource.auth.AuthDataMapper;
import pe.com.distriluz.data.repository.datasource.auth.AuthDataStore;
import pe.com.distriluz.data.repository.datasource.auth.AuthDataStoreFactory;
import pe.com.distriluz.domain.model.Parametros;
import pe.com.distriluz.domain.repository.AuthRepository;

@Singleton
public class AuthDataRepository implements AuthRepository {

    private AuthDataStoreFactory factory;
    private AuthDataMapper mapper;

    @Inject
    public AuthDataRepository(AuthDataStoreFactory factory, AuthDataMapper mapper) {
        this.factory = factory;
        this.mapper = mapper;
    }

    @Override
    public Single<Boolean> login(String username, String pass, boolean session) {
        AuthDataStore dataStore = this.factory.createCloudDataStore();
        return dataStore.login(username, pass,session)
                .flatMap(result -> dataStore.getDetailUser());
    }

    @Override
    public Single<Boolean> enviarEmail(String email) {
        AuthDataStore dataStore = this.factory.createCloudDataStore();
        return dataStore.enviarEmail(email);
    }

    @Override
    public Single<Boolean> verificaCodigo(String idUser, String codigo) {
        AuthDataStore dataStore = this.factory.createCloudDataStore();
        return dataStore.verificaCodigo(idUser, codigo);
    }

    @Override
    public Single<Boolean> restablecePass(String idUser, String clave) {
        AuthDataStore dataStore = this.factory.createCloudDataStore();
        return dataStore.restablecePass(idUser, clave);
    }

    @Override
    public Single<Boolean> saveDataInfo(String direccion, String telefono, String photo, String email) {
        AuthDataStore dataStore = this.factory.createCloudDataStore();
        Single<Boolean> savePhoto = null;
        if(!photo.isEmpty()){
            savePhoto =  dataStore.savePhoto(photo);
        }
        Single<Boolean> saveData = null;
        if(direccion.isEmpty() && telefono.isEmpty() && email.isEmpty()){

        }else {
            saveData = dataStore.saveDataInfo(direccion, telefono, email);
        }

        if(savePhoto== null){
            if(saveData == null) {
                return dataStore.getDetailUser();
            }else{
                return Single.concat(saveData,dataStore.getDetailUser()).last(false);
            }
        }else{
            if(saveData == null) {
                return Single.concat(savePhoto, dataStore.getDetailUser()).last(false);
            }else{
                return Single.concat(Single.merge(saveData,savePhoto).last(false),dataStore.getDetailUser()).last(false);
            }
        }
    }

    @Override
    public Single<Parametros> getParametros() {
        AuthDataStore dataStore = this.factory.createCloudDataStore();
        return dataStore.getParametros();
    }
}
