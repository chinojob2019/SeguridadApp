package pe.com.distriluz.app.ui.preguntas.recyclerview;

import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import androidx.constraintlayout.widget.ConstraintLayout;

import pe.com.distriluz.app.databinding.ItemPreguntaBinding;
import pe.com.distriluz.app.ui.base.BaseViewHolder;
import pe.com.distriluz.app.ui.preguntas.PreguntasMvvm;
import pe.com.distriluz.app.ui.preguntas.PreguntasObservableModel;


public class PreguntaItemViewHolder extends BaseViewHolder<ItemPreguntaBinding, PreguntaItemMvvm.ViewModel> implements PreguntaItemMvvm.View {

LinearLayout lyrespuestas;

private final PreguntasMvvm.ViewModel viewModel;

    public PreguntaItemViewHolder(View v, PreguntasMvvm.ViewModel viewModel) {
        super(v);
        this.viewModel = viewModel;
        viewHolderComponent().inject(this);
        bindContentView(v);


    }



    public ConstraintLayout getLyPregunta(){
        return binding.linearLayout7;
    }

    public CheckBox getCheckSelecionar(){
        return binding.checkBox;
    }

    @Override
    public void onclickListaRespuestas(PreguntasObservableModel.PreguntasfrecuentesObservable item) {


        this.viewModel.onClickIrListadoRespuestas(item);
    }
}
