package pe.com.distriluz.app.ui.appslista.recyclerView;

import android.view.View;

import pe.com.distriluz.app.databinding.ItemListAppBinding;
import pe.com.distriluz.app.ui.appslista.AppListaMvvm;
import pe.com.distriluz.app.ui.base.BaseViewHolder;


public class AppsListViewHolder extends BaseViewHolder<ItemListAppBinding, AppsItemMvvm.ViewModel> implements AppsItemMvvm.View {


    private final AppListaMvvm.ViewModel viewModel;

    public AppsListViewHolder(View v, AppListaMvvm.ViewModel viewModel) {
        super(v);
        viewHolderComponent().inject(this);
        bindContentView(v);
        this.viewModel = viewModel;

    }

    @Override
    public void reloadApps() {
        viewModel.getAllApps();
    }
}
