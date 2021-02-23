package pe.com.distriluz.app.ui.clientelistar.navigatoritems;

import android.view.View;

import pe.com.distriluz.app.databinding.ItemDrawerLayoutBinding;
import pe.com.distriluz.app.ui.base.BaseViewHolder;


public class NavigatorItemViewHolder extends BaseViewHolder<ItemDrawerLayoutBinding, NavigatorItemMvvm.ViewModel> implements NavigatorItemMvvm.View {


    private final NavigatorItemAdapter adapter;

    public NavigatorItemViewHolder(View v, NavigatorItemAdapter adapter) {
        super(v);
        viewHolderComponent().inject(this);
        bindContentView(v);
        this.adapter = adapter;
    }

    @Override
    public void setActive() {
        adapter.model.setItemSelectPos(adapter.model.getListItemsMenu().indexOf(viewModel.getModel()));
        adapter.notifyDataSetChanged();
    }
}
