package pe.com.distriluz.app.ui.base.navigator;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


public interface FragmentNavigator extends Navigator {

    void replaceChildFragment(@IdRes int containerId, @NonNull Fragment fragment, Bundle args);

    void replaceChildFragment(@IdRes int containerId, @NonNull Fragment fragment, @NonNull String fragmentTag, Bundle args);

    void replaceChildFragmentAndAddToBackStack(@IdRes int containerId, @NonNull Fragment fragment, Bundle args, String backstackTag);

    void replaceChildFragmentAndAddToBackStack(@IdRes int containerId, @NonNull Fragment fragment, @NonNull String fragmentTag, Bundle args, String backstackTag);

    void startActivityForResultFromFragment(@NonNull Class<? extends Activity> activityClass, int arg, int requestCode);

    void reloadListApp();
}