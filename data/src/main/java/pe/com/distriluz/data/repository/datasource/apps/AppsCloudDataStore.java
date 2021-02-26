package pe.com.distriluz.data.repository.datasource.apps;


import java.util.List;

import io.reactivex.Single;
import pe.com.distriluz.data.net.apps.AppsRestApiImpl;
import pe.com.distriluz.data.net.apps.model.PreguntasResponse;
import pe.com.distriluz.domain.model.Apps;

public class AppsCloudDataStore implements AppsDataStore {

    private AppsRestApiImpl restApi;
    private AppsDataMapper mapper;

    public AppsCloudDataStore(AppsRestApiImpl restApi, AppsDataMapper mapper) {
        this.restApi = restApi;
        this.mapper = mapper;
    }

    @Override
    public Single<Apps> getApps() {
        return restApi.getApps().map(mapper::mapperApps);
    }

    @Override
    public Single<Boolean> setDestacado(String idApp, String value) {
        return restApi.setDestacado(idApp, value);
    }

    @Override
    public Single<Boolean> addContador(String idApp) {
        return restApi.addContador(idApp);
    }

    @Override
    public Single<List<PreguntasResponse.PreguntasfrecuentesItem>> getPreguntasFrecuentes() {
        return restApi.getPreguntasFrecuentes();
    }
}