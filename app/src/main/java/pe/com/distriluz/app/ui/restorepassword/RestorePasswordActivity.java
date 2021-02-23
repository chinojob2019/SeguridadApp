package pe.com.distriluz.app.ui.restorepassword;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;

import pe.com.distriluz.app.R;
import pe.com.distriluz.app.databinding.ChangePasswordActivityBinding;
import pe.com.distriluz.app.databinding.RestorePasswordActivityBinding;
import pe.com.distriluz.app.ui.base.BaseActivity;
import pe.com.distriluz.app.utils.Utils;

public class RestorePasswordActivity extends BaseActivity<RestorePasswordActivityBinding, RestorePasswordMvvm.ViewModel> implements RestorePasswordMvvm.View {

    private final static String TAG = RestorePasswordActivity.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent().inject(this);
        setAndBindContentView(savedInstanceState, R.layout.restore_password_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setDisplayHomeAsUpEnabled();
        setTitle("");
        notelevationbar();

        binding.txtpassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if(s.length()>0){
                    if(viewModel.getModel().getErrorPass() == null){
                        binding.inputlayoutcorreo.setEndIconTintList(Utils.getColorActive());
                    }else {
                        binding.inputlayoutcorreo.setEndIconTintList(Utils.getColorError());
                    }
                }else if(binding.txtpassword.isFocused()){
                    binding.inputlayoutcorreo.setEndIconTintList(Utils.getColorActive());
                }else{
                    binding.inputlayoutcorreo.setEndIconTintList(Utils.getColorInactive());
                }

            }
        });
    }
}
