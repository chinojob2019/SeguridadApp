package pe.com.distriluz.app.ui.updaterespuesta;


import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;


public class UpdateRespuestaObservableModel extends BaseObservable {

    private String respuesta;
    private String pregunta;
    private String orden ;
    private int idEstado;
    private boolean rememberMe;
    private String estadoDescripcion;
    private int idRespuesta;
    private int idPregunta;

    public UpdateRespuestaObservableModel(String respuesta, String pregunta, String orden, int idEstado, boolean rememberMe, String estadoDescripcion, int idRespuesta,int idPregunta) {
        this.respuesta = respuesta;
        this.pregunta=pregunta;
        this.orden = orden;
        this.idEstado = idEstado;
        this.rememberMe= rememberMe;
        this.estadoDescripcion= estadoDescripcion;
        this.idRespuesta= idRespuesta;
        this.idPregunta=idPregunta;

    }


    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
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

    @Bindable
    public int getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(int idRespuesta) {
        this.idRespuesta = idRespuesta;
        notifyPropertyChanged(pe.com.distriluz.app.BR.idRespuesta);
    }

    @Bindable
    public String getEstadoDescripcion() {
        return estadoDescripcion;
    }

    public void setEstadoDescripcion(String estadoDescripcion) {
        this.estadoDescripcion = estadoDescripcion;
        notifyPropertyChanged(pe.com.distriluz.app.BR.estadoDescripcion);
    }


    @Bindable
    public String getOrden() {
        return  orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
        notifyPropertyChanged(pe.com.distriluz.app.BR.orden);
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
    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean value) {

        if (this.rememberMe != value) {

            if(this.rememberMe){
setIdEstado(1);

            }else{
setIdEstado(0);

            }
            this.rememberMe = rememberMe;

            // React to the change.
            //saveData();

            // Notify observers of a new value.
            notifyPropertyChanged(pe.com.distriluz.app.BR.rememberMe);
        }




    }
}
