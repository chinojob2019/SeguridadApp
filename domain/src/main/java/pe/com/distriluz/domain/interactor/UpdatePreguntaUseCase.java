package pe.com.distriluz.domain.interactor;


import javax.inject.Inject;

import io.reactivex.Single;
import pe.com.distriluz.domain.executor.PostExecutionThread;
import pe.com.distriluz.domain.executor.ThreadExecutor;
import pe.com.distriluz.domain.interactor.baseinteractors.UseCaseSingle;
import pe.com.distriluz.domain.repository.AppsRepository;


public class UpdatePreguntaUseCase extends UseCaseSingle<Boolean, UpdatePreguntaUseCase.Params> {

    private AppsRepository repository;

    @Inject
    public UpdatePreguntaUseCase(AppsRepository repository, ThreadExecutor threadExecutor,
                                 PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.repository = repository;
    }

    @Override
    public Single<Boolean> buildUseCase(Params params) {
        return repository.updatePregunta(params.idPregunta, params.descripcion, params.orden, params.idEstado);
    }

    public static class Params {
        private String descripcion;
        private int orden;
        private int idEstado;
        private int idPregunta;

        public Params(int idPregunta, String descripcion, int orden , int idEstado) {
            this.descripcion = descripcion;
            this.orden = orden;
            this.idEstado = idEstado;
            this.idPregunta= idPregunta;

        }

        public static Params datos(int idPregunta,String descripcion, int orden , int idEstado) {
            return new Params(idPregunta,descripcion, orden, idEstado);
        }
    }

}
