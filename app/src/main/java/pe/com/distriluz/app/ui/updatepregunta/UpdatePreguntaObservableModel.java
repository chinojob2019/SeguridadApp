package pe.com.distriluz.app.ui.updatepregunta;


import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;


public class UpdatePreguntaObservableModel extends BaseObservable {

    private String descripcion;
    private String orden ;
    private int idEstado;
    private boolean rememberMe;
    private String estadoDescripcion;
    private int idPregunta;

    public UpdatePreguntaObservableModel(String descripcion, String orden, int idEstado, boolean rememberMe, String estadoDescripcion, int idPregunta) {
        this.descripcion = descripcion;
        this.orden = orden;
        this.idEstado = idEstado;
        this.rememberMe= rememberMe;
        this.estadoDescripcion= estadoDescripcion;
        this.idPregunta= idPregunta;

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
    public String getEstadoDescripcion() {
        return estadoDescripcion;
    }

    public void setEstadoDescripcion(String estadoDescripcion) {
        this.estadoDescripcion = estadoDescripcion;
        notifyPropertyChanged(pe.com.distriluz.app.BR.estadoDescripcion);
    }

    @Bindable
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        notifyPropertyChanged(pe.com.distriluz.app.BR.descripcion);
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
