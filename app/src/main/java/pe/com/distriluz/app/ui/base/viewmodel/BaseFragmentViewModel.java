package pe.com.distriluz.app.ui.base.viewmodel;

import android.content.Context;

import pe.com.distriluz.app.injection.qualifier.AppContext;
import pe.com.distriluz.app.ui.base.navigator.FragmentNavigator;
import pe.com.distriluz.app.ui.base.view.MvvmView;
import pe.com.distriluz.data.exception.TokenException;


public abstract class BaseFragmentViewModel<V extends MvvmView> extends BaseAppViewModel<V> implements IViewModel<V> {

    protected final Context con;
    protected final FragmentNavigator navigator;

    public BaseFragmentViewModel(@AppContext Context context, FragmentNavigator navigator) {
        super(context, navigator);
        this.con = context.getApplicationContext();
        this.navigator = navigator;
    }

    protected void toast(String mensaje) {
        toast(con, mensaje);
    }
}
