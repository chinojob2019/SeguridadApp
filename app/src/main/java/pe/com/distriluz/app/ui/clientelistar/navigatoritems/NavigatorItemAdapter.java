package pe.com.distriluz.app.ui.clientelistar.navigatoritems;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.ObservableList;
import androidx.recyclerview.widget.RecyclerView;

import javax.inject.Inject;

import pe.com.distriluz.app.R;
import pe.com.distriluz.app.injection.scopes.PerActivity;
import pe.com.distriluz.app.ui.base.viewmodel.IViewModel;
import pe.com.distriluz.app.ui.clientelistar.ClienteListarObservableModel;

@PerActivity
public class NavigatorItemAdapter extends RecyclerView.Adapter<NavigatorItemViewHolder> {

    ClienteListarObservableModel model;
    private IViewModel listener;

    @Inject
    public NavigatorItemAdapter() {

    }

    public void setData(ClienteListarObservableModel model, IViewModel listener){
        this.model=model;
        this.listener=listener;
        addListnerChange();
    }

    private void addListnerChange() {
        this.model.getListItemsMenu().addOnListChangedCallback(new ObservableList.OnListChangedCallback<ObservableList<ClienteListarObservableModel.NavigationItems>>() {
            @Override
            public void onChanged(ObservableList<ClienteListarObservableModel.NavigationItems> list) {
                notifyDataSetChanged();
            }

            @Override
            public void onItemRangeChanged(ObservableList<ClienteListarObservableModel.NavigationItems> list, int positionStart, int itemCount) {
                notifyItemRangeChanged( positionStart, itemCount );
            }

            @Override
            public void onItemRangeInserted(ObservableList<ClienteListarObservableModel.NavigationItems> list, int positionStart, int itemCount) {
                notifyItemRangeInserted( positionStart, itemCount );
            }

            @Override
            public void onItemRangeMoved(ObservableList<ClienteListarObservableModel.NavigationItems> list, int fromPosition, int toPosition, int itemCount) {
                notifyItemMoved( fromPosition, toPosition );
            }

            @Override
            public void onItemRangeRemoved(ObservableList<ClienteListarObservableModel.NavigationItems> list, int positionStart, int itemCount) {
                notifyItemRangeRemoved( positionStart, itemCount );
            }
        });
    }

    @Override
    public NavigatorItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.item_drawer_layout, viewGroup, false);
        return new NavigatorItemViewHolder(itemView,this);
    }

    @Override
    public void onBindViewHolder(NavigatorItemViewHolder viewHolder, int position) {
        viewHolder.viewModel().update(model.getListItemsMenu().get(position),position ==  model.getItemSelectPos(),listener);
        viewHolder.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return model.getListItemsMenu().size();
    }

}
