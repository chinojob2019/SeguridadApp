package pe.com.distriluz.app.ui.appslista.recyclerView;

import android.view.View;

import pe.com.distriluz.app.databinding.ItemAppBinding;
import pe.com.distriluz.app.ui.appslista.AppListaMvvm;
import pe.com.distriluz.app.ui.base.BaseViewHolder;


public class AppsViewHolder extends BaseViewHolder<ItemAppBinding, AppsItemMvvm.ViewModel> implements AppsItemMvvm.View {


    private final AppListaMvvm.ViewModel viewModel;

    public AppsViewHolder(View v, AppListaMvvm.ViewModel viewModel) {
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
