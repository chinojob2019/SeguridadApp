package pe.com.distriluz.data.repository.datasource.apps;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import pe.com.distriluz.data.net.apps.model.AppsResponse;
import pe.com.distriluz.data.net.apps.model.PreguntasResponse;
import pe.com.distriluz.data.net.auth.model.ParametrosResponse;
import pe.com.distriluz.domain.model.App;
import pe.com.distriluz.domain.model.Apps;
import pe.com.distriluz.domain.model.Parametros;
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
        List<App.DesplieguesItem> listaDespliegue = new ArrayList<>();
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
        result.setEsapplanzamiento( item.getEsapplanzamiento());
        result.setId(item.getId());
        result.setBrowserDefault("");
        result.setKey(item.getKey());

        for(AppsResponse.DesplieguesItem itemDespliegue : item.getDespliegues()){
            listaDespliegue.add(mapperDespliegue(itemDespliegue));
        }
        result.setDespliegues(listaDespliegue);

        return result;
    }

    public List<Preguntasfrecuentes> mapperQuestions(PreguntasResponse items) {
        List<Preguntasfrecuentes> result = new ArrayList<>();
        for(PreguntasResponse.PreguntasFrecuentesItem item : items.getPreguntasFrecuentes()){
            result.add(mapper(item));
        }
        return result;
    }






    public App.DesplieguesItem mapperDespliegue(AppsResponse.DesplieguesItem itemDes){
        return new App.DesplieguesItem(itemDes.getUrlEmpresa(), itemDes.getNombreEmpresa());
    }


    private Preguntasfrecuentes mapper(PreguntasResponse.PreguntasFrecuentesItem item) {
        List<Preguntasfrecuentes.RespuestasItem> respuestas = new ArrayList<>();
        for(PreguntasResponse.RespuestasItem resp : item.getRespuestas()){
            Preguntasfrecuentes.RespuestasItem itemRespuesta = new Preguntasfrecuentes.RespuestasItem();
            itemRespuesta.setIdEstado(resp.getIdEstado());
            itemRespuesta.setIdRespuesta(resp.getIdRespuesta());
            itemRespuesta.setOrden(resp.getOrden());
            itemRespuesta.setRespuesta(resp.getRespuesta());
        respuestas.add(itemRespuesta);
        }


        return new Preguntasfrecuentes(item.getIdEstado(), respuestas,item.getOrden(),item.getIdPregunta(), item.getPregunta());
    }
}
