package pe.com.distriluz.domain.interactor;


import javax.inject.Inject;

import io.reactivex.Single;
import pe.com.distriluz.domain.executor.PostExecutionThread;
import pe.com.distriluz.domain.executor.ThreadExecutor;
import pe.com.distriluz.domain.interactor.baseinteractors.UseCaseSingle;
import pe.com.distriluz.domain.repository.AppsRepository;
import pe.com.distriluz.domain.repository.AuthRepository;


public class AddPreguntaUseCase extends UseCaseSingle<Boolean, AddPreguntaUseCase.Params> {

    private AppsRepository repository;

    @Inject
    public AddPreguntaUseCase(AppsRepository repository, ThreadExecutor threadExecutor,
                              PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.repository = repository;
    }

    @Override
    public Single<Boolean> buildUseCase(Params params) {
        return repository.addPregunta(params.descripcion, params.orden, params.idEstado);
    }

    public static class Params {
        private String descripcion;
        private int orden;
        private int idEstado;

        public Params(String descripcion, int orden , int idEstado) {
            this.descripcion = descripcion;
            this.orden = orden;
            this.idEstado = idEstado;

        }

        public static Params datos(String descripcion, int orden , int idEstado) {
            return new Params(descripcion, orden, idEstado);
        }
    }

}
