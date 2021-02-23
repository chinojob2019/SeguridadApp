package pe.com.distriluz.domain.interactor;


import javax.inject.Inject;

import io.reactivex.Single;
import pe.com.distriluz.domain.executor.PostExecutionThread;
import pe.com.distriluz.domain.executor.ThreadExecutor;
import pe.com.distriluz.domain.interactor.baseinteractors.UseCaseSingle;
import pe.com.distriluz.domain.repository.AuthRepository;


public class LoginUseCase extends UseCaseSingle<Boolean, LoginUseCase.Params> {

    private AuthRepository repository;

    @Inject
    public LoginUseCase(AuthRepository repository, ThreadExecutor threadExecutor,
                        PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.repository = repository;
    }

    @Override
    public Single<Boolean> buildUseCase(Params params) {
        return repository.login(params.email,params.pass,params.session);
    }


    public static class Params {
        private String email;
        private String pass;
        private boolean session;

        public Params(String email, String pass,boolean session) {
            this.email = email;
            this.pass = pass;
            this.session = session;
        }

        public static Params datos(String email, String pass, boolean session) {
            return new Params(email, pass,session);
        }
    }

}
