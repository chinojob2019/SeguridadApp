package pe.com.distriluz.app.ui.respuestas;

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
import pe.com.distriluz.app.ui.addrepuesta.AddRespuestaActivity;
import pe.com.distriluz.app.ui.base.navigator.FragmentNavigator;
import pe.com.distriluz.app.ui.base.viewmodel.BaseFragmentViewModel;
import pe.com.distriluz.app.ui.preguntas.PreguntasFragment;
import pe.com.distriluz.app.ui.respuestas.RespuestasMapper;
import pe.com.distriluz.app.ui.respuestas.RespuestasMvvm;
import pe.com.distriluz.app.ui.respuestas.RespuestasObservableModel;

import pe.com.distriluz.app.ui.updatepregunta.UpdatePreguntaActivity;
import pe.com.distriluz.app.ui.updaterespuesta.UpdateRespuestaActivity;
import pe.com.distriluz.data.net.apps.model.ItemPreguntaResponse;
import pe.com.distriluz.data.utiles.Utils;
import pe.com.distriluz.domain.interactor.GetPreguntasCase;

import pe.com.distriluz.domain.interactor.UpdateMasivoPreguntasUseCase;

import pe.com.distriluz.domain.interactor.baseinteractors.DefaultObserverSingle;
import pe.com.distriluz.domain.model.Preguntasfrecuentes;



@PerFragment
public class RespuestasViewModel extends BaseFragmentViewModel<RespuestasMvvm.View> implements RespuestasMvvm, RespuestasMvvm.ViewModel {

    private final GetPreguntasCase getRespuestasCase;
    private final UpdateMasivoPreguntasUseCase updateMasivoRespuestasUseCase;
    private final RespuestasMapper mapper;
    private Resources res;
    private RespuestasObservableModel model = new RespuestasObservableModel();

    @Inject
    public RespuestasViewModel(
            Context context,
            FragmentNavigator navigator,
            UpdateMasivoPreguntasUseCase updateMasivoRespuestasUseCase, Resources res,
            GetPreguntasCase getRespuestasCase,
            RespuestasMapper mapper
    ) {
        super(context, navigator);
        this.updateMasivoRespuestasUseCase = updateMasivoRespuestasUseCase;
        this.res = res;
        this.getRespuestasCase = getRespuestasCase;
        this.mapper = mapper;
    }

    @Override
    public void attachView(View mvvmView, @Nullable Bundle savedInstanceState) {
        super.attachView(mvvmView, savedInstanceState);
       model.setEditarItem(0);
       model.setOrden( Utils.getPRegunta(con).getOrden());
        model.setPregunta(Utils.getPRegunta(con).getPregunta());
        model.setIdEstado(Utils.getPRegunta(con).getIdEstado());
        model.setIdPregunta(Utils.getPRegunta(con).getIdPregunta());
        for (ItemPreguntaResponse.RespuestasItem resp : Utils.getPRegunta(con).getRespuestas()) {
            RespuestasObservableModel.RespuestasItem item= new RespuestasObservableModel.RespuestasItem();
            item.setRespuesta(resp.getRespuesta());
            item.setOrden(resp.getOrden());
            item.setIdRespuesta(resp.getIdRespuesta());
            item.setIdEstado(resp.getIdEstado());
            item.setEditarItem(resp.getEditarItem());
            model.getRespuestas().add(item);
        }
        model.notifyChange();

       // showLoading();
       /* getRespuestasCase.execute(new DefaultObserverSingle<List<Preguntasfrecuentes>>() {
            @Override
            public void onSuccess(List<Preguntasfrecuentes> Respuestasfrecuentes) {
                hideLoading();
               // mapper.mapperPreguntas(model, Respuestasfrecuentes);

            }

            @Override
            public void onError(Throwable e) {
                hideLoading();
                validateErrorToken(e);
                toast(e.getMessage());
                showError(e);
            }
        }, null);*/
    }

    @Override
    public RespuestasObservableModel getModel() {
        return model;
    }

    @Override
    public void onClickListadoRespuestas(RespuestasObservableModel.RespuestasItem item) {
        navigator.startActivityForResultFromFragment(AddRespuestaActivity.class, 0, 666);
    }

    @Override
    public void onClickOpenDrawer(android.view.View view) {
        navigator.replaceFragment(R.id.box_fragment, new PreguntasFragment(),null);
    }

    @Override
    public void onClickBackFragment() {
        navigator.replaceFragment(R.id.box_fragment, new PreguntasFragment(),null);


    }

    @Override
    public void onClickAddRespuesta(android.view.View view) {

        int orden_maximo=0;
     for(RespuestasObservableModel.RespuestasItem item: model.getRespuestas())  {
         if(item.getOrden()>orden_maximo){

             orden_maximo=item.getOrden();

         }


     }

     orden_maximo=orden_maximo+1;

        navigator.startActivityForResultFromFragment(AddRespuestaActivity.class, orden_maximo,model.getIdPregunta(), model.getPregunta(),model.getIdEstado(), AddRespuestaActivity.REQUEST_CODE);
    }

