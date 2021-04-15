package pe.com.distriluz.data.repository.datasource.acceso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import pe.com.distriluz.data.net.apps.model.PreguntasResponse;
import pe.com.distriluz.data.repository.datasource.apps.AppsDataMapper;
import pe.com.distriluz.data.repository.datasource.apps.AppsDataStore;
import pe.com.distriluz.data.utiles.Utils;
import pe.com.distriluz.domain.model.Apps;
import pe.com.distriluz.domain.model.OpcionesMenu;

@Singleton
public class AccesoDBDataStore implements AccesoDataStore {

    private AccesoDataMapper mapper;

    @Inject
    public AccesoDBDataStore(AccesoDataMapper mapper) {
        this.mapper = mapper;
    }


    @Override
    public Single<OpcionesMenu> getOpcionesMenu() {
        return Utils.defaultErrorBDSingle();
    }
}