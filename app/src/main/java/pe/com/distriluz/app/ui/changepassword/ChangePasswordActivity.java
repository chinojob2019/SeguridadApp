package pe.com.distriluz.app.ui.changepassword;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;

import pe.com.distriluz.app.R;
import pe.com.distriluz.app.databinding.ChangePasswordActivityBinding;
import pe.com.distriluz.app.ui.base.BaseActivity;
import pe.com.distriluz.app.utils.Utils;

public class ChangePasswordActivity extends BaseActivity<ChangePasswordActivityBinding, ChangePasswordMvvm.ViewModel> implements ChangePasswordMvvm.View {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent().inject(this);
        setAndBindContentView(savedInstanceState, R.layout.change_password_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setDisplayHomeAsUpEnabled();
        setTitle("");
        notelevationbar();

        binding.txtcorreo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if(s.length()>0){
                    if(viewModel.getModel().getErrorEmail() == null){
                        binding.inputlayoutcorreo.setEndIconTintList(Utils.getColorActive());
                    }else {
                        binding.inputlayoutcorreo.setEndIconTintList(Utils.getColorError());
                    }
                }else if(binding.txtcorreo.isFocused()){
                    binding.inputlayoutcorreo.setEndIconTintList(Utils.getColorActive());
                }else{
                    binding.inputlayoutcorreo.setEndIconTintList(Utils.getColorInactive());
                }

            }
        });

//        binding.txtcorreo.setOnFocusChangeListener((v, hasFocus) -> {
//            String text = binding.txtcorreo.getText().toString();
//            if(hasFocus){
//                if(text.isEmpty()){
//                    binding.inputlayoutcorreo.setEndIconTintList(Utils.getColorActive());
//                }else if(viewModel.getModel().getErrorEmail() != null){
//                    binding.inputlayoutcorreo.setEndIconTintList(Utils.getColorError());
//                }else{
//                    binding.inputlayoutcorreo.setEndIconTintList(Utils.getColorActive());
//                }
//            }else{
//                if(text.isEmpty()){
//                    binding.inputlayoutcorreo.setEndIconTintList(Utils.getColorInactive());
//                }else if(viewModel.getModel().getErrorEmail() != null){
//                    binding.inputlayoutcorreo.setEndIconTintList(Utils.getColorError());
//                }else{
//                    binding.inputlayoutcorreo.setEndIconTintList(Utils.getColorActive());
//                }
//            }
//        });
    }
}
