package pe.com.distriluz.domain.interactor;


import javax.inject.Inject;

import io.reactivex.Single;
import pe.com.distriluz.domain.executor.PostExecutionThread;
import pe.com.distriluz.domain.executor.ThreadExecutor;
import pe.com.distriluz.domain.interactor.baseinteractors.UseCaseSingle;
import pe.com.distriluz.domain.repository.AppsRepository;


public class UpdateRespuestaUseCase extends UseCaseSingle<Boolean, UpdateRespuestaUseCase.Params> {

    private AppsRepository repository;

    @Inject
    public UpdateRespuestaUseCase(AppsRepository repository, ThreadExecutor threadExecutor,
                                  PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.repository = repository;
    }

    @Override
    public Single<Boolean> buildUseCase(Params params) {
        return repository.updateRespuesta(params.idPregunta, params.descripcion, params.orden, params.idEstado, params.idRespuesta );
    }

    public static class Params {
        private String descripcion;
        private int orden;
        private int idEstado;
        private int idPregunta;
                private int idRespuesta;

        public Params(String descripcion, int orden , int idEstado, int idPregunta, int idRespuesta) {
            this.descripcion = descripcion;
            this.orden = orden;
            this.idEstado = idEstado;
            this.idPregunta=idPregunta;
this.idRespuesta = idRespuesta;
        }

        public static Params datos(String descripcion, int orden , int idEstado, int idPregunta, int idRespuesta) {
            return new Params(descripcion, orden, idEstado,idPregunta, idRespuesta);
        }
    }

}
