package pe.com.distriluz.app.ui.appslista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;

import pe.com.distriluz.app.R;
import pe.com.distriluz.app.databinding.FragmentAppListBinding;
import pe.com.distriluz.app.ui.appslista.recyclerView.AppsItemAdapter;
import pe.com.distriluz.app.ui.appslista.recyclerView.AppsItemListAdapter;
import pe.com.distriluz.app.ui.base.BaseFragment;
import pe.com.distriluz.app.ui.clientelistar.ClienteListarObservableModel;

public class AppListaFragment extends BaseFragment<FragmentAppListBinding, AppListaMvvm.ViewModel>
        implements AppListaMvvm.View {


    private ClienteListarObservableModel activityModel;
    AppsItemAdapter adapterAll;

    AppsItemAdapter adapterDestacado;

    AppsItemAdapter adapterMoreToUse;

    AppsItemAdapter adapterLanzamiento;

    AppsItemListAdapter adapterAll_list;

    AppsItemListAdapter adapterDestacado_list;

    AppsItemListAdapter adapterMoreToUse_list;

    AppsItemListAdapter adapterLanzamiento_list;

    public AppListaFragment(ClienteListarObservableModel activityModel) {
        this.activityModel = activityModel;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return setAndBindContentView(inflater, container, savedInstanceState, R.layout.fragment_app_list);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel.setActivityModel(activityModel);
        configRecyclers();
    }

    private void configRecyclers() {
       adaptersGrid();
       adaptersList();
    }

    private void adaptersGrid() {

        adapterAll = new AppsItemAdapter(viewModel, activityModel);

        adapterDestacado = new AppsItemAdapter(viewModel, activityModel);

        adapterMoreToUse = new AppsItemAdapter(viewModel, activityModel);

        adapterLanzamiento = new AppsItemAdapter(viewModel, activityModel);

        binding.rvDestacado.setHasFixedSize(true);
        binding.rvDestacado.setLayoutManager(new GridLayoutManager(getBaseActivity(),3));
        binding.rvDestacado.setAdapter(adapterDestacado);
        binding.rvDestacado.setItemAnimator(new DefaultItemAnimator());


        binding.rvMoreToUse.setHasFixedSize(true);
        binding.rvMoreToUse.setLayoutManager(new GridLayoutManager(getBaseActivity(),3));
        binding.rvMoreToUse.setAdapter(adapterMoreToUse);
        binding.rvMoreToUse.setItemAnimator(new DefaultItemAnimator());
//

        binding.rvAll.setHasFixedSize(true);
        binding.rvAll.setLayoutManager(new GridLayoutManager(getBaseActivity(),3));
        binding.rvAll.setAdapter(adapterAll);
        binding.rvAll.setItemAnimator(new DefaultItemAnimator());


        binding.rvLanzamientos.setHasFixedSize(true);
        binding.rvLanzamientos.setLayoutManager(new GridLayoutManager(getBaseActivity(),3));
        binding.rvLanzamientos.setAdapter(adapterLanzamiento);
        binding.rvLanzamientos.setItemAnimator(new DefaultItemAnimator());
    }

    private void adaptersList() {

        adapterAll_list = new AppsItemListAdapter(viewModel, activityModel);

        adapterDestacado_list = new AppsItemListAdapter(viewModel, activityModel);

        adapterMoreToUse_list = new AppsItemListAdapter(viewModel, activityModel);

        adapterLanzamiento_list = new AppsItemListAdapter(viewModel, activityModel);

        binding.rvDestacadoList.setHasFixedSize(true);
        binding.rvDestacadoList.setLayoutManager(new GridLayoutManager(getBaseActivity(),1));
        binding.rvDestacadoList.setAdapter(adapterDestacado_list);
        binding.rvDestacadoList.setItemAnimator(new DefaultItemAnimator());


        binding.rvMoreToUseList.setHasFixedSize(true);
        binding.rvMoreToUseList.setLayoutManager(new GridLayoutManager(getBaseActivity(),1));
        binding.rvMoreToUseList.setAdapter(adapterMoreToUse_list);
        binding.rvMoreToUseList.setItemAnimator(new DefaultItemAnimator());
//

        binding.rvAllList.setHasFixedSize(true);
        binding.rvAllList.setLayoutManager(new GridLayoutManager(getBaseActivity(),1));
        binding.rvAllList.setAdapter(adapterAll_list);
        binding.rvAllList.setItemAnimator(new DefaultItemAnimator());


        binding.rvLanzamientosList.setHasFixedSize(true);
        binding.rvLanzamientosList.setLayoutManager(new GridLayoutManager(getBaseActivity(),1));
        binding.rvLanzamientosList.setAdapter(adapterLanzamiento_list);
        binding.rvLanzamientosList.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void updateAdapter(){
        adapterDestacado.setData(viewModel.getModel().getDestacados());
        adapterDestacado.notifyDataSetChanged();

        adapterMoreToUse.setData(viewModel.getModel().getRecurrentes());
        adapterMoreToUse.notifyDataSetChanged();

        adapterAll.setData(viewModel.getModel().getTodos());
        adapterAll.notifyDataSetChanged();

        adapterLanzamiento.setData(viewModel.getModel().getLanzamientos());
        adapterLanzamiento.notifyDataSetChanged();

        adapterDestacado_list.setData(viewModel.getModel().getDestacados());
        adapterDestacado_list.notifyDataSetChanged();

        adapterMoreToUse_list.setData(viewModel.getModel().getRecurrentes());
        adapterMoreToUse_list.notifyDataSetChanged();

        adapterAll_list.setData(viewModel.getModel().getTodos());
        adapterAll_list.notifyDataSetChanged();

        adapterLanzamiento_list.setData(viewModel.getModel().getLanzamientos());
        adapterLanzamiento_list.notifyDataSetChanged();
    }

    @Override
    public void reloadListApps(){
        viewModel.getAllApps();
    }
}