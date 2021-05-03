package pe.com.distriluz.data.repository.datasource.apps;


import java.util.List;

import io.reactivex.Single;
import pe.com.distriluz.data.net.apps.model.PreguntasResponse;
import pe.com.distriluz.domain.model.Apps;

/**
 * Interface that represents a data store from where data is retrieved.
 */
public interface AppsDataStore {

    Single<Apps> getApps();
    Single<Boolean> setDestacado(String idApp, String value);
    Single<Boolean> addContador(String idApp);
    Single<PreguntasResponse> getPreguntasFrecuentes();
    Single<Boolean> addPregunta(String descripcion, int orden , int idEstado);
    Single<Boolean> updatePregunta(int idPregunta, String descripcion, int orden , int idEstado);
    Single<Boolean> updateMasivoPreguntas(int tipo, int idEstado  ,  List<Integer> data);
    Single<Boolean> addRespuesta(String descripcion, int orden , int idEstado, int idPregunta);
    Single<Boolean> updateRespuesta(int idPregunta, String descripcion, int orden , int idEstado, int idRespuesta);

}
