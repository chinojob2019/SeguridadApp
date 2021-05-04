package pe.com.distriluz.app.ui.base.navigator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import pe.com.distriluz.app.R;
import pe.com.distriluz.app.ui.appslista.AppListaFragment;
import pe.com.distriluz.app.ui.appslista.recyclerView.AppsItemAdapter;
import pe.com.distriluz.app.ui.base.BaseActivity;
import pe.com.distriluz.app.ui.clientelistar.ClienteListarActivity;
import pe.com.distriluz.app.utils.PlainConsumer;


public class ChildFragmentNavigator extends ActivityNavigator implements FragmentNavigator {

    private final Fragment fragment;

    public ChildFragmentNavigator(Fragment fragment) {
        super((BaseActivity) fragment.getActivity());
        this.fragment = fragment;
    }

    @Override
    public final void replaceChildFragment(@IdRes int containerId, @NonNull Fragment fragment, Bundle args) {
        replaceFragmentInternal(this.fragment.getChildFragmentManager(), containerId, fragment, null, args, false, null);
    }

    @Override
    public final void replaceChildFragment(@IdRes int containerId, @NonNull Fragment fragment, @NonNull String fragmentTag, Bundle args) {
        replaceFragmentInternal(this.fragment.getChildFragmentManager(), containerId, fragment, fragmentTag, args, false, null);
    }

    @Override
    public final void replaceChildFragmentAndAddToBackStack(@IdRes int containerId, @NonNull Fragment fragment, Bundle args, String backstackTag) {
        replaceFragmentInternal(this.fragment.getChildFragmentManager(), containerId, fragment, null, args, true, backstackTag);
    }

    @Override
    public final void replaceChildFragmentAndAddToBackStack(@IdRes int containerId, @NonNull Fragment fragment, @NonNull String fragmentTag, Bundle args, String backstackTag) {
        replaceFragmentInternal(this.fragment.getChildFragmentManager(), containerId, fragment, fragmentTag, args, true, backstackTag);
    }

    @Override
    public void startActivityForResultFromFragment(@NonNull Class<? extends Activity> activityClass, int arg, int requestCode) {
        startActivityInternal(activityClass, intent -> intent.putExtra(EXTRA_ARG, arg), requestCode);
    }

    @Override
    public void startActivityForResultFromFragment(@NonNull Class<? extends Activity> activityClass, int orden, int idpregunta, String descripcion, int idestado, int requestCode) {
        startActivityInternal(activityClass, intent -> {
            intent.putExtra(EXTRA_ORDEN_ARG, orden);
            intent.putExtra(EXTRA_IDPREGUNTA_ARG, idpregunta);
            intent.putExtra(EXTRA_DESCRIPCION_ARG, descripcion);
            intent.putExtra(EXTRA_IDESTADO_ARG, idestado);
        }, requestCode);
    }

    private void startActivityInternal(Class<? extends Activity> activityClass, PlainConsumer<Intent> setArgsAction, Integer requestCode) {
        Intent intent = new Intent(fragment.getContext(), activityClass);
        if (setArgsAction != null) {
            setArgsAction.accept(intent);
        }

        if (requestCode != null) {
            fragment.startActivityForResult(intent, requestCode);
        } else {
            fragment.startActivity(intent);
        }
    }

    @Override
    public void startDialog(DialogFragment dialog) {
        FragmentManager fm = fragment.getFragmentManager();
        dialog.setStyle(DialogFragment.STYLE_NORMAL, R.style.AppTheme_alert);
        dialog.show(fm, dialog.getClass().getName());
    }


    @Override
    public void reloadListApp() {
        if(fragment instanceof AppListaFragment) {
            ((AppListaFragment)fragment).reloadListApps();
        }
    }
}
