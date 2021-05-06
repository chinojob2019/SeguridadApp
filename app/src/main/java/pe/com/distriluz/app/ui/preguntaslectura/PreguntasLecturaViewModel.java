package pe.com.distriluz.app.ui.preguntaslectura;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.Nullable;

import java.util.List;

import javax.inject.Inject;

import pe.com.distriluz.app.injection.scopes.PerFragment;
import pe.com.distriluz.app.ui.base.navigator.FragmentNavigator;
import pe.com.distriluz.app.ui.base.viewmodel.BaseFragmentViewModel;
import pe.com.distriluz.domain.interactor.GetPreguntasCase;
import pe.com.distriluz.domain.interactor.baseinteractors.DefaultObserverSingle;
import pe.com.distriluz.domain.model.Preguntasfrecuentes;


@PerFragment
public class PreguntasLecturaViewModel extends BaseFragmentViewModel<PreguntasLecturaMvvm.View> implements PreguntasLecturaMvvm, PreguntasLecturaMvvm.ViewModel {

    private final GetPreguntasCase getPreguntasCase;
    private final PreguntasLecturaMapper mapper;
    private Resources res;
    private PreguntasLecturaObservableModel model = new PreguntasLecturaObservableModel();

    @Inject
    public PreguntasLecturaViewModel(
            Context context,
            FragmentNavigator navigator,
            Resources res,
            GetPreguntasCase getPreguntasCase,
            PreguntasLecturaMapper mapper
    ) {
        super(context,navigator);
        this.res = res;
        this.getPreguntasCase = getPreguntasCase;
        this.mapper = mapper;
    }

    @Override
    public void attachView(View mvvmView, @Nullable Bundle savedInstanceState) {
        super.attachView(mvvmView, savedInstanceState);
        showLoading();
        getPreguntasCase.execute(new DefaultObserverSingle<List<Preguntasfrecuentes>>(){
            @Override
            public void onSuccess(List<Preguntasfrecuentes> preguntasfrecuentes) {
                hideLoading();
                mapper.mapperPreguntas(model, preguntasfrecuentes);
            }

            @Override
            public void onError(Throwable e) {
                hideLoading();
                if(! validateErrorToken(e)){
                    showError(e);

                }

            }
        }, null);
    }

    @Override
    public PreguntasLecturaObservableModel getModel() {
        return model;
    }

    @Override
    public void onClickOpenDrawer(android.view.View view) {
        navigator.openDrawer();
    }

}
