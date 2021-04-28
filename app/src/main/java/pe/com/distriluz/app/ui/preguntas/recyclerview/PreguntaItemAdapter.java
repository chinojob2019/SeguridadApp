package pe.com.distriluz.app.ui.preguntas.recyclerview;

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
import pe.com.distriluz.app.injection.scopes.PerActivity;
import pe.com.distriluz.app.injection.scopes.PerFragment;
import pe.com.distriluz.app.ui.base.viewmodel.IViewModel;
import pe.com.distriluz.app.ui.clientelistar.ClienteListarObservableModel;
import pe.com.distriluz.app.ui.preguntas.PreguntasMvvm;
import pe.com.distriluz.app.ui.preguntas.PreguntasObservableModel;

@PerFragment
public class PreguntaItemAdapter extends RecyclerView.Adapter<PreguntaItemViewHolder> {

    PreguntasObservableModel model;
    Context context;
    PreguntasMvvm.ViewModel viewModel;

    @Inject
    public PreguntaItemAdapter(PreguntasMvvm.ViewModel viewModel) {
        this.viewModel = viewModel;

    }

    public void setData(PreguntasObservableModel model, Context context) {
        this.model = model;
        this.context = context;
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
                notifyItemRangeChanged(positionStart, itemCount);
            }

            @Override
            public void onItemRangeInserted(ObservableList<PreguntasObservableModel.PreguntasfrecuentesObservable> list, int positionStart, int itemCount) {
                notifyItemRangeInserted(positionStart, itemCount);
            }

            @Override
            public void onItemRangeMoved(ObservableList<PreguntasObservableModel.PreguntasfrecuentesObservable> list, int fromPosition, int toPosition, int itemCount) {
                notifyItemMoved(fromPosition, toPosition);
            }

            @Override
            public void onItemRangeRemoved(ObservableList<PreguntasObservableModel.PreguntasfrecuentesObservable> list, int positionStart, int itemCount) {
                notifyItemRangeRemoved(positionStart, itemCount);
            }
        });
    }

    @Override
    public PreguntaItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.item_pregunta, viewGroup, false);
        return new PreguntaItemViewHolder(itemView, viewModel);
    }

    @Override
    public void onBindViewHolder(PreguntaItemViewHolder viewHolder, int position) {

        viewHolder.getCheckSelecionar().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                model.getPreguntas().get(position).setSeleccionado(isChecked);
                viewModel.getModel().getPreguntas().get(position).setSeleccionado(isChecked);
                int cantidad = 0;
                for (int i = 0; i < viewModel.getModel().getPreguntas().size(); i++) {
                    if (viewModel.getModel().getPreguntas().get(i).getSeleccionado()) {
                        cantidad = cantidad + 1;

                    }


                }
                viewModel.getModel().setCantidadSeleccionada(String.valueOf(cantidad));
                addListnerChange();
            }
        });
/*
        viewHolder.getCheckSelecionar().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
viewHolder.viewModel().updateSelecionado(position);
                model.getPreguntas().get(position).setSeleccionado(isChecked);
                addListnerChange();
            }
        });*/

        viewHolder.getLyPregunta().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                model.getPreguntas().get(position).setEditarItem(1);
//model.getPreguntas().get(position).setSeleccionado(true);
                for (int i = 0; i < model.getPreguntas().size(); i++) {
                    model.getPreguntas().get(i).setEditarItem(1);
                }
                viewModel.getModel().setEditar(1);
                addListnerChange();
                return false;
            }
        });


        for (PreguntasObservableModel.PreguntasfrecuentesObservable.RespuestasItem respuestasItem : model.getPreguntas().get(position).getRespuestas()) {


            TextView respuesta = new TextView(context);
            respuesta.setText(respuestasItem.getRespuesta());
            respuesta.setTag(respuestasItem.getIdRespuesta());
            respuesta.setPadding(0, 16, 0, 16);

            viewHolder.getLyrespuestas().addView(respuesta);
         /*   if(model.getPreguntas().get(position).getOpen()){
                respuesta.setVisibility(View.VISIBLE);

            }else
            {
                respuesta.setVisibility(View.GONE);
            }*/

        }
        viewHolder.viewModel().update(model.getPreguntas().get(position));
        viewHolder.executePendingBindings();

    }

    @Override
    public int getItemCount() {
        return model.getPreguntas().size();
    }

}
