package pe.com.distriluz.domain.repository;


import java.util.List;

import io.reactivex.Single;
import pe.com.distriluz.domain.model.Apps;
import pe.com.distriluz.domain.model.OpcionesMenu;
import pe.com.distriluz.domain.model.Preguntasfrecuentes;

public interface AccesoRepository {

    Single<OpcionesMenu> getOpcioneMenu();

}