    @Override
    public void onClickBackEditar(android.view.View view) {
        getModel().setEditarItem(0);

        for (int i = 0; i < getModel().getRespuestas().size(); i++) {
            getModel().getRespuestas().get(i).setEditarItem(0);
        }

        notifyChange();
        getView().changeGlobal();

    }




    @Override
    public void onClickMasivoActivar(android.view.View view) {
        getView().habilitarbotones(false);
        showLoading();
        List<Integer> integerList = new ArrayList<>();

        for (int i = 0; i < getModel().getRespuestas().size(); i++) {
            if (getModel().getRespuestas().get(i).getSeleccionado()) {
                integerList.add(getModel().getRespuestas().get(i).getIdRespuesta());
            }

        }
        if (integerList.size() > 0) {
            this.updateMasivoRespuestasUseCase.execute(new DisposableSingleObserver<Boolean>() {
                @Override
                public void onSuccess(Boolean aBoolean) {
                    int idpregunta=model.getIdPregunta();
                    model = new RespuestasObservableModel();
                    getRespuestasCase.execute(new DefaultObserverSingle<List<Preguntasfrecuentes>>() {
                        @Override
                        public void onSuccess(List<Preguntasfrecuentes> Respuestasfrecuentes) {
                            hideLoading();
                            mapper.mapperPreguntas(model,Respuestasfrecuentes,idpregunta);

                            getModel().setEditarItem(0);
                            for (int i = 0; i < getModel().getRespuestas().size(); i++) {
                                getModel().getRespuestas().get(i).setEditarItem(0);
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
            }, UpdateMasivoPreguntasUseCase.Params.datos(2, 1, integerList));
        } else {
            toast("Seleccione al menos una Respuesta");
            getView().habilitarbotones(true);
        }
    }

    @Override
    public void onClickMasivoEliminar(android.view.View view) {
        getView().habilitarbotones(false);
        showLoading();
        List<Integer> integerList = new ArrayList<>();

        for (int i = 0; i < getModel().getRespuestas().size(); i++) {
            if (getModel().getRespuestas().get(i).getSeleccionado()) {
                integerList.add(getModel().getRespuestas().get(i).getIdRespuesta());
            }

        }
        if (integerList.size() > 0) {
            this.updateMasivoRespuestasUseCase.execute(new DisposableSingleObserver<Boolean>() {
                @Override
                public void onSuccess(Boolean aBoolean) {
int idpregunta=model.getIdPregunta();
                    model = new RespuestasObservableModel();
                    getRespuestasCase.execute(new DefaultObserverSingle<List<Preguntasfrecuentes>>() {
                        @Override
                        public void onSuccess(List<Preguntasfrecuentes> Respuestasfrecuentes) {
                            hideLoading();
                            mapper.mapperPreguntas(model,Respuestasfrecuentes,idpregunta);

                            getModel().setEditarItem(0);
                            for (int i = 0; i < getModel().getRespuestas().size(); i++) {
                                getModel().getRespuestas().get(i).setEditarItem(0);
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
            }, UpdateMasivoPreguntasUseCase.Params.datos(2, 0, integerList));
       } else {
            toast("Seleccione al menos una Respuesta");
            getView().habilitarbotones(true);
        }
    }

    @Override
    public void onClickEditarPregunta(android.view.View view) {
        navigator.startActivityForResultFromFragment(UpdatePreguntaActivity.class, this.model.getOrden(),this.model.getIdPregunta(),this.model.getPregunta(),this.model.getIdEstado(),  UpdatePreguntaActivity.REQUEST_CODE);
    }

    @Override
    public void onClickEditarRespuesta(RespuestasObservableModel.RespuestasItem item) {
        navigator.startActivityForResultFromFragment(UpdateRespuestaActivity.class, item.getOrden(),this.model.getIdPregunta(),item.getIdRespuesta() ,model.getPregunta(),item.getRespuesta(),item.getIdEstado(),  UpdateRespuestaActivity.REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == UpdatePreguntaActivity.REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            // this.model = new ProfileObservableModel();
           model.setPregunta(data.getStringExtra("pregunta"));
            // showLoading();
            //this.model= new RespuestasObservableModel();
            /*
            getRespuestasCase.execute(new DefaultObserverSingle<List<Respuestasfrecuentes>>() {
                @Override
                public void onSuccess(List<Respuestasfrecuentes> Respuestasfrecuentes) {
                    hideLoading();
                    mapper.mapperRespuestas(model, Respuestasfrecuentes);
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
*/
            notifyChange();
            getView().changeGlobal();
        }
        if (requestCode == AddRespuestaActivity.REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            // this.model = new ProfileObservableModel();
        //    model.setPregunta(data.getStringExtra("pregunta"));
            // showLoading();

            int idpreguntaL= this.model.getIdPregunta();
            this.model= new RespuestasObservableModel();
            getRespuestasCase.execute(new DefaultObserverSingle<List<Preguntasfrecuentes>>() {
                @Override
                public void onSuccess(List<Preguntasfrecuentes> Preguntasfrecuentes) {
                    hideLoading();
                    mapper.mapperPreguntas(model, Preguntasfrecuentes,idpreguntaL);
                    notifyChange();
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
