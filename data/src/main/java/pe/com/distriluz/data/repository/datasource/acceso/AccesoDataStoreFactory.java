package pe.com.distriluz.data.repository.datasource.acceso;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class AccesoDataStoreFactory {

    private AccesoDBDataStore AccesoDBDataStore;
    private AccesoCloudDataStore AccesoCloudDataStore;

    @Inject
    public AccesoDataStoreFactory(AccesoDBDataStore AccesoDBDataStore, AccesoCloudDataStore AccesoCloudDataStore) {
        this.AccesoDBDataStore = AccesoDBDataStore;
        this.AccesoCloudDataStore = AccesoCloudDataStore;
    }


    public AccesoDataStore createCloudDataStore() {
        return AccesoCloudDataStore;
    }


    public AccesoDataStore createBDDataStore() {
        return AccesoDBDataStore;
    }

}
