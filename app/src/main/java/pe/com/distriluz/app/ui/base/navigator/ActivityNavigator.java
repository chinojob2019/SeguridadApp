package pe.com.distriluz.app.ui.base.navigator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.io.Serializable;

import javax.inject.Inject;

import pe.com.distriluz.app.R;
import pe.com.distriluz.app.injection.scopes.PerActivity;
import pe.com.distriluz.app.ui.base.BaseActivity;

import pe.com.distriluz.app.ui.clientelistar.ClienteListarActivity;
import pe.com.distriluz.app.ui.login.LoginActivity;
import pe.com.distriluz.app.utils.PlainConsumer;
import pe.com.distriluz.data.utiles.Constantes;
import pe.com.distriluz.data.utiles.Utils;

@PerActivity
public class ActivityNavigator implements Navigator {

    protected final BaseActivity activity;

    @Inject
    public ActivityNavigator(BaseActivity activity) {
        this.activity = activity;
    }

    @Override
    public View inflate(int resource, ViewGroup root) {
        return activity.getLayoutInflater().inflate(resource, root);
    }

    @Override
    public void requestPermissions(String[] permissions, int resultCode) {
        ActivityCompat.requestPermissions(activity, permissions, resultCode);
    }

    @Override
    public int checkSelfPermission(@NonNull String permission) {
        return ContextCompat.checkSelfPermission(activity, permission);
    }

    @Override
    public void setResult(int resultCode, Intent data) {
        activity.setResult(resultCode, data);
    }

    @Override
    public void startService(Intent service) {
        activity.startService(service);
    }

    @Override
    public void stopService(Intent service) {
        activity.stopService(service);
    }

    @Override
    public void startDialog(DialogFragment dialog) {
        FragmentManager fm = activity.getSupportFragmentManager();
        dialog.setStyle(DialogFragment.STYLE_NORMAL, R.style.AppTheme_alert);
        dialog.show(fm, dialog.getClass().getName());
    }
    @Override
    public void startDialogFullScreen(DialogFragment dialog) {
        FragmentManager fm = activity.getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.add(android.R.id.content, dialog, "FullScreenFragment")
        .addToBackStack("Nuevo Pedido").commit();

    }

    @Override
    public void finishActivity() {
        activity.finish();
    }

    @Override
    public final void startActivity(@NonNull Intent intent) {
        activity.startActivity(intent);
    }

    @Override
    public final void startActivity(@NonNull String action) {
        activity.startActivity(new Intent(action));
    }

    @Override
    public final void startActivity(@NonNull String action, @NonNull Uri uri) {
        activity.startActivity(new Intent(action, uri));
    }

    @Override
    public final void startActivity(@NonNull Class<? extends Activity> activityClass) {
        startActivityInternal(activityClass, null, null);
    }

    @Override
    public void startActivity(@NonNull Class<? extends Activity> activityClass, @NonNull PlainConsumer<Intent> setArgsAction) {
        startActivityInternal(activityClass, setArgsAction, null);
    }

    @Override
    public void startActivity(@NonNull Class<? extends Activity> activityClass, Bundle args) {
        startActivityInternal(activityClass, intent -> intent.putExtra(EXTRA_ARG, args), null);
    }

    @Override
    public final void startActivity(@NonNull Class<? extends Activity> activityClass, @NonNull Parcelable arg) {
        startActivityInternal(activityClass, intent -> intent.putExtra(EXTRA_ARG, arg), null);
    }

    @Override
    public void startActivity(@NonNull Class<? extends Activity> activityClass, Serializable arg) {
        startActivityInternal(activityClass, intent -> intent.putExtra(EXTRA_ARG, arg), null);
    }

    @Override
    public void startActivity(@NonNull Class<? extends Activity> activityClass, Serializable args, Serializable args2) {
        startActivityInternal(activityClass, intent -> {
            intent.putExtra(EXTRA_ARG, args);
            intent.putExtra(EXTRA_ARG_2, args2);
            }, null);
    }

    @Override
    public void startActivity(@NonNull Class<? extends Activity> activityClass, Serializable args, Serializable args2, Serializable args3) {
        startActivityInternal(activityClass, intent -> {
            intent.putExtra(EXTRA_ARG, args);
            intent.putExtra(EXTRA_ARG_2, args2);
            intent.putExtra(EXTRA_ARG_3, args3);
        },null);
    }

    @Override
    public final void startActivity(@NonNull Class<? extends Activity> activityClass, @NonNull String arg) {
        startActivityInternal(activityClass, intent -> intent.putExtra(EXTRA_ARG, arg), null);
    }

    @Override
    public void startActivity(@NonNull Class<? extends Activity> activityClass, @NonNull Integer arg) {
        startActivityInternal(activityClass, intent -> intent.putExtra(EXTRA_ARG, arg), null);
    }

    @Override
    public void startActivity(@NonNull Class<? extends Activity> activityClass, @NonNull Integer arg, @NonNull Integer arg2) {
        startActivityInternal(activityClass, intent -> {
            intent.putExtra(EXTRA_ARG, arg);
            intent.putExtra(EXTRA_ARG_2, arg2);
        }, null);
    }
    @Override
    public void startActivity(@NonNull Class<? extends Activity> activityClass, @NonNull Integer arg, @NonNull String arg2) {
        startActivityInternal(activityClass, intent -> {
            intent.putExtra(EXTRA_ARG, arg);
            intent.putExtra(EXTRA_ARG_2, arg2);
        }, null);
    }

    @Override
    public final void startActivity(@NonNull Class<? extends Activity> activityClass, int arg) {
        startActivityInternal(activityClass, intent -> intent.putExtra(EXTRA_ARG, arg), null);
    }

