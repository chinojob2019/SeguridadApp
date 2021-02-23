package pe.com.distriluz.domain.interactor;


import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import pe.com.distriluz.domain.executor.PostExecutionThread;
import pe.com.distriluz.domain.executor.ThreadExecutor;
import pe.com.distriluz.domain.interactor.baseinteractors.UseCaseSingle;
import pe.com.distriluz.domain.model.Apps;
import pe.com.distriluz.domain.model.Preguntasfrecuentes;
import pe.com.distriluz.domain.repository.AppsRepository;


public class GetPreguntasCase extends UseCaseSingle<List<Preguntasfrecuentes>, GetPreguntasCase.Params> {

    private AppsRepository repository;

    @Inject
    public GetPreguntasCase(AppsRepository repository, ThreadExecutor threadExecutor,
                            PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.repository = repository;
    }

    @Override
    public Single<List<Preguntasfrecuentes>> buildUseCase(Params params) {
        return repository.getPreguntasFrecuentes();
    }


    public static class Params {

    }

}
