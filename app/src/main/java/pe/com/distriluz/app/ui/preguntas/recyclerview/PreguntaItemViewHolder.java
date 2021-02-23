package pe.com.distriluz.app.ui.preguntas.recyclerview;

import android.view.View;

import pe.com.distriluz.app.databinding.ItemPreguntaBinding;
import pe.com.distriluz.app.ui.base.BaseViewHolder;


public class PreguntaItemViewHolder extends BaseViewHolder<ItemPreguntaBinding, PreguntaItemMvvm.ViewModel> implements PreguntaItemMvvm.View {



    public PreguntaItemViewHolder(View v) {
        super(v);
        viewHolderComponent().inject(this);
        bindContentView(v);
    }

}