    @Override
    public void startActivityForResult(@NonNull Intent intent, int requestCode) {
        activity.startActivityForResult(intent, requestCode);
    }

    @Override
    public final void startActivityForResult(@NonNull Class<? extends Activity> activityClass, int requestCode) {
        startActivityInternal(activityClass, null, requestCode);
    }

    @Override
    public void startActivityForResult(@NonNull Class<? extends Activity> activityClass, @NonNull PlainConsumer<Intent> setArgsAction, int requestCode) {
        startActivityInternal(activityClass, setArgsAction, requestCode);
    }

    @Override
    public final void startActivityForResult(@NonNull Class<? extends Activity> activityClass, @NonNull Parcelable arg, int requestCode) {
        startActivityInternal(activityClass, intent -> intent.putExtra(EXTRA_ARG, arg), requestCode);
    }

    @Override
    public final void startActivityForResult(@NonNull Class<? extends Activity> activityClass, @NonNull String arg, int requestCode) {
        startActivityInternal(activityClass, intent -> intent.putExtra(EXTRA_ARG, arg), requestCode);
    }

    @Override
    public final void startActivityForResult(@NonNull Class<? extends Activity> activityClass, int arg, int requestCode) {
        startActivityInternal(activityClass, intent -> intent.putExtra(EXTRA_ARG, arg), requestCode);
    }

    @Override
    public void startActivityForResult(@NonNull Class<? extends Activity> activityClass, int arg, Double lat, Double lon, int requestCode) {
        startActivityInternal(activityClass, intent -> {
            intent.putExtra(EXTRA_ARG, arg);
            intent.putExtra(EXTRA_LAT_ARG, lat);
            intent.putExtra(EXTRA_LON_ARG, lon);
        },requestCode);
    }

    private void startActivityInternal(Class<? extends Activity> activityClass, PlainConsumer<Intent> setArgsAction, Integer requestCode) {
            Intent intent = new Intent(activity, activityClass);
            if (setArgsAction != null) {
                setArgsAction.accept(intent);
            }

            if (requestCode != null) {
                activity.startActivityForResult(intent, requestCode);
            } else {
                activity.startActivity(intent);
            }
    }

    @Override
    public final void inflateFragment(@IdRes int containerId, Fragment fragment, Bundle args) {
        clearAndAddFragmentInternal(activity.getSupportFragmentManager(), containerId, fragment, null, args, false, null);
    }

    protected final void clearAndAddFragmentInternal(FragmentManager fm, @IdRes int containerId, Fragment fragment, String fragmentTag, Bundle args, boolean addToBackstack, String backstackTag) {
        if (args != null) {
            fragment.setArguments(args);
        }
        ((LinearLayout)activity.findViewById(containerId)).removeAllViews();
        FragmentTransaction ft = fm.beginTransaction().add(containerId, fragment, fragmentTag);
        if (addToBackstack) {
            ft.addToBackStack(backstackTag).commit();
            fm.executePendingTransactions();
        } else {
            ft.commitNow();
        }
    }

    @Override
    public final void replaceFragment(@IdRes int containerId, Fragment fragment, Bundle args) {
        replaceFragmentInternal(activity.getSupportFragmentManager(), containerId, fragment, null, args, false, null);
    }

    @Override
    public final void replaceFragment(@IdRes int containerId, @NonNull Fragment fragment, @NonNull String fragmentTag, Bundle args) {
        replaceFragmentInternal(activity.getSupportFragmentManager(), containerId, fragment, fragmentTag, args, false, null);
    }

    @Override
    public final void replaceFragmentAndAddToBackStack(@IdRes int containerId, Fragment fragment, Bundle args, String backstackTag) {
        replaceFragmentInternal(activity.getSupportFragmentManager(), containerId, fragment, null, args, true, backstackTag);
    }

    @Override
    public final void replaceFragmentAndAddToBackStack(@IdRes int containerId, @NonNull Fragment fragment, @NonNull String fragmentTag, Bundle args, String backstackTag) {
        replaceFragmentInternal(activity.getSupportFragmentManager(), containerId, fragment, fragmentTag, args, true, backstackTag);
    }

    @Override
    public boolean isFinishing() {
        return activity.isFinishing();
    }


    protected final void replaceFragmentInternal(FragmentManager fm, @IdRes int containerId, Fragment fragment, String fragmentTag, Bundle args, boolean addToBackstack, String backstackTag) {
        if (args != null) {
            fragment.setArguments(args);
        }
        FragmentTransaction ft = fm.beginTransaction().replace(containerId, fragment, fragmentTag);
        if (addToBackstack) {
            ft.addToBackStack(backstackTag).commit();
            fm.executePendingTransactions();
        } else {
            ft.commitNow();
        }
    }

    @Override
    public Intent getIntent() {
        return activity.getIntent();
    }

    @Override
    public boolean isLoggin() {
        return Utils.isLogin(activity);
    }

    @Override
    public BaseActivity getActivity() {
        return activity;
    }

    @Override
    public void clearSession() {
        removeSession();
        startActivity(LoginActivity.class);
        finishActivity();
    }
    @Override
    public void removeSession() {
        activity.getSharedPreferences(Constantes.PREFERENCES, Context.MODE_PRIVATE).edit().clear().apply();
    }

    @Override
    public void hideKeyboard() {
        activity.hideKeyboard();
    }

    @Override
    public void showKeyboard() {
        activity.showKeyboard();
    }

    @Override
    public void closeDrawer() {
        if(activity instanceof ClienteListarActivity) {
            ((ClienteListarActivity)activity).closeDrawer();
        }
    }
    @Override
    public void openDrawer() {
        if(activity instanceof ClienteListarActivity) {
            ((ClienteListarActivity)activity).openDrawer();
        }
    }
}










