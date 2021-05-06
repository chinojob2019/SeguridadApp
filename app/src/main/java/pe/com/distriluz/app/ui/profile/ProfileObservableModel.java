package pe.com.distriluz.app.ui.profile;


import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import pe.com.distriluz.app.ApplicationContext;
import pe.com.distriluz.data.utiles.Utils;

/**
 * Created by pedro.zevallos on 9/07/2017.
 */

public class ProfileObservableModel extends BaseObservable {


    @Bindable
    public String getNombre() {
        return Utils.getfirstname(ApplicationContext.getInstance());
    }


    @Bindable
    public String getLogin() {
        return Utils.getInfo(ApplicationContext.getInstance()).getPersonales().getLogin();
    }

    @Bindable
    public String getFechanacimiento() {
        return Utils.getInfo(ApplicationContext.getInstance()).getPersonales().getFechanacimiento();
    }

    @Bindable
    public String getFoto() {
        return Utils.getInfo(ApplicationContext.getInstance()).getPersonales() .getFoto();
    }

    @Bindable
    public String getEmail() {
        return Utils.getInfo(ApplicationContext.getInstance()).getPersonales().getEmail();
    }

    @Bindable
    public String getDireccion() {
        return Utils.getInfo(ApplicationContext.getInstance()).getPersonales().getDireccion();
    }

    @Bindable
    public String getTelefono() {
        return Utils.getInfo(ApplicationContext.getInstance()).getPersonales().getTelefono();
    }

    @Bindable
    public String getEmpresa() {
        return Utils.getInfo(ApplicationContext.getInstance()).getCorporativos().getEmpresa();
    }

    @Bindable
    public String getTipousuario() {
        return Utils.getInfo(ApplicationContext.getInstance()).getCorporativos().getTipousuario();
    }

    @Bindable
    public String getUnidadnegocio() {
        return Utils.getInfo(ApplicationContext.getInstance()).getCorporativos().getUnidadnegocio();
    }

    @Bindable
    public String getTipopersona() {
        return Utils.getInfo(ApplicationContext.getInstance()).getPersonales().getTipopersona();
    }
}
