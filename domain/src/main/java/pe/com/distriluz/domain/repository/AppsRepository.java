package pe.com.distriluz.domain.repository;


import java.util.List;

import io.reactivex.Single;
import pe.com.distriluz.domain.model.Apps;
import pe.com.distriluz.domain.model.Preguntasfrecuentes;

public interface AppsRepository {

    Single<Apps> getApps();
    Single<Boolean> setDestacado(String idApp, String value);
    Single<Boolean> addContador(String idApp);
    Single<List<Preguntasfrecuentes>> getPreguntasFrecuentes();
    Single<Boolean> addPregunta(String descripcion, int orden , int idEstado);
    Single<Boolean> updatePregunta(int idPregunta, String descripcion, int orden , int idEstado);
}
