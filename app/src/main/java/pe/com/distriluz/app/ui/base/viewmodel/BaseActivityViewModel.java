package pe.com.distriluz.app.ui.base.viewmodel;

import android.content.Context;

import pe.com.distriluz.app.injection.qualifier.AppContext;
import pe.com.distriluz.app.ui.base.navigator.Navigator;
import pe.com.distriluz.app.ui.base.view.MvvmView;


public abstract class BaseActivityViewModel<V extends MvvmView> extends BaseAppViewModel<V> implements IViewModel<V> {

    protected final Context con;
    protected final Navigator navigator;

    public BaseActivityViewModel(@AppContext Context context, Navigator navigator) {
        super(context, navigator);
        this.con = context.getApplicationContext();
        this.navigator = navigator;
    }

    protected void toast(String mensaje) {
        toast(con, mensaje);
    }



}
