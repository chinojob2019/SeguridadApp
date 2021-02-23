package pe.com.distriluz.domain.interactor;


import javax.inject.Inject;

import io.reactivex.Single;
import pe.com.distriluz.domain.executor.PostExecutionThread;
import pe.com.distriluz.domain.executor.ThreadExecutor;
import pe.com.distriluz.domain.interactor.baseinteractors.UseCaseSingle;
import pe.com.distriluz.domain.repository.AppsRepository;


public class AddContadorUseCase extends UseCaseSingle<Boolean, AddContadorUseCase.Params> {

    private AppsRepository repository;

    @Inject
    public AddContadorUseCase(AppsRepository repository, ThreadExecutor threadExecutor,
                              PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.repository = repository;
    }

    @Override
    public Single<Boolean> buildUseCase(Params params) {
        return repository.addContador(params.idApp);
    }


    public static class Params {
        private String idApp;

        public Params(String idApp) {
            this.idApp = idApp;
        }

        public static Params datos(String idApp) {
            return new Params(idApp);
        }
    }

}
