package pe.com.distriluz.app.ui.appslista;


import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import pe.com.distriluz.data.net.apps.model.AppsResponse;
import pe.com.distriluz.domain.model.App;
import pe.com.distriluz.domain.model.Apps;

/**
 * domain layer.
 */
@Singleton
public class AppsListaMapper {

    @Inject
    public AppsListaMapper() {
    }

    public void mapperApps(AppsObservableModel model, Apps apps) {
        ObservableList<AppsObservableModel.AppObservable> destacados= new ObservableArrayList<>();
        ObservableList<AppsObservableModel.AppObservable> recurrente= new ObservableArrayList<>();
        ObservableList<AppsObservableModel.AppObservable> todos= new ObservableArrayList<>();
        ObservableList<AppsObservableModel.AppObservable> lanzamientos= new ObservableArrayList<>();
        for(App item : apps.getDestacados()){
            destacados.add(mapper(item));
        }
        for(App item : apps.getRecurrentes()){
            recurrente.add(mapper(item));
        }
        for(App item : apps.getTodos()){
            todos.add(mapper(item));
        }
        for(App item : apps.getLanzamientos()){
            lanzamientos.add(mapper(item));
        }

        model.setDestacados(destacados);
        model.setLanzamientos(lanzamientos);
        model.setRecurrentes(recurrente);
        model.setTodos(todos);
        model.notifyChange();
    }


    private AppsObservableModel.AppObservable mapper(App item) {
        AppsObservableModel.AppObservable result= new AppsObservableModel.AppObservable();
        result.setDescripcion(item.getDescripcion());
        result.setTipo(item.getTipo());
        result.setCode(item.getCode());
        result.setNombreHost(item.getNombreHost());
        result.setDominio(item.getDominio());
        result.setVistaGeneral(item.getVistaGeneral());
        result.setIpAddress(item.getIpAddress());
        result.setDestacadas(item.getDestacadas());
        result.setNombre(item.getNombre());
        result.setVersion(item.getVersion());
        result.setVistaUsuario(item.getVistaUsuario());
        result.setUrl(item.getUrl());
        result.setImagenUrl(item.getImagenUrl());
        result.setEsLanzador(item.getEsLanzador());
        result.setIdEstado(item.getIdEstado());
        result.setIdTipo(item.getIdTipo());
        result.setEsapplanzamiento( item.getEsapplanzamiento());
        result.setId(item.getId());
        result.setBrowserDefault(item.getBrowserDefault());
        result.setKey(item.getKey());
        List<AppsObservableModel.DesplieguesApp> listaDespliegue = new ArrayList<>();
        for(App.DesplieguesItem itemDespliegue : item.getDespliegues()){
            listaDespliegue.add(mapperDespliegue(itemDespliegue));
        }
        result.setDespliegues(listaDespliegue);

        return result;
    }

    public AppsObservableModel.DesplieguesApp mapperDespliegue(App.DesplieguesItem itemDes){
        return new AppsObservableModel.DesplieguesApp(itemDes.getUrlEmpresa(), itemDes.getNombreEmpresa());
    }

}
