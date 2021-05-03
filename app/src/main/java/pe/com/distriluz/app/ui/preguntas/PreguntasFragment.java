package pe.com.distriluz.app.ui.preguntas;

import android.content.Intent;
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
import pe.com.distriluz.app.ui.base.BaseFragment;
import pe.com.distriluz.app.ui.clientelistar.ClienteListarObservableModel;
import pe.com.distriluz.app.ui.preguntas.recyclerview.PreguntaItemAdapter;

public class PreguntasFragment extends BaseFragment<FragmentPreguntasBinding, PreguntasMvvm.ViewModel>
        implements PreguntasMvvm.View {

    @Inject
    PreguntaItemAdapter adapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return setAndBindContentView(inflater, container, savedInstanceState, R.layout.fragment_preguntas);
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        viewModel.onActivityResult(requestCode, resultCode, data);
    }
    @Override
    public void changeGlobal() {
        configRecycler();
    }

    @Override
    public void habilitarbotones(Boolean valor) {
        binding.imageView8.setEnabled(valor);
        binding.imageView9.setEnabled(valor);

    }
}
