package pe.com.distriluz.app.ui.preguntaslectura;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;

import javax.inject.Inject;

import pe.com.distriluz.app.R;
import pe.com.distriluz.app.databinding.FragmentPreguntasBinding;
import pe.com.distriluz.app.databinding.FragmentPreguntasLecturaBinding;
import pe.com.distriluz.app.ui.base.BaseFragment;

import pe.com.distriluz.app.ui.preguntaslectura.recyclerview.PreguntaLecturaItemAdapter;

public class PreguntasLecturaFragment extends BaseFragment<FragmentPreguntasLecturaBinding, PreguntasLecturaMvvm.ViewModel>
        implements PreguntasLecturaMvvm.View {

    @Inject
    PreguntaLecturaItemAdapter adapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return setAndBindContentView(inflater, container, savedInstanceState, R.layout.fragment_preguntas_lectura);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        configRecycler();
    }

    private void configRecycler() {
        adapter.setData(viewModel.getModel(),getContext());
        binding.rvRecycler.setHasFixedSize(true);
        binding.rvRecycler.setLayoutManager(new GridLayoutManager(getBaseActivity(),1));
        binding.rvRecycler.setAdapter(adapter);
        binding.rvRecycler.setItemAnimator(new DefaultItemAnimator());
    }
}
