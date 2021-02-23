package pe.com.distriluz.app.ui.validatecode;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;

import androidx.appcompat.widget.Toolbar;

import pe.com.distriluz.app.R;
import pe.com.distriluz.app.databinding.ValidateCodeActivityBinding;
import pe.com.distriluz.app.ui.base.BaseActivity;

public class ValidateCodeActivity extends BaseActivity<ValidateCodeActivityBinding, ValidateCodeMvvm.ViewModel> implements ValidateCodeMvvm.View {

    private final static String TAG = ValidateCodeActivity.class.getSimpleName();

//TODO cuando se quiere iniciar una cotizacion sin logear se abre el PersonalDataScreen.class

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent().inject(this);
        setAndBindContentView(savedInstanceState, R.layout.validate_code_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setDisplayHomeAsUpEnabled();
        setTitle("");
        notelevationbar();
        listenerCode();
    }

    private void listenerCode() {
        binding.cod4.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                viewModel.onClickSendCode(null);
                return true;
            }
            return false;
        });

        binding.cod1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String edtChar=binding.cod1.getText().toString();
                if(edtChar.length()==1)
                {

                    binding.cod2.requestFocus();
                }else if(edtChar.length()==0) {
                    binding.cod1.requestFocus();
                }

            }
        });

        binding.cod2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String edtChar=binding.cod2.getText().toString();
                if(edtChar.length()==1)
                {
                    binding.cod3.requestFocus();
                }else if(edtChar.length()==0) {
                    binding.cod1.requestFocus();
                }
            }
        });
        binding.cod2.setOnKeyListener((v, keyCode, event) -> {
            if(KeyEvent.KEYCODE_DEL == keyCode && binding.cod2.getText().toString().isEmpty()){
                binding.cod1.requestFocus();
            }
            return false;
        });

        binding.cod3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String edtChar=binding.cod3.getText().toString();
                if(edtChar.length()==1)
                {
                    binding.cod4.requestFocus();
                }else if(edtChar.length()==0) {
                    binding.cod2.requestFocus();
                }
            }
        });
        binding.cod3.setOnKeyListener((v, keyCode, event) -> {
            if(KeyEvent.KEYCODE_DEL == keyCode && binding.cod3.getText().toString().isEmpty()){
                binding.cod2.requestFocus();
            }
            return false;
        });

        binding.cod4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(binding.cod4.getText().toString().length()==0) {
                    binding.cod3.requestFocus();
                }
            }
        });
        binding.cod4.setOnKeyListener((v, keyCode, event) -> {
            if(KeyEvent.KEYCODE_DEL == keyCode && binding.cod4.getText().toString().isEmpty()){
                binding.cod3.requestFocus();
            }
            return false;
        });
    }

    @Override
    public String getCode() {
        return binding.cod1.getText().toString() +binding.cod2.getText().toString() +binding.cod3.getText().toString() +binding.cod4.getText().toString();
    }

    @Override
    public void clearText() {
        binding.cod1.setText("");
        binding.cod2.setText("");
        binding.cod3.setText("");
        binding.cod4.setText("");
        binding.cod1.requestFocus();
    }
}
