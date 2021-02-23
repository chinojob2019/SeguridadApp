package pe.com.distriluz.app.ui.base.navigator;


import android.app.Activity;

import androidx.annotation.NonNull;

public interface DialogNavigator extends Navigator {

    void dismiss();
    void startActivityForResultFromDialog(@NonNull Class<? extends Activity> activityClass, int arg, int requestCode);
}
