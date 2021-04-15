package pe.com.distriluz.data.repository;


import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;


import pe.com.distriluz.data.repository.datasource.acceso.AccesoDataMapper;
import pe.com.distriluz.data.repository.datasource.acceso.AccesoDataStore;
import pe.com.distriluz.data.repository.datasource.acceso.AccesoDataStoreFactory;
import pe.com.distriluz.domain.model.OpcionesMenu;
import pe.com.distriluz.domain.model.Preguntasfrecuentes;
import pe.com.distriluz.domain.repository.AccesoRepository;


@Singleton
public class AccesoDataRepository implements AccesoRepository {

    private AccesoDataStoreFactory factory;
    private AccesoDataMapper mapper;

    @Inject
    public AccesoDataRepository(AccesoDataStoreFactory factory, AccesoDataMapper mapper) {
        this.factory = factory;
        this.mapper = mapper;
    }


    @Override
    public Single<OpcionesMenu> getOpcioneMenu() {
        AccesoDataStore dataStore = this.factory.createCloudDataStore();
        return dataStore.getOpcionesMenu();
    }
}
