package pe.com.distriluz.app.ui.changepassword;


import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

/**
 * Created by pedro.zevallos on 9/07/2017.
 */

public class ChangePasswordObservableModel extends BaseObservable {

    private String email;

    public ChangePasswordObservableModel(String email) {
        this.email = email;
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(pe.com.distriluz.app.BR.email);
        notifyPropertyChanged(pe.com.distriluz.app.BR.enabled);
        notifyPropertyChanged(pe.com.distriluz.app.BR.errorEmail);
    }

    @Bindable
    public String getErrorEmail() {
        if (!email.isEmpty() && !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
            return "    ingrese un Correo valido";
        else
            return null;
    }

    @Bindable
    public Boolean getEnabled() {
        return !getEmail().isEmpty() && getErrorEmail()== null;
    }
}
