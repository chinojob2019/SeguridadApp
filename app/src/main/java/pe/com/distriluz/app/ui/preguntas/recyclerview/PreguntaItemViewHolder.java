package pe.com.distriluz.app.ui.preguntas.recyclerview;

import android.view.View;
import android.widget.LinearLayout;

import pe.com.distriluz.app.R;
import pe.com.distriluz.app.databinding.ItemPreguntaBinding;
import pe.com.distriluz.app.ui.base.BaseViewHolder;


public class PreguntaItemViewHolder extends BaseViewHolder<ItemPreguntaBinding, PreguntaItemMvvm.ViewModel> implements PreguntaItemMvvm.View {

LinearLayout lyrespuestas;

    public PreguntaItemViewHolder(View v) {
        super(v);
        viewHolderComponent().inject(this);
        bindContentView(v);


    }

    public LinearLayout getLyrespuestas() {
        return binding.lyrespuestas;
    }
}
