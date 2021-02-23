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
import pe.com.distriluz.app.databinding.AlertLoadingBinding;
import pe.com.distriluz.app.ui.base.BaseDialog;
import pe.com.distriluz.app.ui.base.viewmodel.IViewModel;
import pe.com.distriluz.app.ui.base.viewmodel.NoOpViewModel;

/**
 * Fragmento con un diálogo personalizado
 */
public class AlertLoadingDialog extends BaseDialog<AlertLoadingBinding, NoOpViewModel> {

    private IViewModel listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        dialogComponent().inject(this);
        AlertDialog dialog = new AlertDialog.Builder(getActivity())
                .setView(setAndBindContentView(savedInstanceState, R.layout.alert_loading))
                .create();
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        dialog.setOnKeyListener((dialogInterface, keyCode, keyEvent) -> keyCode == KeyEvent.KEYCODE_BACK);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        return dialog;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().setCanceledOnTouchOutside(false);
        getDialog().setCancelable(false);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void setData(IViewModel listener) {
        this.listener=listener;
    }

}