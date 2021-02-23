package pe.com.distriluz.app.ui.preguntas;


import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;

import pe.com.distriluz.app.ApplicationContext;
import pe.com.distriluz.app.BR;
import pe.com.distriluz.data.utiles.Utils;

/**
 * Created by pedro.zevallos on 9/07/2017.
 */

public class PreguntasObservableModel extends BaseObservable {

    private ObservableList<PreguntasfrecuentesObservable> preguntas = new ObservableArrayList<>();

    @Bindable
    public ObservableList<PreguntasfrecuentesObservable> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(ObservableList<PreguntasfrecuentesObservable> preguntas) {
        this.preguntas = preguntas;
        notifyPropertyChanged(pe.com.distriluz.app.BR.preguntas);
    }

    public static class PreguntasfrecuentesObservable extends BaseObservable{

        private int orden = 0;
        private String respuesta = "";
        private String pregunta = "";
        private Boolean open = false;

        @Bindable
        public Boolean getOpen() {
            return open;
        }

        public void setOpen(Boolean open) {
            this.open = open;
            notifyPropertyChanged(pe.com.distriluz.app.BR.open);
        }

        @Bindable
        public int getOrden() {
            return orden;
        }

        public void setOrden(int orden) {
            this.orden = orden;
            notifyPropertyChanged(pe.com.distriluz.app.BR.orden);
        }

        @Bindable
        public String getRespuesta() {
            return respuesta;
        }

        public void setRespuesta(String respuesta) {
            this.respuesta = respuesta;
            notifyPropertyChanged(pe.com.distriluz.app.BR.respuesta);
        }

        @Bindable
        public String getPregunta() {
            return pregunta;
        }

        public void setPregunta(String pregunta) {
            this.pregunta = pregunta;
            notifyPropertyChanged(pe.com.distriluz.app.BR.pregunta);
        }
    }

}
