package pe.com.distriluz.app.ui.codeconfirm;


import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

/**
 * Created by pedro.zevallos on 9/07/2017.
 */

public class CodeConfirmObservableModel extends BaseObservable {
    private String email;

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CodeConfirmObservableModel(String email) {
        this.email = email;
       
    }


}
