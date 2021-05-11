package pe.com.distriluz.app.ui.restorepassword;


import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import pe.com.distriluz.app.BR;

/**
 * Created by pedro.zevallos on 9/07/2017.
 */

public class RestorePasswordObservableModel extends BaseObservable {

    private String pass = "";
    private String pass2 = "";

    public RestorePasswordObservableModel(String pass,String pass2) {
        this.pass = pass;
        this.pass2 = pass2;
    }

    @Bindable
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
        notifyPropertyChanged(pe.com.distriluz.app.BR.pass);
        notifyPropertyChanged(pe.com.distriluz.app.BR.errorPass);
        notifyPropertyChanged(pe.com.distriluz.app.BR.enableButtom);
    }
    @Bindable
    public String getPass2() {
        return pass2;
    }

    public void setPass2(String pass2) {
        this.pass2 = pass2;
        notifyPropertyChanged(pe.com.distriluz.app.BR.pass2);
        notifyPropertyChanged(pe.com.distriluz.app.BR.errorPass2);
        notifyPropertyChanged(pe.com.distriluz.app.BR.enableButtom);
    }
    @Bindable
    public String getErrorPass() {
        if (!pass.isEmpty() && pass.length()<10)
            return "    La contraseña debe tener 10 caracteres como mínimo";
        else
            return null;
    }
    @Bindable
    public String getErrorPass2() {
        if (!pass2.isEmpty() && pass2.length()<10)
            return "    La contraseña debe tener 10 caracteres como mínimo";
        if (!pass.equals(pass2))
            return "    Las contraseñas ingresadas no coinciden";
        else
            return null;
    }

    @Bindable
    public Boolean getEnableButtom() {
        return !getPass().isEmpty() && getErrorPass()== null && !getPass2().isEmpty()&&getErrorPass2()==null && getPass().trim().equals(getPass2().trim());
    }
}
