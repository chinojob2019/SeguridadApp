package pe.com.distriluz.data.repository.datasource.auth;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AuthDataStoreFactory {

    private AuthDBDataStore authDBDataStore;
    private AuthCloudDataStore authCloudDataStore;

    @Inject
    public AuthDataStoreFactory(AuthDBDataStore authDBDataStore, AuthCloudDataStore authCloudDataStore) {
        this.authDBDataStore = authDBDataStore;
        this.authCloudDataStore = authCloudDataStore;
    }


    public AuthDataStore createCloudDataStore() {
        return authCloudDataStore;
    }

}
