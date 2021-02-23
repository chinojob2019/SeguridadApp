package pe.com.distriluz.app.ui.validatecode;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import pe.com.distriluz.app.BR;

/**
 * Created by pedro.zevallos on 9/07/2017.
 */

public class ValidateCodeObservableModel extends BaseObservable {
    private String codigo1;
    private String codigo2;
    private String codigo3;
    private String codigo4;

    @Bindable
    public String getCodigo() {
        return codigo1 + codigo2 + codigo3 + codigo4;
    }
    @Bindable
    public String getCodigo1() {
        return codigo1;
    }

    public void setCodigo1(String codigo1) {
        this.codigo1 = codigo1;
        notifyPropertyChanged(pe.com.distriluz.app.BR.codigo1);
    }

    @Bindable
    public String getCodigo2() {
        return codigo2;
    }

    public void setCodigo2(String codigo2) {
        this.codigo2 = codigo2;
        notifyPropertyChanged(pe.com.distriluz.app.BR.codigo2);
    }

    @Bindable
    public String getCodigo3() {
        return codigo3;
    }

    public void setCodigo3(String codigo3) {
        this.codigo3 = codigo3;
        notifyPropertyChanged(pe.com.distriluz.app.BR.codigo3);
    }

    @Bindable
    public String getCodigo4() {
        return codigo4;
    }

    public void setCodigo4(String codigo4) {
        this.codigo4 = codigo4;
        notifyPropertyChanged(pe.com.distriluz.app.BR.codigo4);
    }
}
