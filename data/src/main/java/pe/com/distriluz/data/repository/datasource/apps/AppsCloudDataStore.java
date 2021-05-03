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
    public Single<PreguntasResponse> getPreguntasFrecuentes() {
        return restApi.getPreguntasFrecuentes();
    }

    @Override
    public Single<Boolean> addPregunta(String descripcion, int orden, int idEstado) {
        return restApi.addPregunta(descripcion,orden,idEstado);
    }

    @Override
    public Single<Boolean> updatePregunta(int idPregunta, String descripcion, int orden, int idEstado) {
        return restApi.updatePregunta(idPregunta,descripcion,orden,idEstado);
    }

    @Override
    public Single<Boolean> updateMasivoPreguntas(int tipo, int idEstado, List<Integer> data) {
        return restApi.updateMasivoPreguntas(tipo,idEstado,data);
    }

    @Override
    public Single<Boolean> addRespuesta(String descripcion, int orden, int idEstado, int idPregunta) {
        return restApi.addRespuesta(descripcion,orden,idEstado,idPregunta);
    }

    @Override
    public Single<Boolean> updateRespuesta(int idPregunta, String descripcion, int orden, int idEstado, int idRespuesta) {
        return restApi.updateRespuesta(idPregunta,descripcion,orden,idEstado,idRespuesta);
    }


}