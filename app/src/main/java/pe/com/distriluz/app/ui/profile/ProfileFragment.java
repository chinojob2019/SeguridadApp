package pe.com.distriluz.app.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import pe.com.distriluz.app.R;
import pe.com.distriluz.app.databinding.FragmentProfileBinding;
import pe.com.distriluz.app.ui.base.BaseFragment;
import pe.com.distriluz.app.ui.clientelistar.ClienteListarViewModel;

public class ProfileFragment extends BaseFragment<FragmentProfileBinding, ProfileMvvm.ViewModel>
        implements ProfileMvvm.View {

    private ClienteListarViewModel clienteListarViewModel;

    public ProfileFragment(ClienteListarViewModel clienteListarViewModel) {
        this.clienteListarViewModel = clienteListarViewModel;
    }

    @Override
    public void changeGlobal() {
        clienteListarViewModel.getModel().notifyChange();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return setAndBindContentView(inflater, container, savedInstanceState, R.layout.fragment_profile);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        viewModel.onActivityResult(requestCode, resultCode, data);
    }
}