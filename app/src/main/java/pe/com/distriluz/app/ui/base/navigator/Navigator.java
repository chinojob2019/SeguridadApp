package pe.com.distriluz.app.ui.base.navigator;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import java.io.Serializable;

import pe.com.distriluz.app.ui.base.BaseActivity;
import pe.com.distriluz.app.utils.PlainConsumer;


public interface Navigator {
    public static final String EXTRA_ARG = "_args";
    public static final String EXTRA_ARG_2 = "_args_2";
    public static final String EXTRA_ARG_3 = "_args_3";
    public static final String EXTRA_LAT_ARG = "_lat_args";
    public static final String EXTRA_LON_ARG = "_lon_args";
    public static final String EXTRA_ORDEN_ARG = "_orden_args";
    public static final String EXTRA_DESCRIPCION_ARG = "_descripcion_args";
    public static final String EXTRA_IDPREGUNTA_ARG = "_idpregunta_args";
    public static final String EXTRA_IDESTADO_ARG = "_idestado_args";




    View inflate(int resource, ViewGroup root);

    void requestPermissions(String[] permissions, int resultCode);

    int checkSelfPermission(@NonNull String permission);

    void setResult(int resultCode, Intent data);

    void startService(Intent service);

    void stopService(Intent service);

    void finishActivity();

    void startDialog(DialogFragment dialog);

    void startDialogFullScreen(DialogFragment dialog);

    void startActivity(@NonNull Intent intent);

    void startActivity(@NonNull String action);

    void startActivity(@NonNull String action, @NonNull Uri uri);

    void startActivity(@NonNull Class<? extends Activity> activityClass);

    void startActivity(@NonNull Class<? extends Activity> activityClass, @NonNull PlainConsumer<Intent> setArgsAction);

    void startActivity(@NonNull Class<? extends Activity> activityClass, Bundle args);

    void startActivity(@NonNull Class<? extends Activity> activityClass, Parcelable args);

    void startActivity(@NonNull Class<? extends Activity> activityClass, Serializable args);
    void startActivity(@NonNull Class<? extends Activity> activityClass, Serializable args, Serializable args2);
    void startActivity(@NonNull Class<? extends Activity> activityClass, Serializable args, Serializable args2, Serializable args3);

    void startActivity(@NonNull Class<? extends Activity> activityClass, @NonNull String arg);

    void startActivity(@NonNull Class<? extends Activity> activityClass, @NonNull Integer arg);

    void startActivity(@NonNull Class<? extends Activity> activityClass, @NonNull Integer arg, @NonNull Integer arg2);
    void startActivity(@NonNull Class<? extends Activity> activityClass, @NonNull Integer arg, @NonNull String arg2);

    void startActivity(@NonNull Class<? extends Activity> activityClass, int arg);

    void startActivityForResult(@NonNull Intent intent, int requestCode);

    void startActivityForResult(@NonNull Class<? extends Activity> activityClass, int requestCode);

    void startActivityForResult(@NonNull Class<? extends Activity> activityClass, @NonNull PlainConsumer<Intent> setArgsAction, int requestCode);

    void startActivityForResult(@NonNull Class<? extends Activity> activityClass, @NonNull Parcelable arg, int requestCode);

    void startActivityForResult(@NonNull Class<? extends Activity> activityClass, @NonNull String arg, int requestCode);

    void startActivityForResult(@NonNull Class<? extends Activity> activityClass, int arg, int requestCode);

    void startActivityForResult(@NonNull Class<? extends Activity> activityClass, int arg, Double lat, Double lon, int requestCode);

    void inflateFragment(@IdRes int containerId, Fragment fragment, Bundle args);

    void replaceFragment(@IdRes int containerId, @NonNull Fragment fragment, Bundle args);

    void replaceFragment(@IdRes int containerId, @NonNull Fragment fragment, @NonNull String fragmentTag, Bundle args);

    void replaceFragmentAndAddToBackStack(@IdRes int containerId, @NonNull Fragment fragment, Bundle args, String backstackTag);

    void replaceFragmentAndAddToBackStack(@IdRes int containerId, @NonNull Fragment fragment, @NonNull String fragmentTag, Bundle args, String backstackTag);

    boolean isFinishing();

    Intent getIntent();

    boolean isLoggin();

    BaseActivity getActivity();

    void clearSession();

    void removeSession();

    void hideKeyboard();

    void showKeyboard();

    void closeDrawer();

    void openDrawer();
}