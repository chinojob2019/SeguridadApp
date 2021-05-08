package pe.com.distriluz.domain.interactor;


import javax.inject.Inject;

import io.reactivex.Single;
import pe.com.distriluz.domain.executor.PostExecutionThread;
import pe.com.distriluz.domain.executor.ThreadExecutor;
import pe.com.distriluz.domain.interactor.baseinteractors.UseCaseSingle;
import pe.com.distriluz.domain.model.Apps;
import pe.com.distriluz.domain.model.Parametros;
import pe.com.distriluz.domain.repository.AppsRepository;
import pe.com.distriluz.domain.repository.AuthRepository;


public class GetParametrosUseCase extends UseCaseSingle<Parametros, GetParametrosUseCase.Params> {

    private AuthRepository repository;

    @Inject
    public GetParametrosUseCase(AuthRepository repository, ThreadExecutor threadExecutor,
                                PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.repository = repository;
    }

    @Override
    public Single<Parametros> buildUseCase(Params params) {
        return repository.getParametros();
    }


    public static class Params {

    }

}
