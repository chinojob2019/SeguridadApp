package pe.com.distriluz.app.ui.clientelistar.navigatoritems;

import android.content.Context;
import android.view.View;

import androidx.databinding.ObservableField;

import javax.inject.Inject;

import pe.com.distriluz.app.injection.qualifier.AppContext;
import pe.com.distriluz.app.injection.scopes.PerViewHolder;
import pe.com.distriluz.app.ui.base.navigator.Navigator;
import pe.com.distriluz.app.ui.base.viewmodel.BaseViewHolderViewModel;
import pe.com.distriluz.app.ui.base.viewmodel.IViewModel;
import pe.com.distriluz.app.ui.clientelistar.ClienteListarObservableModel;


@PerViewHolder
public class NavigatorItemViewModel extends BaseViewHolderViewModel<NavigatorItemMvvm.View> implements NavigatorItemMvvm.ViewModel {

    private ClienteListarObservableModel.NavigationItems item;
    private ObservableField<Boolean> isActive = new ObservableField<>(false);
    private IViewModel listener;

    @Inject
    public NavigatorItemViewModel(@AppContext Context context, Navigator navigator) {
        super(context, navigator);
    }

    @Override
    public void onClickItem(View v) {
//        if(!isActive.get()){
            getView().setActive();
            listener.onClickItemMenu(getModel().getType());
//        }
    }

    @Override
    public ObservableField<Boolean> getIsActive() {
        return isActive;
    }

    @Override
    public void update(ClienteListarObservableModel.NavigationItems producto, boolean isActive, IViewModel listener) {
        this.item = producto;
        this.listener = listener;
        this.isActive.set(isActive);
        producto.notifyChange();
        notifyChange();
    }

    @Override
    public ClienteListarObservableModel.NavigationItems getModel() {
        return item;
    }
}
