package pe.com.distriluz.app.ui.base.viewmodel;

import androidx.databinding.ObservableBoolean;
import androidx.recyclerview.widget.RecyclerView;

import pe.com.distriluz.app.ui.base.view.MvvmView;


public interface AdapterMvvmViewModel<V extends MvvmView> extends MvvmViewModel<V> {

    RecyclerView.Adapter getAdapter();

    ObservableBoolean getEmpty();
}
