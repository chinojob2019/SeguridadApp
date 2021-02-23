package pe.com.distriluz.app.ui.login;


import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

/**
 * Created by pedro.zevallos on 9/07/2017.
 */

public class LoginObservableModel extends BaseObservable {
    private String user;
    private String pass;


    public LoginObservableModel(String pass, String user) {
        this.pass = pass;
        this.user = user;
    }

    @Bindable
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
        notifyPropertyChanged(pe.com.distriluz.app.BR.errorPass);
        notifyPropertyChanged(pe.com.distriluz.app.BR.pass);
        notifyPropertyChanged(pe.com.distriluz.app.BR.enableButtom);
    }

    @Bindable
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
        notifyPropertyChanged(pe.com.distriluz.app.BR.errorUser);
        notifyPropertyChanged(pe.com.distriluz.app.BR.user);
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
    public String getErrorUser() {
        if (!user.isEmpty() && user.length()<5)
            return "    El Usuario debe tener 5 caracteres como mínimo";
         else
            return null;
    }


    @Bindable
    public Boolean getEnableButtom() {
        return !getUser().isEmpty() && getErrorUser()== null && !getPass().isEmpty() && getErrorPass()== null  ;
    }
}
