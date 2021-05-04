package pe.com.distriluz.data.net.apps.model;

import java.util.ArrayList;
import java.util.List;

public class ItemPreguntaResponse {


    private int idPregunta;
    private int idEstado;
    private int orden = 0;
    private List<RespuestasItem> respuestas = new ArrayList<>();
    private String pregunta = "";
    private int editarItem=0;
    private String cantidadSeleccionada="";

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

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

    public List<RespuestasItem> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<RespuestasItem> respuestas) {
        this.respuestas = respuestas;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public int getEditarItem() {
        return editarItem;
    }

    public void setEditarItem(int editarItem) {
        this.editarItem = editarItem;
    }

    public String getCantidadSeleccionada() {
        return cantidadSeleccionada;
    }

    public void setCantidadSeleccionada(String cantidadSeleccionada) {
        this.cantidadSeleccionada = cantidadSeleccionada;
    }

    public static class RespuestasItem {

        private int idEstado;
        private int orden;
        private String respuesta;
        private int idRespuesta;
        private int editarItem=0;
        private Boolean seleccionado=false;

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

        public int getEditarItem() {
            return editarItem;
        }

        public void setEditarItem(int editarItem) {
            this.editarItem = editarItem;
        }

        public Boolean getSeleccionado() {
            return seleccionado;
        }

        public void setSeleccionado(Boolean seleccionado) {
            this.seleccionado = seleccionado;
        }
    }


}
