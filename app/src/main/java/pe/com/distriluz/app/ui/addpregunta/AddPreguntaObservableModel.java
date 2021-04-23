package pe.com.distriluz.app.ui.addpregunta;


import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import java.io.File;


public class AddPreguntaObservableModel extends BaseObservable {

    private String descripcion;
    private String orden ;
    private int idEstado;

    public AddPreguntaObservableModel(String descripcion, String orden, int idEstado) {
        this.descripcion = descripcion;
        this.orden = orden;
        this.idEstado = idEstado;
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

}
