package pe.com.distriluz.domain.interactor;


import javax.inject.Inject;

import io.reactivex.Single;
import pe.com.distriluz.domain.executor.PostExecutionThread;
import pe.com.distriluz.domain.executor.ThreadExecutor;
import pe.com.distriluz.domain.interactor.baseinteractors.UseCaseSingle;
import pe.com.distriluz.domain.model.Apps;
import pe.com.distriluz.domain.model.OpcionesMenu;
import pe.com.distriluz.domain.repository.AccesoRepository;
import pe.com.distriluz.domain.repository.AppsRepository;


public class GetMenuUseCase extends UseCaseSingle<OpcionesMenu, GetMenuUseCase.Params> {

    private AccesoRepository repository;

    @Inject
    public GetMenuUseCase(AccesoRepository repository, ThreadExecutor threadExecutor,
                          PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.repository = repository;
    }

    @Override
    public Single<OpcionesMenu> buildUseCase(Params params) {
        return repository.getOpcioneMenu();
    }


    public static class Params {

    }

}
