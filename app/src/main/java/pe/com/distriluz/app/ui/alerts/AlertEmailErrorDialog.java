package pe.com.distriluz.app.ui.alerts;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import pe.com.distriluz.app.R;
import pe.com.distriluz.app.databinding.AlertEmailErrorFragmentBinding;
import pe.com.distriluz.app.ui.base.BaseDialog;
import pe.com.distriluz.app.ui.base.viewmodel.NoOpViewModel;

import static android.view.KeyEvent.KEYCODE_BACK;


public class AlertEmailErrorDialog extends BaseDialog<AlertEmailErrorFragmentBinding, NoOpViewModel> {

    private String title;
    private String subtitle;
    private String textButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    public AlertEmailErrorDialog(String title, String subtitle, String textButton) {
        this.title = title;
        this.subtitle = subtitle;
        this.textButton = textButton;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        dialogComponent().inject(this);
        Dialog dialog =new AlertDialog.Builder(getActivity())
                .setView(setAndBindContentView(savedInstanceState, R.layout.alert_email_error_fragment))
                .create();
        dialog.setOnKeyListener((dialog1, keyCode, event) -> keyCode == KEYCODE_BACK);
        return dialog;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding.txtitle.setText(title);
        binding.txtsubtitle.setText(subtitle);
        binding.btnCancel.setText(textButton);
        binding.btnClose.setOnClickListener(v -> dismissAllowingStateLoss());
        binding.btnCancel.setOnClickListener(v -> dismissAllowingStateLoss());
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}