package pe.com.distriluz.app.ui.preguntas;


import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;

import java.util.List;

import pe.com.distriluz.app.ApplicationContext;
import pe.com.distriluz.app.BR;
import pe.com.distriluz.data.net.apps.model.PreguntasResponse;
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
        private int idPregunta;
        private int idEstado;
        private int orden = 0;
        private List<RespuestasItem> respuestas;
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
        public String getPregunta() {
            return pregunta;
        }

        public void setPregunta(String pregunta) {
            this.pregunta = pregunta;
            notifyPropertyChanged(pe.com.distriluz.app.BR.pregunta);
        }
        @Bindable
        public int getIdPregunta() {
            return idPregunta;
        }

        public void setIdPregunta(int idPregunta) {
            this.idPregunta = idPregunta;
            notifyPropertyChanged(pe.com.distriluz.app.BR.idPregunta);
        }
        @Bindable
        public int getIdEstado() {
            return idEstado;
        }

        public void setIdEstado(int idEstado) {
            this.idEstado = idEstado;
            notifyPropertyChanged(pe.com.distriluz.app.BR.idEstado);
        }
        @Bindable
        public List<RespuestasItem> getRespuestas() {
            return respuestas;
        }

        public void setRespuestas(List<RespuestasItem> respuestas) {
            this.respuestas = respuestas;
            notifyPropertyChanged(pe.com.distriluz.app.BR.respuestas);
        }

        public static class RespuestasItem{

            private int idEstado;
            private int orden;
            private String respuesta;
            private int idRespuesta;

            public int getIdEstado() {
                return idEstado;
            }

            public void setIdEstado(int idEstado) {
                this.idEstado = idEstado;
            }

            public int getOrden() {
                return orden;
            }

            public void setOrden(int orden) {
                this.orden = orden;
            }

            public String getRespuesta() {
                return respuesta;
            }

            public void setRespuesta(String respuesta) {
                this.respuesta = respuesta;
            }

            public int getIdRespuesta() {
                return idRespuesta;
            }

            public void setIdRespuesta(int idRespuesta) {
                this.idRespuesta = idRespuesta;
            }
        }





    }

}
