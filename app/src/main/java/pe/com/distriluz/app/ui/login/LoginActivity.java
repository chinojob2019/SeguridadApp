package pe.com.distriluz.app.ui.login;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.inputmethod.EditorInfo;

import androidx.core.content.res.ResourcesCompat;

import pe.com.distriluz.app.R;
import pe.com.distriluz.app.databinding.LoginActivityBinding;
import pe.com.distriluz.app.ui.base.BaseActivity;

public class LoginActivity extends BaseActivity<LoginActivityBinding, LoginMvvm.ViewModel> implements LoginMvvm.View {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent().inject(this);
        setAndBindContentView(savedInstanceState, R.layout.login_activity);

        binding.txtlogin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int[][] states = new int[][] {
                        new int[] {android.R.attr.state_enabled},
                        new int[] {-android.R.attr.state_enabled}
                };

                int[] colorsactive = new int[] {
                        ResourcesCompat.getColor(getResources(), R.color.colorEndIconactivo, null),
                        ResourcesCompat.getColor(getResources(), R.color.colorEndIconactivo, null)
                };

                int[] colorsinactive = new int[] {
                        ResourcesCompat.getColor(getResources(), R.color.colorEndIconInactivo, null),
                        ResourcesCompat.getColor(getResources(), R.color.colorEndIconInactivo, null)
                };

                int[] colorserror = new int[] {
                        ResourcesCompat.getColor(getResources(), R.color.rojo, null),
                        ResourcesCompat.getColor(getResources(), R.color.rojo, null)
                };

                ColorStateList colorStateListActive = new  ColorStateList(states, colorsactive);
                ColorStateList colorStateListInActive = new  ColorStateList(states, colorsinactive);
                ColorStateList colorStateListError = new  ColorStateList(states, colorserror);
                if(s.length()>0){
                    if(viewModel.getModel().getErrorUser() == null){
                        binding.inputlayoutLogin.setEndIconTintList(colorStateListActive);
                    }else {
                        binding.inputlayoutLogin.setEndIconTintList(colorStateListError);
                    }
                }else{
                    binding.inputlayoutLogin.setEndIconTintList(colorStateListInActive);

                }

            }
        });

        binding.txtpassword.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                viewModel.onClickIniciarSesion(null);
                return true;
            }
            return false;
        });


        binding.txtpassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int[][] states = new int[][] {
                        new int[] {android.R.attr.state_enabled},
                        new int[] {-android.R.attr.state_enabled}
                };

                int[] colorsactive = new int[] {
                        ResourcesCompat.getColor(getResources(), R.color.colorEndIconactivo, null),
                        ResourcesCompat.getColor(getResources(), R.color.colorEndIconactivo, null)
                };

                int[] colorsinactive = new int[] {
                        ResourcesCompat.getColor(getResources(), R.color.colorEndIconInactivo, null),
                        ResourcesCompat.getColor(getResources(), R.color.colorEndIconInactivo, null)
                };

                int[] colorserror = new int[] {
                        ResourcesCompat.getColor(getResources(), R.color.rojo, null),
                        ResourcesCompat.getColor(getResources(), R.color.rojo, null)
                };

                ColorStateList colorStateListActive = new  ColorStateList(states, colorsactive);
                ColorStateList colorStateListInActive = new  ColorStateList(states, colorsinactive);
                ColorStateList colorStateListError = new  ColorStateList(states, colorserror);
                if(s.length()>0){
                    if(viewModel.getModel().getErrorPass() == null){
                        binding.inpulayoutPassword.setEndIconTintList(colorStateListActive);
                    }else {
                        binding.inpulayoutPassword.setEndIconTintList(colorStateListError);
                    }
                }else{
                    binding.inpulayoutPassword.setEndIconTintList(colorStateListInActive);

                }

            }
        });


    }
}
