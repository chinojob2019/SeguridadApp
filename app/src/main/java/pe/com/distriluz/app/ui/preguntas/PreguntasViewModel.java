package pe.com.distriluz.app.ui.preguntas;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.observers.DisposableSingleObserver;
import pe.com.distriluz.app.R;
import pe.com.distriluz.app.injection.scopes.PerFragment;
import pe.com.distriluz.app.ui.addpregunta.AddPreguntaActivity;
import pe.com.distriluz.app.ui.base.navigator.FragmentNavigator;
import pe.com.distriluz.app.ui.base.viewmodel.BaseFragmentViewModel;
import pe.com.distriluz.app.ui.respuestas.RespuestasFragment;
import pe.com.distriluz.domain.interactor.GetPreguntasCase;
import pe.com.distriluz.domain.interactor.SaveInfoUserUseCase;
import pe.com.distriluz.domain.interactor.UpdateMasivoPreguntasUseCase;
import pe.com.distriluz.domain.interactor.baseinteractors.DefaultObserverSingle;
import pe.com.distriluz.domain.model.Preguntasfrecuentes;


@PerFragment
public class PreguntasViewModel extends BaseFragmentViewModel<PreguntasMvvm.View> implements PreguntasMvvm, PreguntasMvvm.ViewModel {

    private final GetPreguntasCase getPreguntasCase;
    private final UpdateMasivoPreguntasUseCase updateMasivoPreguntasUseCase;
    private final PreguntasMapper mapper;
    private Resources res;
    private PreguntasObservableModel model = new PreguntasObservableModel();

    @Inject
    public PreguntasViewModel(
            Context context,
            FragmentNavigator navigator,
            UpdateMasivoPreguntasUseCase updateMasivoPreguntasUseCase, Resources res,
            GetPreguntasCase getPreguntasCase,
            PreguntasMapper mapper
    ) {
        super(context, navigator);
        this.updateMasivoPreguntasUseCase = updateMasivoPreguntasUseCase;
        this.res = res;
        this.getPreguntasCase = getPreguntasCase;
        this.mapper = mapper;
    }

    @Override
    public void attachView(View mvvmView, @Nullable Bundle savedInstanceState) {
        super.attachView(mvvmView, savedInstanceState);
        showLoading();
        getPreguntasCase.execute(new DefaultObserverSingle<List<Preguntasfrecuentes>>() {
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
    public void onClickListadoRespuestas(PreguntasObservableModel.PreguntasfrecuentesObservable item) {





        navigator.replaceFragment(R.id.box_fragment, new RespuestasFragment(),null);
     //   navigator.startActivityForResultFromFragment(AddPreguntaActivity.class, 0, 666);
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
    public void onClickBackEditar(android.view.View view) {
        getModel().setEditar(0);

        for (int i = 0; i < getModel().getPreguntas().size(); i++) {
            getModel().getPreguntas().get(i).setEditarItem(0);
        }


        notifyChange();
        getView().changeGlobal();

    }

    @Override
    public void onClickMasivoActivar(android.view.View view) {
        showLoading();
        List<Integer> integerList = new ArrayList<>();

        for (int i = 0; i < getModel().getPreguntas().size(); i++) {
            if (getModel().getPreguntas().get(i).getSeleccionado()) {
                integerList.add(getModel().getPreguntas().get(i).getIdPregunta());
            }

        }
        if (integerList.size() > 0) {
            this.updateMasivoPreguntasUseCase.execute(new DisposableSingleObserver<Boolean>() {
                @Override
                public void onSuccess(Boolean aBoolean) {

                    model = new PreguntasObservableModel();
                    getPreguntasCase.execute(new DefaultObserverSingle<List<Preguntasfrecuentes>>() {
                        @Override
                        public void onSuccess(List<Preguntasfrecuentes> preguntasfrecuentes) {
                            hideLoading();
                            mapper.mapperPreguntas(model, preguntasfrecuentes);

                            getModel().setEditar(0);
                            for (int i = 0; i < getModel().getPreguntas().size(); i++) {
                                getModel().getPreguntas().get(i).setEditarItem(0);
                            }

                            notifyChange();
                            getView().changeGlobal();
                            getView().habilitarbotones(true);
                        }

                        @Override
                        public void onError(Throwable e) {
                            hideLoading();
                            validateErrorToken(e);
                            toast(e.getMessage());
                            showError(e);
                            getView().habilitarbotones(true);
                        }
                    }, null);
                    toast("Tus cambios se han guardado.");
                }

                @Override
                public void onError(Throwable e) {
                    hideLoading();
                    validateErrorToken(e);
                    showError(e);
                }
            }, UpdateMasivoPreguntasUseCase.Params.datos(1, 1, integerList));
        } else {
            toast("Seleccione al menos una pregunta");
        }
    }

    @Override
    public void onClickMasivoEliminar(android.view.View view) {
        getView().habilitarbotones(false);
        showLoading();
        List<Integer> integerList = new ArrayList<>();

        for (int i = 0; i < getModel().getPreguntas().size(); i++) {
            if (getModel().getPreguntas().get(i).getSeleccionado()) {
                integerList.add(getModel().getPreguntas().get(i).getIdPregunta());
            }

        }
        if (integerList.size() > 0) {
            this.updateMasivoPreguntasUseCase.execute(new DisposableSingleObserver<Boolean>() {
                @Override
                public void onSuccess(Boolean aBoolean) {

                    model = new PreguntasObservableModel();
                    getPreguntasCase.execute(new DefaultObserverSingle<List<Preguntasfrecuentes>>() {
                        @Override
                        public void onSuccess(List<Preguntasfrecuentes> preguntasfrecuentes) {
                            hideLoading();
                            mapper.mapperPreguntas(model, preguntasfrecuentes);

                            getModel().setEditar(0);
                            for (int i = 0; i < getModel().getPreguntas().size(); i++) {
                                getModel().getPreguntas().get(i).setEditarItem(0);
                            }

                            notifyChange();
                            getView().changeGlobal();
                            getView().habilitarbotones(true);
                        }

                        @Override
                        public void onError(Throwable e) {
                            hideLoading();
                            validateErrorToken(e);
                            toast(e.getMessage());
                            showError(e);
                            getView().habilitarbotones(true);
                        }
                    }, null);
                    toast("Tus cambios se han guardado.");

                }

                @Override
                public void onError(Throwable e) {
                    hideLoading();
                    validateErrorToken(e);
                    showError(e);
                    getView().habilitarbotones(true);
                }
            }, UpdateMasivoPreguntasUseCase.Params.datos(1, 0, integerList));
        } else {
            toast("Seleccione al menos una pregunta");
            getView().habilitarbotones(true);
        }
    }

    @Override
    public void onClickIrListadoRespuestas() {
        navigator.replaceFragment(R.id.box_fragment, new RespuestasFragment(),null);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == AddPreguntaActivity.REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            // this.model = new ProfileObservableModel();
            showLoading();
            this.model= new PreguntasObservableModel();
            getPreguntasCase.execute(new DefaultObserverSingle<List<Preguntasfrecuentes>>() {
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
