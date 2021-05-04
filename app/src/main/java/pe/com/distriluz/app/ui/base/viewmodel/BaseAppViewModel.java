package pe.com.distriluz.app.ui.base.viewmodel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ObservableBoolean;
import androidx.fragment.app.DialogFragment;

import pe.com.distriluz.app.ApplicationContext;
import pe.com.distriluz.app.R;
import pe.com.distriluz.app.injection.qualifier.AppContext;
import pe.com.distriluz.app.ui.alerts.AlertEmailErrorDialog;
import pe.com.distriluz.app.ui.base.navigator.Navigator;
import pe.com.distriluz.app.ui.base.view.MvvmView;
import pe.com.distriluz.data.exception.TokenException;


public abstract class BaseAppViewModel<V extends MvvmView> extends BaseViewModel<V> implements IViewModel<V> {


    protected final Context ctx;
    protected final Navigator navigator;
    protected  ObservableBoolean loaded;

    public BaseAppViewModel(@AppContext Context context, Navigator navigator) {
        this.ctx = context.getApplicationContext();
        this.navigator = navigator;
        this.loaded = new ObservableBoolean(false);
    }

    @Override
    protected void toast(Context con, String mensaje) {
        LayoutInflater inflater = navigator.getActivity().getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast,
                navigator.getActivity().findViewById(R.id.toast_layout_root));

        TextView text = layout.findViewById(R.id.text);
        text.setText(mensaje);

        Toast toast = new Toast(con);
//                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
//        super.toast(ctx, mensaje);
    }

    @Override
    public ObservableBoolean isLoaded() {
        return loaded;
    }

    protected void showLoading() {
        loaded.set(true);
    }

    protected void hideLoading() {
        loaded.set(false);
    }

    protected void showError(String title,String mensaje, String textButtom) {
        navigator.startDialog(new AlertEmailErrorDialog(title, mensaje, textButtom, this, null));
    }
    protected void showError(Throwable  e) {

        navigator.startDialog(new AlertEmailErrorDialog(ApplicationContext.getRes().getString(R.string.dialog_error_title),
                e.getMessage(),
                ApplicationContext.getRes().getString(R.string.dialog_error_button_message), this, null));

    }

    @Override
    public void openDialog(DialogFragment dialog) {
        navigator.startDialog(dialog);
    }


    protected void validateErrorToken(Throwable e) {
        if(e instanceof TokenException){
            navigator.clearSession();
        }
    }

    @Override
    public void onClickItemMenu(Integer type) {

    }

    @Override
    public void openCamera() {

    }

    @Override
    public void openGallery() {

    }

    @Override
    public void closeAlertGeneric() {

    }

    @Override
    public void okAlertGeneric() {

    }
}
