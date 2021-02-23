package pe.com.distriluz.domain.interactor;


import javax.inject.Inject;

import io.reactivex.Single;
import pe.com.distriluz.domain.executor.PostExecutionThread;
import pe.com.distriluz.domain.executor.ThreadExecutor;
import pe.com.distriluz.domain.interactor.baseinteractors.UseCaseSingle;
import pe.com.distriluz.domain.repository.AuthRepository;
import pe.com.distriluz.domain.repository.ChangePasswordRepository;



public class ChangePasswordUseCase extends UseCaseSingle<Boolean, ChangePasswordUseCase.Params> {

    private AuthRepository repository;

    @Inject
    public ChangePasswordUseCase(AuthRepository repository, ThreadExecutor threadExecutor,
                                 PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.repository = repository;
    }

    @Override
    public Single<Boolean> buildUseCase(Params params) {
        return repository.enviarEmail(params.email);
    }


    public static class Params {
        private String email;


        public Params(String email) {
            this.email = email;

        }

        public static Params datos(String email) {
            return new Params(email);
        }
    }

}
