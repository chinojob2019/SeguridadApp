package pe.com.distriluz.data.repository.datasource.changepassword;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ChangePasswordDataStoreFactory {

    public ChangePasswordDBDataStore loginDBDataStore;
    private ChangePasswordCloudDataStore changePasswordCloudDataStore;

    @Inject
    public ChangePasswordDataStoreFactory(ChangePasswordDBDataStore loginDBDataStore, ChangePasswordCloudDataStore changePasswordCloudDataStore) {
        this.loginDBDataStore = loginDBDataStore;
        this.changePasswordCloudDataStore = changePasswordCloudDataStore;
    }


    public ChangePasswordDataStore createCloudDataStore() {
        return changePasswordCloudDataStore;
    }

}
