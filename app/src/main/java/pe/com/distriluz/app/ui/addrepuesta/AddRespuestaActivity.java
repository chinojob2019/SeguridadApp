package pe.com.distriluz.app.ui.addrepuesta;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.core.content.res.ResourcesCompat;

import pe.com.distriluz.app.R;
import pe.com.distriluz.app.databinding.AddPreguntaActivityBinding;
import pe.com.distriluz.app.databinding.AddRespuestaActivityBinding;
import pe.com.distriluz.app.ui.addpregunta.AddPreguntaMvvm;
import pe.com.distriluz.app.ui.base.BaseActivity;

public class AddRespuestaActivity extends BaseActivity<AddRespuestaActivityBinding, AddPreguntaMvvm.ViewModel> implements AddPreguntaMvvm.View {

    public static final int REQUEST_CODE = 656;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent().inject(this);
        setAndBindContentView(savedInstanceState, R.layout.add_respuesta_activity);

        binding.etDescripcion.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                ColorStateList myList;
                if(s.length()>0){
                    int[][] states = new int[][] {
                            new int[] {android.R.attr.state_enabled},
                            new int[] {-android.R.attr.state_enabled}
                    };

                    int[] colors = new int[] {
                            ResourcesCompat.getColor(getResources(), R.color.colorEndIconactivo, null),
                            ResourcesCompat.getColor(getResources(), R.color.colorEndIconactivo, null)
                    };

                    myList = new  ColorStateList(states, colors);
                }else{
                    int[][] states = new int[][] {
                            new int[] {android.R.attr.state_enabled},
                            new int[] {-android.R.attr.state_enabled}
                    };

                    int[] colors = new int[] {
                            ResourcesCompat.getColor(getResources(), R.color.rojo, null),
                            ResourcesCompat.getColor(getResources(), R.color.rojo, null)
                    };

                    myList = new  ColorStateList(states, colors);

                }
                binding.tilDescripcion.setEndIconTintList(myList);

            }
        });

        binding.etOrden.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                ColorStateList myList;
                if(s.length()>0){
                    int[][] states = new int[][] {
                            new int[] {android.R.attr.state_enabled},
                            new int[] {-android.R.attr.state_enabled}
                    };

                    int[] colors = new int[] {
                            ResourcesCompat.getColor(getResources(), R.color.colorEndIconactivo, null),
                            ResourcesCompat.getColor(getResources(), R.color.colorEndIconactivo, null)
                    };

                    myList = new  ColorStateList(states, colors);
                }else{
                    int[][] states = new int[][] {
                            new int[] {android.R.attr.state_enabled},
                            new int[] {-android.R.attr.state_enabled}
                    };

                    int[] colors = new int[] {
                            ResourcesCompat.getColor(getResources(), R.color.rojo, null),
                            ResourcesCompat.getColor(getResources(), R.color.rojo, null)
                    };

                    myList = new  ColorStateList(states, colors);

                }
                binding.tilOrden.setEndIconTintList(myList);
            }
        });

    }
}
