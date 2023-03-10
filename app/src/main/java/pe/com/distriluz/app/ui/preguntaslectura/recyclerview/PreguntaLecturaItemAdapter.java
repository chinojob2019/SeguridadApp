package pe.com.distriluz.app.ui.preguntaslectura.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.databinding.ObservableList;
import androidx.recyclerview.widget.RecyclerView;

import javax.inject.Inject;

import pe.com.distriluz.app.R;
import pe.com.distriluz.app.injection.scopes.PerFragment;
import pe.com.distriluz.app.ui.preguntaslectura.PreguntasLecturaObservableModel;


@PerFragment
public class PreguntaLecturaItemAdapter extends RecyclerView.Adapter<PreguntaLecturaItemViewHolder> {

    PreguntasLecturaObservableModel model;
    Context context;


    @Inject
    public PreguntaLecturaItemAdapter() {

    }



    public void setData(PreguntasLecturaObservableModel model, Context context){
        this.model=model;
        this.context= context;
        addListnerChange();
    }

    private void addListnerChange() {
        this.model.getPreguntas().addOnListChangedCallback(new ObservableList.OnListChangedCallback<ObservableList<PreguntasLecturaObservableModel.PreguntasfrecuentesObservable>>() {
            @Override
            public void onChanged(ObservableList<PreguntasLecturaObservableModel.PreguntasfrecuentesObservable> list) {
                notifyDataSetChanged();
            }

            @Override
            public void onItemRangeChanged(ObservableList<PreguntasLecturaObservableModel.PreguntasfrecuentesObservable> list, int positionStart, int itemCount) {
                notifyItemRangeChanged( positionStart, itemCount );
            }

            @Override
            public void onItemRangeInserted(ObservableList<PreguntasLecturaObservableModel.PreguntasfrecuentesObservable> list, int positionStart, int itemCount) {
                notifyItemRangeInserted( positionStart, itemCount );
            }

            @Override
            public void onItemRangeMoved(ObservableList<PreguntasLecturaObservableModel.PreguntasfrecuentesObservable> list, int fromPosition, int toPosition, int itemCount) {
                notifyItemMoved( fromPosition, toPosition );
            }

            @Override
            public void onItemRangeRemoved(ObservableList<PreguntasLecturaObservableModel.PreguntasfrecuentesObservable> list, int positionStart, int itemCount) {
                notifyItemRangeRemoved( positionStart, itemCount );
            }
        });
    }

    @Override
    public PreguntaLecturaItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.item_pregunta_lectura, viewGroup, false);
        return new PreguntaLecturaItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PreguntaLecturaItemViewHolder viewHolder, int position) {

        viewHolder.getLyrespuestas().removeAllViews();
        for(PreguntasLecturaObservableModel.PreguntasfrecuentesObservable.RespuestasItem respuestasItem : model.getPreguntas().get(position).getRespuestas()){

            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);


            ImageView guion = new ImageView(context);
              guion.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_item_respuesta));
 guion.setPadding(0,16,8,0);
            TextView respuesta = new TextView(context);
            respuesta.setText(respuestasItem.getRespuesta());
            respuesta.setTag(respuestasItem.getIdRespuesta());
            respuesta.setPadding(16,16,0,16);
linearLayout.addView(guion);
linearLayout.addView(respuesta);



            viewHolder.getLyrespuestas().addView(linearLayout);
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
