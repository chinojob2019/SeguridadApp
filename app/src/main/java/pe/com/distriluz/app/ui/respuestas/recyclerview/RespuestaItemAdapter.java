package pe.com.distriluz.app.ui.respuestas.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.databinding.ObservableList;
import androidx.recyclerview.widget.RecyclerView;

import javax.inject.Inject;

import pe.com.distriluz.app.R;
import pe.com.distriluz.app.injection.scopes.PerFragment;
import pe.com.distriluz.app.ui.respuestas.RespuestasMvvm;
import pe.com.distriluz.app.ui.respuestas.RespuestasObservableModel;
import pe.com.distriluz.app.ui.respuestas.recyclerview.RespuestaItemViewHolder;

@PerFragment
public class RespuestaItemAdapter extends RecyclerView.Adapter<RespuestaItemViewHolder> {

    RespuestasObservableModel model;
    Context context;
    RespuestasMvvm.ViewModel viewModel;

    @Inject
    public RespuestaItemAdapter(RespuestasMvvm.ViewModel viewModel) {
        this.viewModel = viewModel;

    }

    public void setData(RespuestasObservableModel model, Context context) {
        this.model = model;
        this.context = context;
        addListnerChange();
    }

    private void addListnerChange() {
        this.model.getRespuestas().addOnListChangedCallback(new ObservableList.OnListChangedCallback<ObservableList<RespuestasObservableModel.RespuestasItem>>() {
            @Override
            public void onChanged(ObservableList<RespuestasObservableModel.RespuestasItem> list) {
                notifyDataSetChanged();
            }

            @Override
            public void onItemRangeChanged(ObservableList<RespuestasObservableModel.RespuestasItem> list, int positionStart, int itemCount) {
                notifyItemRangeChanged(positionStart, itemCount);
            }

            @Override
            public void onItemRangeInserted(ObservableList<RespuestasObservableModel.RespuestasItem> list, int positionStart, int itemCount) {
                notifyItemRangeInserted(positionStart, itemCount);
            }

            @Override
            public void onItemRangeMoved(ObservableList<RespuestasObservableModel.RespuestasItem> list, int fromPosition, int toPosition, int itemCount) {
                notifyItemMoved(fromPosition, toPosition);
            }

            @Override
            public void onItemRangeRemoved(ObservableList<RespuestasObservableModel.RespuestasItem> list, int positionStart, int itemCount) {
                notifyItemRangeRemoved(positionStart, itemCount);
            }
        });
    }

    @Override
    public RespuestaItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.item_respuesta, viewGroup, false);
        return new RespuestaItemViewHolder(itemView, viewModel);
    }

    @Override
    public void onBindViewHolder(RespuestaItemViewHolder viewHolder, int position) {

        viewHolder.getCheckSelecionar().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                model.getRespuestas().get(position).setSeleccionado(isChecked);
                viewModel.getModel().getRespuestas().get(position).setSeleccionado(isChecked);
                int cantidad = 0;
                for (int i = 0; i < viewModel.getModel().getRespuestas().size(); i++) {
                    if (viewModel.getModel().getRespuestas().get(i).getSeleccionado()) {
                        cantidad = cantidad + 1;

                    }
                }
                viewModel.getModel().setCantidadSeleccionada(String.valueOf(cantidad));
                addListnerChange();
            }
        });

        viewHolder.getLyRespuesta().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                model.getRespuestas().get(position).setEditarItem(1);
                model.getRespuestas().get(position).setSeleccionado(true);
                for (int i = 0; i < model.getRespuestas().size(); i++) {
                    model.getRespuestas().get(i).setEditarItem(1);
                }
                viewModel.getModel().setEditarItem(1);
                addListnerChange();
                return false;
            }
        });


        viewHolder.viewModel().update(model.getRespuestas().get(position));
        viewHolder.executePendingBindings();

    }

    @Override
    public int getItemCount() {
        return model.getRespuestas().size();
    }

}
