package pe.com.distriluz.domain.interactor;


import javax.inject.Inject;

import io.reactivex.Single;
import pe.com.distriluz.domain.executor.PostExecutionThread;
import pe.com.distriluz.domain.executor.ThreadExecutor;
import pe.com.distriluz.domain.interactor.baseinteractors.UseCaseSingle;
import pe.com.distriluz.domain.model.Apps;
import pe.com.distriluz.domain.repository.AppsRepository;


public class GetAppsUseCase extends UseCaseSingle<Apps, GetAppsUseCase.Params> {

    private AppsRepository repository;

    @Inject
    public GetAppsUseCase(AppsRepository repository, ThreadExecutor threadExecutor,
                          PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.repository = repository;
    }

    @Override
    public Single<Apps> buildUseCase(Params params) {
        return repository.getApps();
    }


    public static class Params {

    }

}
