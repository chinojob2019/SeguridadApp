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

    @Override
    public Single<Boolean> addPregunta(String descripcion, int orden, int idEstado) {
        AppsDataStore dataStore = this.factory.createCloudDataStore();
        return dataStore.addPregunta(descripcion,orden,idEstado);
    }

    @Override
    public Single<Boolean> updatePregunta(int idPregunta, String descripcion, int orden, int idEstado) {
        AppsDataStore dataStore = this.factory.createCloudDataStore();
        return dataStore.updatePregunta(idPregunta,descripcion,orden,idEstado);
    }

    @Override
    public Single<Boolean> updateMasivoPreguntas(int tipo, int idEstado, List<Integer> data) {
        AppsDataStore dataStore = this.factory.createCloudDataStore();
        return dataStore.updateMasivoPreguntas(tipo,idEstado,data);
    }

    @Override
    public Single<Boolean> addRespuesta(String descripcion, int orden, int idEstado, int idPregunta) {
        AppsDataStore dataStore = this.factory.createCloudDataStore();
        return dataStore.addRespuesta(descripcion,orden,idEstado,idPregunta);
    }

    @Override
    public Single<Boolean> updateRespuesta(int idPregunta, String descripcion, int orden, int idEstado, int idRespuesta) {
        AppsDataStore dataStore = this.factory.createCloudDataStore();
        return dataStore.updateRespuesta(idPregunta,descripcion,orden,idEstado,idRespuesta);
    }
}
