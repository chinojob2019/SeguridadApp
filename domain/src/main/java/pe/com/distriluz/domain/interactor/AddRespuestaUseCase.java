package pe.com.distriluz.domain.interactor;


import javax.inject.Inject;

import io.reactivex.Single;
import pe.com.distriluz.domain.executor.PostExecutionThread;
import pe.com.distriluz.domain.executor.ThreadExecutor;
import pe.com.distriluz.domain.interactor.baseinteractors.UseCaseSingle;
import pe.com.distriluz.domain.repository.AppsRepository;


public class AddRespuestaUseCase extends UseCaseSingle<Boolean, AddRespuestaUseCase.Params> {

    private AppsRepository repository;

    @Inject
    public AddRespuestaUseCase(AppsRepository repository, ThreadExecutor threadExecutor,
                               PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.repository = repository;
    }

    @Override
    public Single<Boolean> buildUseCase(Params params) {
        return repository.addRespuesta(params.descripcion, params.orden, params.idEstado, params.idPregunta);
    }

    public static class Params {
        private String descripcion;
        private int orden;
        private int idEstado;
        private int idPregunta;

        public Params(String descripcion, int orden , int idEstado, int idPregunta) {
            this.descripcion = descripcion;
            this.orden = orden;
            this.idEstado = idEstado;
            this.idPregunta=idPregunta;

        }

        public static Params datos(String descripcion, int orden , int idEstado, int idPregunta) {
            return new Params(descripcion, orden, idEstado,idPregunta);
        }
    }

}
