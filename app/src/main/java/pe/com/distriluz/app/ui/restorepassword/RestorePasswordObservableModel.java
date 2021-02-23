package pe.com.distriluz.app.ui.restorepassword;


import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import pe.com.distriluz.app.BR;

/**
 * Created by pedro.zevallos on 9/07/2017.
 */

public class RestorePasswordObservableModel extends BaseObservable {

    private String pass = "";

    public RestorePasswordObservableModel(String pass) {
        this.pass = pass;
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
    public String getErrorPass() {
        if (!pass.isEmpty() && pass.length()<8)
            return "    La contraseña debe tener 8 caracteres como mínimo";
        else
            return null;
    }

    @Bindable
    public Boolean getEnableButtom() {
        return !getPass().isEmpty() && getErrorPass()== null  ;
    }
}
