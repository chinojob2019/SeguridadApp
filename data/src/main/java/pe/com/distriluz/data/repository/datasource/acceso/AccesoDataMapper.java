package pe.com.distriluz.data.repository.datasource.acceso;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import pe.com.distriluz.data.net.acceso.model.OpcionesMenuResponse;
import pe.com.distriluz.data.net.apps.model.AppsResponse;
import pe.com.distriluz.data.net.apps.model.PreguntasResponse;
import pe.com.distriluz.domain.model.App;
import pe.com.distriluz.domain.model.Apps;
import pe.com.distriluz.domain.model.OpcionesMenu;
import pe.com.distriluz.domain.model.Preguntasfrecuentes;

/**
 * domain layer.
 */
@Singleton
public class AccesoDataMapper {

    @Inject
    public AccesoDataMapper() {
    }
    public OpcionesMenu mapperOpcionesMenu(OpcionesMenuResponse appsResponse) {
        OpcionesMenu result= new OpcionesMenu();
    List<OpcionesMenu.OpcionesMenuItem> listaOpciones = new ArrayList<>();
    for(OpcionesMenuResponse.OpcionesMenuItem item : appsResponse.getOpcionesMenu()){
        listaOpciones.add(mapperOpcion(item));
    }
        result.setOpcionesMenu(listaOpciones);
        return result;
    }

    private OpcionesMenu.OpcionesMenuItem mapperOpcion(OpcionesMenuResponse.OpcionesMenuItem item){

        OpcionesMenu.Vista vista= new OpcionesMenu.Vista();
        vista.setClase(item.getVista().getClase());
        vista.setComando(item.getVista().getComando());
        vista.setDescripcion(item.getVista().getDescripcion());
        vista.setEnsamblado(item.getVista().getEnsamblado());
        vista.setId(item.getVista().getId());
        vista.setIdEstado(item.getVista().getIdEstado());
        vista.setNombre(item.getVista().getNombre());
        vista.setUrl(item.getVista().getUrl());

        OpcionesMenu.OpcionesMenuItem opcionesMenu= new OpcionesMenu.OpcionesMenuItem();
        opcionesMenu.setDescripcion(item.getDescripcion());
        opcionesMenu.setDescripcionTipoOpcion(item.getDescripcionTipoOpcion());
        opcionesMenu.setId(item.getId());
        opcionesMenu.setIdAplicacion(item.getIdAplicacion());
        opcionesMenu.setIdEstado(item.getIdEstado());
        opcionesMenu.setIdOpcionMenuPadre(item.getIdOpcionMenuPadre());
        opcionesMenu.setIdVista(item.getIdVista());
        opcionesMenu.setImagen(item.getImagen());
        opcionesMenu.setNivel(item.getNivel());
        opcionesMenu.setNombre(item.getNombre());
        opcionesMenu.setOrden(item.getOrden());
        opcionesMenu.setTipoOpcion(item.getTipoOpcion());
        opcionesMenu.setUrl(item.getUrl());
        opcionesMenu.setVista(vista);
        return opcionesMenu;
    }





}
