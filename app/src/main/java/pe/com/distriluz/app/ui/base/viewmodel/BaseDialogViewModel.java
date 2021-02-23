package pe.com.distriluz.app.ui.base.viewmodel;

import android.content.Context;

import pe.com.distriluz.app.injection.qualifier.AppContext;
import pe.com.distriluz.app.ui.base.navigator.DialogNavigator;
import pe.com.distriluz.app.ui.base.view.MvvmView;

public abstract class BaseDialogViewModel<V extends MvvmView> extends BaseAppViewModel<V> implements IViewModel<V> {

    protected final Context con;
    protected final DialogNavigator navigator;

    public BaseDialogViewModel(@AppContext Context context, DialogNavigator navigator) {
        super(context, navigator);
        this.con = context.getApplicationContext();
        this.navigator = navigator;
    }

    protected void toast(String mensaje) {
        toast(con, mensaje);
    }
}
