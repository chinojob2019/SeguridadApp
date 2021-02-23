package pe.com.distriluz.app.ui.preguntas;


import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

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

        for(Preguntasfrecuentes item : items){
            model.getPreguntas().add(mapper(item));
        }
        model.notifyChange();
    }

    private PreguntasObservableModel.PreguntasfrecuentesObservable mapper(Preguntasfrecuentes item) {
        PreguntasObservableModel.PreguntasfrecuentesObservable result = new PreguntasObservableModel.PreguntasfrecuentesObservable();
        result.setOrden(item.getOrden());
        result.setPregunta(item.getPregunta());
        result.setRespuesta(item.getRespuesta());
        return result;
    }
}
