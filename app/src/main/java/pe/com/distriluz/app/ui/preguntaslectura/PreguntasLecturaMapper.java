package pe.com.distriluz.app.ui.preguntaslectura;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import pe.com.distriluz.domain.model.Preguntasfrecuentes;

/**
 * domain layer.
 */
@Singleton
public class PreguntasLecturaMapper {

    @Inject
    public PreguntasLecturaMapper() {
    }

    public void mapperPreguntas(PreguntasLecturaObservableModel model, List<Preguntasfrecuentes> items) {

        Collections.sort(items, new Comparator<Preguntasfrecuentes>() {
            @Override
            public int compare(Preguntasfrecuentes p1, Preguntasfrecuentes p2) {
                // Aqui esta el truco, ahora comparamos p2 con p1 y no al reves como antes
                return new Integer(p1.getOrden()).compareTo(new Integer(p2.getOrden()));
            }
        });


        for (Preguntasfrecuentes item : items) {
            if (item.getIdEstado() == 1) {
                model.getPreguntas().add(mapper(item));
            }
        }
        model.notifyChange();
    }

    private PreguntasLecturaObservableModel.PreguntasfrecuentesObservable mapper(Preguntasfrecuentes item) {
        PreguntasLecturaObservableModel.PreguntasfrecuentesObservable result = new PreguntasLecturaObservableModel.PreguntasfrecuentesObservable();
        result.setOrden(item.getOrden());
        result.setPregunta(item.getPregunta());
        result.setIdEstado(item.getIdEstado());
        result.setIdPregunta(item.getIdPregunta());

        List<PreguntasLecturaObservableModel.PreguntasfrecuentesObservable.RespuestasItem> respuestas = new ArrayList<>();

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
            if (resp.getIdEstado() == 1) {
                PreguntasLecturaObservableModel.PreguntasfrecuentesObservable.RespuestasItem itemRespuesta = new PreguntasLecturaObservableModel.PreguntasfrecuentesObservable.RespuestasItem();
                itemRespuesta.setIdEstado(resp.getIdEstado());
                itemRespuesta.setIdRespuesta(resp.getIdRespuesta());
                itemRespuesta.setOrden(resp.getOrden());
                itemRespuesta.setRespuesta(resp.getRespuesta());
                respuestas.add(itemRespuesta);
            }
        }
        result.setRespuestas(respuestas);
        return result;
    }
}
