package pe.com.distriluz.app.ui.base.navigator;

import android.app.Activity;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import pe.com.distriluz.app.ui.base.BaseActivity;
import pe.com.distriluz.app.utils.PlainConsumer;

public class DialogFragmentNavigator extends ActivityNavigator implements DialogNavigator {

    private final DialogFragment dialogFragment;

    public DialogFragmentNavigator(DialogFragment dialogFragment) {
        super((BaseActivity)dialogFragment.getActivity());
        this.dialogFragment = dialogFragment;
    }

    @Override
    public void dismiss() {
        dialogFragment.dismissAllowingStateLoss();
    }

    @Override
    public void startActivityForResultFromDialog(@NonNull Class<? extends Activity> activityClass, int arg, int requestCode) {
        startActivityInternal(activityClass, intent -> intent.putExtra(EXTRA_ARG, arg), requestCode);
    }

    private void startActivityInternal(Class<? extends Activity> activityClass, PlainConsumer<Intent> setArgsAction, Integer requestCode) {
        Intent intent = new Intent(dialogFragment.getContext(), activityClass);
        if (setArgsAction != null) {
            setArgsAction.accept(intent);
        }

        if (requestCode != null) {
            dialogFragment.startActivityForResult(intent, requestCode);
        } else {
            dialogFragment.startActivity(intent);
        }
    }
}
