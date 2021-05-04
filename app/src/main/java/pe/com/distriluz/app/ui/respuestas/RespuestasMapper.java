package pe.com.distriluz.app.ui.respuestas;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import pe.com.distriluz.app.ui.preguntas.PreguntasObservableModel;
import pe.com.distriluz.domain.model.Preguntasfrecuentes;

/**
 * domain layer.
 */
@Singleton
public class RespuestasMapper {

    @Inject
    public RespuestasMapper() {
    }








    public void mapperPreguntas(RespuestasObservableModel model, List<Preguntasfrecuentes> items, int filtro) {



        for (Preguntasfrecuentes item : items) {
            if(item.getIdPregunta()==filtro){

                model.setOrden(item.getOrden());
                model.setPregunta(item.getPregunta());
                model.setIdEstado(item.getIdEstado());
                model.setIdPregunta(item.getIdPregunta());
                List<RespuestasObservableModel.RespuestasItem> respuestas = new ArrayList<>();
                List<Preguntasfrecuentes.RespuestasItem> respuestasItemList = new ArrayList<>();
                respuestasItemList.addAll(item.getRespuestas());
                Collections.sort(respuestasItemList, new Comparator<Preguntasfrecuentes.RespuestasItem>() {
                    @Override
                    public int compare(Preguntasfrecuentes.RespuestasItem p1, Preguntasfrecuentes.RespuestasItem p2) {
                        // Aqui esta el truco, ahora comparamos p2 con p1 y no al reves como antes
                        return new Integer(p1.getOrden()).compareTo(new Integer(p2.getOrden()));
                    }
                });

                for (Preguntasfrecuentes.RespuestasItem resp : respuestasItemList) {
                    model.getRespuestas().add(mapper(resp));
                }
            }
        }
        model.notifyChange();
    }

    private RespuestasObservableModel.RespuestasItem mapper(Preguntasfrecuentes.RespuestasItem resp) {
        RespuestasObservableModel.RespuestasItem itemRespuesta = new RespuestasObservableModel.RespuestasItem();
        itemRespuesta.setIdEstado(resp.getIdEstado());
        itemRespuesta.setIdRespuesta(resp.getIdRespuesta());
        itemRespuesta.setOrden(resp.getOrden());
        itemRespuesta.setRespuesta(resp.getRespuesta());
        return itemRespuesta;
    }
}
