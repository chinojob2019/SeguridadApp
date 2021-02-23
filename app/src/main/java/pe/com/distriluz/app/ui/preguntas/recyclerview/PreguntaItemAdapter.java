package pe.com.distriluz.app.ui.preguntas.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.ObservableList;
import androidx.recyclerview.widget.RecyclerView;

import javax.inject.Inject;

import pe.com.distriluz.app.R;
import pe.com.distriluz.app.injection.scopes.PerActivity;
import pe.com.distriluz.app.injection.scopes.PerFragment;
import pe.com.distriluz.app.ui.base.viewmodel.IViewModel;
import pe.com.distriluz.app.ui.clientelistar.ClienteListarObservableModel;
import pe.com.distriluz.app.ui.preguntas.PreguntasObservableModel;

@PerFragment
public class PreguntaItemAdapter extends RecyclerView.Adapter<PreguntaItemViewHolder> {

    PreguntasObservableModel model;

    @Inject
    public PreguntaItemAdapter() {

    }

    public void setData(PreguntasObservableModel model){
        this.model=model;
        addListnerChange();
    }

    private void addListnerChange() {
        this.model.getPreguntas().addOnListChangedCallback(new ObservableList.OnListChangedCallback<ObservableList<PreguntasObservableModel.PreguntasfrecuentesObservable>>() {
            @Override
            public void onChanged(ObservableList<PreguntasObservableModel.PreguntasfrecuentesObservable> list) {
                notifyDataSetChanged();
            }

            @Override
            public void onItemRangeChanged(ObservableList<PreguntasObservableModel.PreguntasfrecuentesObservable> list, int positionStart, int itemCount) {
                notifyItemRangeChanged( positionStart, itemCount );
            }

            @Override
            public void onItemRangeInserted(ObservableList<PreguntasObservableModel.PreguntasfrecuentesObservable> list, int positionStart, int itemCount) {
                notifyItemRangeInserted( positionStart, itemCount );
            }

            @Override
            public void onItemRangeMoved(ObservableList<PreguntasObservableModel.PreguntasfrecuentesObservable> list, int fromPosition, int toPosition, int itemCount) {
                notifyItemMoved( fromPosition, toPosition );
            }

            @Override
            public void onItemRangeRemoved(ObservableList<PreguntasObservableModel.PreguntasfrecuentesObservable> list, int positionStart, int itemCount) {
                notifyItemRangeRemoved( positionStart, itemCount );
            }
        });
    }

    @Override
    public PreguntaItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.item_pregunta, viewGroup, false);
        return new PreguntaItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PreguntaItemViewHolder viewHolder, int position) {
        viewHolder.viewModel().update(model.getPreguntas().get(position));
        viewHolder.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return model.getPreguntas().size();
    }

}
