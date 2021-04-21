package pe.com.distriluz.app.ui.preguntas;


import java.util.ArrayList;
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
        for (Preguntasfrecuentes.RespuestasItem resp : item.getRespuestas()) {
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
