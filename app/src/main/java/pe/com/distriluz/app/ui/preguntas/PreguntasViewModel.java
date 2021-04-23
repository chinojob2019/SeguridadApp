package pe.com.distriluz.app.ui.preguntas;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.List;

import javax.inject.Inject;

import pe.com.distriluz.app.injection.scopes.PerFragment;
import pe.com.distriluz.app.ui.addpregunta.AddPreguntaActivity;
import pe.com.distriluz.app.ui.base.navigator.FragmentNavigator;
import pe.com.distriluz.app.ui.base.viewmodel.BaseFragmentViewModel;
import pe.com.distriluz.app.ui.editprofile.EditProfileActivity;
import pe.com.distriluz.app.ui.profile.ProfileObservableModel;
import pe.com.distriluz.domain.interactor.GetPreguntasCase;
import pe.com.distriluz.domain.interactor.baseinteractors.DefaultObserverSingle;
import pe.com.distriluz.domain.model.Preguntasfrecuentes;


@PerFragment
public class PreguntasViewModel extends BaseFragmentViewModel<PreguntasMvvm.View> implements PreguntasMvvm, PreguntasMvvm.ViewModel {

    private final GetPreguntasCase getPreguntasCase;
    private final PreguntasMapper mapper;
    private Resources res;
    private PreguntasObservableModel model = new PreguntasObservableModel();

    @Inject
    public PreguntasViewModel(
            Context context,
            FragmentNavigator navigator,
            Resources res,
            GetPreguntasCase getPreguntasCase,
            PreguntasMapper mapper
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
                validateErrorToken(e);
                toast(e.getMessage());
                showError(e);
            }
        }, null);
    }

    @Override
    public PreguntasObservableModel getModel() {
        return model;
    }

    @Override
    public void onClickOpenDrawer(android.view.View view) {
        navigator.openDrawer();
    }

    @Override
    public void onClickAddPregunta(android.view.View view) {
        navigator.startActivityForResultFromFragment(AddPreguntaActivity.class, 0, AddPreguntaActivity.REQUEST_CODE);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == AddPreguntaActivity.REQUEST_CODE && resultCode == Activity.RESULT_OK){
           // this.model = new ProfileObservableModel();
            showLoading();
            getPreguntasCase.execute(new DefaultObserverSingle<List<Preguntasfrecuentes>>(){
                @Override
                public void onSuccess(List<Preguntasfrecuentes> preguntasfrecuentes) {
                    hideLoading();
                    mapper.mapperPreguntas(model, preguntasfrecuentes);
                    getView().changeGlobal();
                }

                @Override
                public void onError(Throwable e) {
                    hideLoading();
                    validateErrorToken(e);
                    toast(e.getMessage());
                    showError(e);
                }
            }, null);

            notifyChange();
            getView().changeGlobal();
        }
    }


}
