package pe.com.distriluz.domain.interactor;


import javax.inject.Inject;

import io.reactivex.Single;
import pe.com.distriluz.domain.executor.PostExecutionThread;
import pe.com.distriluz.domain.executor.ThreadExecutor;
import pe.com.distriluz.domain.interactor.baseinteractors.UseCaseSingle;
import pe.com.distriluz.domain.repository.AuthRepository;


public class SaveInfoUserUseCase extends UseCaseSingle<Boolean, SaveInfoUserUseCase.Params> {

    private AuthRepository repository;

    @Inject
    public SaveInfoUserUseCase(AuthRepository repository, ThreadExecutor threadExecutor,
                               PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.repository = repository;
    }

    @Override
    public Single<Boolean> buildUseCase(Params params) {
        return repository.saveDataInfo(params.direccion, params.telefono, params.photo, params.email);
    }


    public static class Params {
        private String photo;
        private String direccion;
        private String telefono;
        private String email;

        public Params(String direccion, String telefono, String photo, String email) {
            this.direccion = direccion;
            this.telefono = telefono;
            this.photo = photo;
            this.email = email;
        }

        public static Params datos(String direccion, String telefono, String photo, String email) {
            return new Params(direccion, telefono, photo, email);
        }
    }

}
