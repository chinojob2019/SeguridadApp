package pe.com.distriluz.app.ui.codeconfirm;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;

import pe.com.distriluz.app.R;
import pe.com.distriluz.app.databinding.CodeConfirmActivityBinding;
import pe.com.distriluz.app.ui.base.BaseActivity;

public class CodeConfirmActivity extends BaseActivity<CodeConfirmActivityBinding, CodeConfirmMvvm.ViewModel> implements CodeConfirmMvvm.View {

    private final static String TAG = CodeConfirmActivity.class.getSimpleName();

//TODO cuando se quiere iniciar una cotizacion sin logear se abre el PersonalDataScreen.class

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent().inject(this);
        setAndBindContentView(savedInstanceState, R.layout.code_confirm_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setDisplayHomeAsUpEnabled();
        setTitle("");
        notelevationbar();

    }

    @Override
    public void ocultarKeyboard() {
        hideKeyboard();
    }
}
