package pe.com.distriluz.data.repository.datasource.acceso;


import java.util.List;

import io.reactivex.Single;
import pe.com.distriluz.data.net.acceso.AccesoRestApiImpl;
import pe.com.distriluz.data.net.apps.AppsRestApiImpl;
import pe.com.distriluz.data.net.apps.model.PreguntasResponse;
import pe.com.distriluz.data.repository.datasource.apps.AppsDataMapper;
import pe.com.distriluz.data.repository.datasource.apps.AppsDataStore;
import pe.com.distriluz.domain.model.Apps;
import pe.com.distriluz.domain.model.OpcionesMenu;

public class AccesoCloudDataStore implements AccesoDataStore {

    private AccesoRestApiImpl restApi;
    private AccesoDataMapper mapper;

    public AccesoCloudDataStore(AccesoRestApiImpl restApi, AccesoDataMapper mapper) {
        this.restApi = restApi;
        this.mapper = mapper;
    }


    @Override
    public Single<OpcionesMenu> getOpcionesMenu() {
        return restApi.getOpcionesMenu().map(mapper::mapperOpcionesMenu);
    }
}