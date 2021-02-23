package pe.com.distriluz.data.repository.datasource.apps;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import pe.com.distriluz.data.net.apps.model.AppsResponse;
import pe.com.distriluz.data.net.apps.model.PreguntasResponse;
import pe.com.distriluz.domain.model.App;
import pe.com.distriluz.domain.model.Apps;
import pe.com.distriluz.domain.model.Preguntasfrecuentes;

/**
 * domain layer.
 */
@Singleton
public class AppsDataMapper {

    @Inject
    public AppsDataMapper() {
    }

    public Apps mapperApps(AppsResponse appsResponse) {
        Apps result= new Apps();
        List<App> destacados= new ArrayList<>();
        List<App> recurrente= new ArrayList<>();
        List<App> todos= new ArrayList<>();
        List<App> lanzamientos= new ArrayList<>();
        for(AppsResponse.Appitem item : appsResponse.getAplicaciones().getDestacados()){
            destacados.add(mapper(item));
        }
        for(AppsResponse.Appitem item : appsResponse.getAplicaciones().getRecurrentes()){
            recurrente.add(mapper(item));
        }
        for(AppsResponse.Appitem item : appsResponse.getAplicaciones().getTodos()){
            todos.add(mapper(item));
        }
        for(AppsResponse.Appitem item : appsResponse.getAplicaciones().getLanzamientos()){
            lanzamientos.add(mapper(item));
        }

        result.setDestacados(destacados);
        result.setLanzamientos(lanzamientos);
        result.setRecurrentes(recurrente);
        result.setTodos(todos);
        return result;
    }

    private App mapper(AppsResponse.Appitem item) {
        App result= new App();
        result.setDescripcion(item.getDescripcion());
        result.setTipo("");
        result.setCode(item.getCode());
        result.setNombreHost("");
        result.setDominio("");
        result.setVistaGeneral(item.getVistaGeneral());
        result.setIpAddress("");
        result.setDestacadas(item.getDestacadas());
        result.setNombre(item.getNombre());
        result.setVersion(0.0);
        result.setVistaUsuario(item.getVistaUsuario());
        result.setUrl(item.getUrl());
        result.setImagenUrl(item.getImagenUrl());
        result.setEsLanzador(item.getEsLanzador());
        result.setIdEstado(item.getIdEstado());
        result.setIdTipo(item.getIdTipo());
        result.setLanzamiento( item.getLanzamiento());
        result.setId(item.getId());
        result.setBrowserDefault("");
        result.setKey(item.getKey());
        return result;
    }

    public List<Preguntasfrecuentes> mapperQuestions(List<PreguntasResponse.PreguntasfrecuentesItem> items) {
        List<Preguntasfrecuentes> result = new ArrayList<>();
        for(PreguntasResponse.PreguntasfrecuentesItem item : items){
            result.add(mapper(item));
        }
        return result;
    }

    private Preguntasfrecuentes mapper(PreguntasResponse.PreguntasfrecuentesItem item) {
        return new Preguntasfrecuentes(item.getOrden(), item.getRespuesta(), item.getPregunta());
    }
}
