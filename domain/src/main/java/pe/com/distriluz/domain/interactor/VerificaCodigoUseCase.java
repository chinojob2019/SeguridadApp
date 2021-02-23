package pe.com.distriluz.domain.interactor;


import javax.inject.Inject;

import io.reactivex.Single;
import pe.com.distriluz.domain.executor.PostExecutionThread;
import pe.com.distriluz.domain.executor.ThreadExecutor;
import pe.com.distriluz.domain.interactor.baseinteractors.UseCaseSingle;
import pe.com.distriluz.domain.repository.AuthRepository;


public class VerificaCodigoUseCase extends UseCaseSingle<Boolean, VerificaCodigoUseCase.Params> {

    private AuthRepository repository;

    @Inject
    public VerificaCodigoUseCase(AuthRepository repository, ThreadExecutor threadExecutor,
                                 PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.repository = repository;
    }

    @Override
    public Single<Boolean> buildUseCase(Params params) {
        return repository.verificaCodigo(params.idUser, params.codigo);
    }


    public static class Params {
        private String idUser;
        private String codigo;


        public Params(String idUser, String codigo) {
            this.idUser = idUser;
            this.codigo = codigo;

        }

        public static Params datos(String idUser, String codigo) {
            return new Params(idUser, codigo);
        }
    }

}
