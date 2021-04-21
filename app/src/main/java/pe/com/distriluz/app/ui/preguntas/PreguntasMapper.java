package pe.com.distriluz.app.ui.preguntas;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import pe.com.distriluz.data.net.apps.model.PreguntasResponse;
import pe.com.distriluz.domain.model.Preguntasfrecuentes;

/**
 * domain layer.
 */
@Singleton
public class PreguntasMapper {

    @Inject
    public PreguntasMapper() {
    }

    public void mapperPreguntas(PreguntasObservableModel model, List<Preguntasfrecuentes> items) {

        Collections.sort(items, new Comparator<Preguntasfrecuentes>() {
            @Override
            public int compare(Preguntasfrecuentes p1, Preguntasfrecuentes p2) {
                // Aqui esta el truco, ahora comparamos p2 con p1 y no al reves como antes
                return new Integer(p1.getOrden()).compareTo(new Integer(p2.getOrden()));
            }
        });




        for (Preguntasfrecuentes item : items) {
            model.getPreguntas().add(mapper(item));
        }
        model.notifyChange();
    }

    private PreguntasObservableModel.PreguntasfrecuentesObservable mapper(Preguntasfrecuentes item) {
        PreguntasObservableModel.PreguntasfrecuentesObservable result = new PreguntasObservableModel.PreguntasfrecuentesObservable();
        result.setOrden(item.getOrden());
        result.setPregunta(item.getPregunta());
        result.setIdEstado(item.getIdEstado());
        result.setIdPregunta(item.getIdPregunta());

        List<PreguntasObservableModel.PreguntasfrecuentesObservable.RespuestasItem> respuestas = new ArrayList<>();

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
            PreguntasObservableModel.PreguntasfrecuentesObservable.RespuestasItem itemRespuesta = new PreguntasObservableModel.PreguntasfrecuentesObservable.RespuestasItem();
            itemRespuesta.setIdEstado(resp.getIdEstado());
            itemRespuesta.setIdRespuesta(resp.getIdRespuesta());
            itemRespuesta.setOrden(resp.getOrden());
            itemRespuesta.setRespuesta(resp.getRespuesta());
            respuestas.add(itemRespuesta);
        }
        result.setRespuestas(respuestas);
        return result;
    }
}
