package pe.com.distriluz.app.ui.editprofile;


import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import java.io.File;

import pe.com.distriluz.app.BR;

/**
 * Created by pedro.zevallos on 9/07/2017.
 */

public class EditProfileObservableModel extends BaseObservable {
    private String direccion;
    private String telefono;
    private String foto;
    private File newFoto;

    public EditProfileObservableModel(String direccion, String telefono, String foto) {
        this.direccion = direccion;
        this.telefono = telefono;
        this.foto = foto;
    }

    @Bindable
    public File getNewFoto() {
        return newFoto;
    }

    public void setNewFoto(File newFoto) {
        this.newFoto = newFoto;
        notifyPropertyChanged(pe.com.distriluz.app.BR.newFoto);
    }

    @Bindable
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
        notifyPropertyChanged(pe.com.distriluz.app.BR.direccion);
    }

    @Bindable
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
        notifyPropertyChanged(pe.com.distriluz.app.BR.telefono);
    }

    @Bindable
    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
        notifyPropertyChanged(pe.com.distriluz.app.BR.foto);
    }
}
