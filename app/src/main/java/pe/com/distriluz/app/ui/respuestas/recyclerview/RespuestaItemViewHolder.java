package pe.com.distriluz.app.ui.respuestas.recyclerview;

import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import androidx.constraintlayout.widget.ConstraintLayout;

import pe.com.distriluz.app.databinding.ItemRespuestaBinding;
import pe.com.distriluz.app.ui.base.BaseViewHolder;
import pe.com.distriluz.app.ui.respuestas.RespuestasMvvm;
import pe.com.distriluz.app.ui.respuestas.RespuestasObservableModel;
import pe.com.distriluz.app.ui.respuestas.recyclerview.RespuestaItemMvvm;


public class RespuestaItemViewHolder extends BaseViewHolder<ItemRespuestaBinding, RespuestaItemMvvm.ViewModel> implements RespuestaItemMvvm.View {

LinearLayout lyrespuestas;

private final RespuestasMvvm.ViewModel viewModel;

    public RespuestaItemViewHolder(View v, RespuestasMvvm.ViewModel viewModel) {
        super(v);
        this.viewModel = viewModel;
        viewHolderComponent().inject(this);
        bindContentView(v);


    }



    public ConstraintLayout getLyRespuesta(){
        return binding.linearLayout7;
    }

    public CheckBox getCheckSelecionar(){
        return binding.checkBox;
    }

    @Override
    public void updateRespuesta(RespuestasObservableModel.RespuestasItem item) {

        this.viewModel.onClickEditarRespuesta(item);



    }
}
