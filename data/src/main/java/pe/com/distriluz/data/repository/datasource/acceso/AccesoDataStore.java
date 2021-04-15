package pe.com.distriluz.data.repository.datasource.acceso;


import java.util.List;

import io.reactivex.Single;
import pe.com.distriluz.data.net.apps.model.PreguntasResponse;
import pe.com.distriluz.domain.model.Apps;
import pe.com.distriluz.domain.model.OpcionesMenu;

/**
 * Interface that represents a data store from where data is retrieved.
 */
public interface AccesoDataStore {

    Single<OpcionesMenu> getOpcionesMenu();

}
