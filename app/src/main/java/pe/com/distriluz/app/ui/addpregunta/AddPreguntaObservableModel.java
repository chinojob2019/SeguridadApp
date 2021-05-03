package pe.com.distriluz.app.ui.addpregunta;


import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import java.io.File;


public class AddPreguntaObservableModel extends BaseObservable {

    private String descripcion;
    private String orden ;
    private int idEstado;
    private boolean rememberMe;
    private String estadoDescripcion;

    public AddPreguntaObservableModel(String descripcion, String orden, int idEstado, boolean rememberMe, String estadoDescripcion) {
        this.descripcion = descripcion;
        this.orden = orden;
        this.idEstado = idEstado;
        this.rememberMe= rememberMe;
        this.estadoDescripcion= estadoDescripcion;
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
