package pe.com.distriluz.app.ui.appslista.recyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.Observable;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.recyclerview.widget.RecyclerView;

import javax.inject.Inject;

import pe.com.distriluz.app.R;
import pe.com.distriluz.app.injection.scopes.PerFragment;
import pe.com.distriluz.app.ui.appslista.AppListaMvvm;
import pe.com.distriluz.app.ui.appslista.AppsObservableModel;
import pe.com.distriluz.app.ui.clientelistar.ClienteListarObservableModel;

@PerFragment
public class AppsItemListAdapter extends RecyclerView.Adapter<AppsListViewHolder> {

    private final AppListaMvvm.ViewModel viewModel;
    private final ClienteListarObservableModel model;
    private ObservableList<AppsObservableModel.AppObservable> list = new ObservableArrayList<>();
    private ObservableList<AppsObservableModel.AppObservable> baseList = new ObservableArrayList<>();

    @Inject
    public AppsItemListAdapter(AppListaMvvm.ViewModel viewModel, ClienteListarObservableModel model) {
        this.viewModel= viewModel;
        this.model= model;
        addListenerQuery();
    }

    private void addListenerQuery() {
        this.model.addOnPropertyChangedCallback( new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                if(model == sender  && propertyId == pe.com.distriluz.app.BR.query)  {
                    filter(model.getQuery());
                }
            }
        });

    }


    public void setData(ObservableList<AppsObservableModel.AppObservable> list){
        this.list=list;
        this.baseList=list;
        this.model.setQuery("");
        addListnerChange();
    }

    private void addListnerChange() {
        this.list.addOnListChangedCallback(new ObservableList.OnListChangedCallback<ObservableList<AppsObservableModel.AppObservable>>() {
            @Override
            public void onChanged(ObservableList<AppsObservableModel.AppObservable> list) {
                notifyDataSetChanged();
            }

            @Override
            public void onItemRangeChanged(ObservableList<AppsObservableModel.AppObservable> list, int positionStart, int itemCount) {
                notifyItemRangeChanged( positionStart, itemCount );
            }

            @Override
            public void onItemRangeInserted(ObservableList<AppsObservableModel.AppObservable> list, int positionStart, int itemCount) {
                notifyItemRangeInserted( positionStart, itemCount );
            }

            @Override
            public void onItemRangeMoved(ObservableList<AppsObservableModel.AppObservable> list, int fromPosition, int toPosition, int itemCount) {
                notifyItemMoved( fromPosition, toPosition );
            }

            @Override
            public void onItemRangeRemoved(ObservableList<AppsObservableModel.AppObservable> list, int positionStart, int itemCount) {
                notifyItemRangeRemoved( positionStart, itemCount );
            }
        });
    }

    @Override
    public AppsListViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.item_list_app, viewGroup, false);
        return new AppsListViewHolder(itemView,viewModel);
    }

    @Override
    public void onBindViewHolder(AppsListViewHolder viewHolder, int position) {
        viewHolder.viewModel().update(list.get(position));
        viewHolder.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public void filter(String query){
        if (query.isEmpty()) {
            list=baseList;
        } else {
            ObservableList<AppsObservableModel.AppObservable> filteredList = new ObservableArrayList<>();
            for (AppsObservableModel.AppObservable row : baseList) {
                if (
                        String.valueOf(row.getNombre()).toLowerCase().contains(query)) {
                    filteredList.add(row);
                }
            }
            list = filteredList;
        }
        notifyDataSetChanged();
    }
}
