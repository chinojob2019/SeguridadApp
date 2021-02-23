package pe.com.distriluz.data.repository.datasource.apps;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppsDataStoreFactory {

    private AppsDBDataStore appsDBDataStore;
    private AppsCloudDataStore appsCloudDataStore;

    @Inject
    public AppsDataStoreFactory(AppsDBDataStore appsDBDataStore, AppsCloudDataStore appsCloudDataStore) {
        this.appsDBDataStore = appsDBDataStore;
        this.appsCloudDataStore = appsCloudDataStore;
    }


    public AppsDataStore createCloudDataStore() {
        return appsCloudDataStore;
    }


    public AppsDataStore createBDDataStore() {
        return appsDBDataStore;
    }

}
