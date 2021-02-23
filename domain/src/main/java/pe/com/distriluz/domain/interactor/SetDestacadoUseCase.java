package pe.com.distriluz.domain.interactor;


import javax.inject.Inject;

import io.reactivex.Single;
import pe.com.distriluz.domain.executor.PostExecutionThread;
import pe.com.distriluz.domain.executor.ThreadExecutor;
import pe.com.distriluz.domain.interactor.baseinteractors.UseCaseSingle;
import pe.com.distriluz.domain.model.Apps;
import pe.com.distriluz.domain.repository.AppsRepository;


public class SetDestacadoUseCase extends UseCaseSingle<Boolean, SetDestacadoUseCase.Params> {

    private AppsRepository repository;

    @Inject
    public SetDestacadoUseCase(AppsRepository repository, ThreadExecutor threadExecutor,
                               PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.repository = repository;
    }

    @Override
    public Single<Boolean> buildUseCase(Params params) {
        return repository.setDestacado(params.idApp, params.value);
    }


    public static class Params {
        private String idApp;
        private String value;

        public Params(String idApp, String value) {
            this.idApp = idApp;
            this.value = value;
        }

        public static Params datos(String idApp, String value) {
            return new Params(idApp, value);
        }
    }

}
