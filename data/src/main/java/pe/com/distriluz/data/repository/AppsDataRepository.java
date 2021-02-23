package pe.com.distriluz.data.repository;


import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import pe.com.distriluz.data.repository.datasource.apps.AppsDataMapper;
import pe.com.distriluz.data.repository.datasource.apps.AppsDataStore;
import pe.com.distriluz.data.repository.datasource.apps.AppsDataStoreFactory;
import pe.com.distriluz.domain.model.Apps;
import pe.com.distriluz.domain.model.Preguntasfrecuentes;
import pe.com.distriluz.domain.repository.AppsRepository;

@Singleton
public class AppsDataRepository implements AppsRepository {

    private AppsDataStoreFactory factory;
    private AppsDataMapper mapper;

    @Inject
    public AppsDataRepository(AppsDataStoreFactory factory, AppsDataMapper mapper) {
        this.factory = factory;
        this.mapper = mapper;
    }

    @Override
    public Single<Apps> getApps() {
        AppsDataStore dataStore = this.factory.createCloudDataStore();
        return dataStore.getApps();
    }

    @Override
    public Single<Boolean> setDestacado(String idApp, String value) {
        AppsDataStore dataStore = this.factory.createCloudDataStore();
        return dataStore.setDestacado(idApp, value);
    }

    @Override
    public Single<Boolean> addContador(String idApp) {
        AppsDataStore dataStore = this.factory.createCloudDataStore();
        return dataStore.addContador(idApp);
    }

    @Override
    public Single<List<Preguntasfrecuentes>> getPreguntasFrecuentes() {
        AppsDataStore dataStore = this.factory.createCloudDataStore();
        return dataStore.getPreguntasFrecuentes().map(mapper::mapperQuestions);
    }
}
