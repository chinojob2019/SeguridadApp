package pe.com.distriluz.app.ui.alerts;

import android.app.Dialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import pe.com.distriluz.app.R;
import pe.com.distriluz.app.databinding.AlertSelectPhotoBinding;
import pe.com.distriluz.app.ui.base.BaseDialog;
import pe.com.distriluz.app.ui.base.viewmodel.IViewModel;
import pe.com.distriluz.app.ui.base.viewmodel.NoOpViewModel;

/**
 * Fragmento con un diálogo personalizado
 */
public class AlertSelectPhotoDialog extends BaseDialog<AlertSelectPhotoBinding, NoOpViewModel> {

    private IViewModel listener;

    public AlertSelectPhotoDialog(IViewModel listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        dialogComponent().inject(this);
        AlertDialog dialog = new AlertDialog.Builder(getActivity())
                .setView(setAndBindContentView(savedInstanceState, R.layout.alert_select_photo))
                .create();
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        dialog.setOnKeyListener((dialogInterface, keyCode, keyEvent) -> keyCode == KeyEvent.KEYCODE_BACK);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        return dialog;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        getDialog().setCanceledOnTouchOutside(false);
//        getDialog().setCancelable(false);
        listenerViews();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void listenerViews() {
        binding.lySelectGallery.setOnClickListener(v -> {
            listener.openGallery();
            dismissAllowingStateLoss();
        });
        binding.lyTakePhoto.setOnClickListener(v -> {
            listener.openCamera();
            dismissAllowingStateLoss();
        });
    }
}