package pe.com.distriluz.domain.interactor;


import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import pe.com.distriluz.domain.executor.PostExecutionThread;
import pe.com.distriluz.domain.executor.ThreadExecutor;
import pe.com.distriluz.domain.interactor.baseinteractors.UseCaseSingle;
import pe.com.distriluz.domain.repository.AppsRepository;


public class UpdateMasivoPreguntasUseCase extends UseCaseSingle<Boolean, UpdateMasivoPreguntasUseCase.Params> {

    private AppsRepository repository;

    @Inject
    public UpdateMasivoPreguntasUseCase(AppsRepository repository, ThreadExecutor threadExecutor,
                                        PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.repository = repository;
    }

    @Override
    public Single<Boolean> buildUseCase(Params params) {
        return repository.updateMasivoPreguntas(params.tipo, params.idEstado, params.data);
    }

    public static class Params {
       private  int tipo;
       private int idEstado ;
      private List<Integer> data;



        public Params(int tipo, int idEstado  ,  List<Integer> data) {
            this.tipo = tipo;
            this.idEstado = idEstado;
            this.data = data;
        }

        public static Params datos(int tipo, int idEstado  ,  List<Integer> data) {
            return new Params(tipo, idEstado, data);
        }
    }

}
