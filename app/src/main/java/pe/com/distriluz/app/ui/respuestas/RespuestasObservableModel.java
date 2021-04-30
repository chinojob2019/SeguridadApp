package pe.com.distriluz.app.ui.respuestas;


import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;

import java.util.List;

import pe.com.distriluz.app.BR;



public class RespuestasObservableModel extends BaseObservable {


    private int idPregunta;
    private int idEstado;
    private int orden = 0;
    private ObservableList<RespuestasItem> respuestas = new ObservableArrayList<>();
    private String pregunta = "";
    private int editarItem=0;
    private String cantidadSeleccionada="";

    @Bindable
    public String getCantidadSeleccionada() {
        return cantidadSeleccionada;
    }

    public void setCantidadSeleccionada(String cantidadSeleccionada) {
        this.cantidadSeleccionada = cantidadSeleccionada;
        notifyPropertyChanged(pe.com.distriluz.app.BR.cantidadSeleccionada);
    }

    @Bindable
    public int getEditarItem() {
        return editarItem;
    }

    public void setEditarItem(int editarItem) {
        this.editarItem = editarItem;
        notifyPropertyChanged(pe.com.distriluz.app.BR.editarItem);
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
    public ObservableList<RespuestasItem> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(ObservableList<RespuestasItem> respuestas) {
        this.respuestas = respuestas;
        notifyPropertyChanged(pe.com.distriluz.app.BR.respuestas);
    }

    public static class RespuestasItem extends BaseObservable{

        private int idEstado;
        private int orden;
        private String respuesta;
        private int idRespuesta;
        private int editarItem=0;
        private Boolean seleccionado=false;

        @Bindable
        public int getIdEstado() {
            return idEstado;
        }

        public void setIdEstado(int idEstado) {
            this.idEstado = idEstado;
            notifyPropertyChanged(pe.com.distriluz.app.BR.idEstado);
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
        public int getIdRespuesta() {
            return idRespuesta;
        }

        public void setIdRespuesta(int idRespuesta) {
            this.idRespuesta = idRespuesta;
            notifyPropertyChanged(pe.com.distriluz.app.BR.idRespuesta);
        }
        @Bindable
        public int getEditarItem() {
            return editarItem;
        }

        public void setEditarItem(int editarItem) {
            this.editarItem = editarItem;
            notifyPropertyChanged(pe.com.distriluz.app.BR.editarItem);
        }
        @Bindable
        public Boolean getSeleccionado() {
            return seleccionado;
        }

        public void setSeleccionado(Boolean seleccionado) {
            this.seleccionado = seleccionado;
            notifyPropertyChanged(pe.com.distriluz.app.BR.seleccionado);
        }
    }





}
