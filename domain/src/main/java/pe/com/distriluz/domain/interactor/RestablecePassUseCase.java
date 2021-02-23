package pe.com.distriluz.domain.interactor;


import javax.inject.Inject;

import io.reactivex.Single;
import pe.com.distriluz.domain.executor.PostExecutionThread;
import pe.com.distriluz.domain.executor.ThreadExecutor;
import pe.com.distriluz.domain.interactor.baseinteractors.UseCaseSingle;
import pe.com.distriluz.domain.repository.AuthRepository;


public class RestablecePassUseCase extends UseCaseSingle<Boolean, RestablecePassUseCase.Params> {

    private AuthRepository repository;

    @Inject
    public RestablecePassUseCase(AuthRepository repository, ThreadExecutor threadExecutor,
                                 PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.repository = repository;
    }

    @Override
    public Single<Boolean> buildUseCase(Params params) {
        return repository.restablecePass(params.idUser, params.clave);
    }


    public static class Params {
        private String idUser;
        private String clave;


        public Params(String idUser, String clave) {
            this.idUser = idUser;
            this.clave = clave;

        }

        public static Params datos(String idUser, String clave) {
            return new Params(idUser, clave);
        }
    }

}
