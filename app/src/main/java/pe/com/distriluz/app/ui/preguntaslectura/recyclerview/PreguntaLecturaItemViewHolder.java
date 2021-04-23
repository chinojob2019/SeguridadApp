package pe.com.distriluz.app.ui.preguntaslectura.recyclerview;

import android.view.View;
import android.widget.LinearLayout;

import pe.com.distriluz.app.databinding.ItemPreguntaBinding;
import pe.com.distriluz.app.databinding.ItemPreguntaLecturaBinding;
import pe.com.distriluz.app.ui.base.BaseViewHolder;


public class PreguntaLecturaItemViewHolder extends BaseViewHolder<ItemPreguntaLecturaBinding, PreguntaLecturaItemMvvm.ViewModel> implements PreguntaLecturaItemMvvm.View {

LinearLayout lyrespuestas;

    public PreguntaLecturaItemViewHolder(View v) {
        super(v);
        viewHolderComponent().inject(this);
        bindContentView(v);


    }

    public LinearLayout getLyrespuestas() {
        return binding.lyrespuestas;
    }
}
