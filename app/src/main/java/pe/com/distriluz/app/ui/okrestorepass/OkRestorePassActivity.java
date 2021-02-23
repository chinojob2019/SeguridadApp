package pe.com.distriluz.app.ui.okrestorepass;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import pe.com.distriluz.app.R;
import pe.com.distriluz.app.databinding.OkRestorePassActivityBinding;
import pe.com.distriluz.app.databinding.ValidateCodeActivityBinding;
import pe.com.distriluz.app.ui.base.BaseActivity;
import pe.com.distriluz.app.ui.base.viewmodel.NoOpViewModel;
import pe.com.distriluz.app.ui.validatecode.ValidateCodeMvvm;

public class OkRestorePassActivity extends BaseActivity<OkRestorePassActivityBinding, NoOpViewModel> {

    private final static String TAG = OkRestorePassActivity.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent().inject(this);
        setAndBindContentView(savedInstanceState, R.layout.ok_restore_pass_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setDisplayHomeAsUpEnabled();
        setTitle("");
        notelevationbar();
        init();
    }

    private void init() {
        binding.btnclose.setOnClickListener(v -> finish());
        binding.button.setOnClickListener(v -> finish());
    }
}
