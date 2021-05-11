package pe.com.distriluz.app.ui.clientelistar;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import javax.inject.Inject;

import pe.com.distriluz.app.R;
import pe.com.distriluz.app.injection.qualifier.AppContext;
import pe.com.distriluz.app.injection.scopes.PerActivity;
import pe.com.distriluz.app.ui.appslista.AppListaFragment;
import pe.com.distriluz.app.ui.appslista.AppsListaMapper;
import pe.com.distriluz.app.ui.base.navigator.Navigator;
import pe.com.distriluz.app.ui.base.viewmodel.BaseActivityViewModel;
import pe.com.distriluz.app.ui.preguntas.PreguntasFragment;
import pe.com.distriluz.app.ui.preguntaslectura.PreguntasLecturaFragment;
import pe.com.distriluz.app.ui.profile.ProfileFragment;
import pe.com.distriluz.app.ui.restorepassword.RestorePasswordActivity;
import pe.com.distriluz.app.utils.Constantes;
import pe.com.distriluz.domain.interactor.GetAppsUseCase;
import pe.com.distriluz.domain.interactor.GetMenuUseCase;
import pe.com.distriluz.domain.interactor.baseinteractors.DefaultObserverSingle;
import pe.com.distriluz.domain.model.Apps;
import pe.com.distriluz.domain.model.OpcionesMenu;

@PerActivity
public class ClienteListarViewModel extends BaseActivityViewModel<ClienteListarMvvm.View> implements ClienteListarMvvm.ViewModel {
    private final Resources resources;
    private GetMenuUseCase getMenuUseCase;
    private ClienteListarMapper mapper;
    private ClienteListarObservableModel model = new ClienteListarObservableModel();
private Context context;
    // TODO falta crear obserbale string
    @Inject
    public ClienteListarViewModel(@AppContext Context appContext, Navigator navigator, Resources resources, GetMenuUseCase getMenuUseCase, ClienteListarMapper mapper) {
        super(appContext, navigator);
        this.resources = resources;
        this.context=appContext;
        this.getMenuUseCase = getMenuUseCase;
        this.mapper = mapper;
    //  additemsMenu();
        getAllOpciones();


    }


    public void getAllOpciones() {
        showLoading();
        getMenuUseCase.execute(new DefaultObserverSingle<OpcionesMenu>(){
            @Override
            public void onSuccess(OpcionesMenu opciones) {
                hideLoading();
                mapper.mapperOpcionesMenu(model,opciones);
                additemsMenu();
                model.notifyChange();
                getView().updateAdapter();

                if(model.getListItemsMenu().size()>0 && model.getListItemsMenu().get(0).type != Constantes.MENU_ITEM_CERRAR_SESSION){

                    onClickItemMenu(model.getListItemsMenu().get(0).type);

                }

                iniciarFragmentHome();
            }

            @Override
            public void onError(Throwable e) {
                hideLoading();
                additemsMenu();
               if( !validateErrorToken(e))
               {
                e.printStackTrace();
                showError(e);

               }
            }
        },null);
    }


    @Override
    public void attachView(ClienteListarMvvm.View mvvmView, @Nullable Bundle savedInstanceState) {
        super.attachView(mvvmView, savedInstanceState);
      //  navigator.inflateFragment(R.id.box_fragment, new AppListaFragment(model),null);
        navigator.hideKeyboard();
    }

    private void iniciarFragmentHome() {
        getModel().setItemSelectPos(0);

    }

    private void additemsMenu() {
        /*
        model.getListItemsMenu().add(
                new ClienteListarObservableModel.NavigationItems(
                        "Inicio",
                        "Descripción corta para este item",
                        resources.getDrawable(R.drawable.ic_menu_home),
                        Constantes.MENU_ITEM_LISTA_INICIO));
        model.getListItemsMenu().add(
                new ClienteListarObservableModel.NavigationItems(
                        "Preguntas frecuentes",
                        "Descripción corta para este item",
                        resources.getDrawable(R.drawable.ic_menu_questions),
                        Constantes.MENU_ITEM_PREGUNTAS));
        model.getListItemsMenu().add(
                new ClienteListarObservableModel.NavigationItems(
                        "Mesa de servicio",
                        "Descripción corta para este item",
                        resources.getDrawable(R.drawable.ic_mesa_servicio),
                        Constantes.MENU_ITEM_MESA_SERVICIO));*/
        model.getListItemsMenu().add(
                new ClienteListarObservableModel.NavigationItems(
                        "Cerrar sesión",
                        "",
                        resources.getDrawable(R.drawable.ic_menu_cerrar_sesion),
                        Constantes.MENU_ITEM_CERRAR_SESSION));
    }

    @Override
    public ClienteListarObservableModel getModel() {
        return model;
    }

    @Override
    public void onClickOpenDrawer(View view) {
        navigator.openDrawer();
    }

    @Override
    public void onClickOpenProfile(View view) {
        model.setItemSelectPos(999);
        getView().updateAdapter();
        navigator.closeDrawer();
        navigator.inflateFragment(R.id.box_fragment, new ProfileFragment(this),null);
    }

    @Override
    public void onClickItemMenu(Integer type) {
        switch (type)  {
            case Constantes.MENU_ITEM_CERRAR_SESSION:
                navigator.closeDrawer();
                navigator.clearSession();
                break;
            case Constantes.MENU_ITEM_MESA_SERVICIO:
                navigator.closeDrawer();
                Uri uri= Uri.parse("url");
                Intent intent= new Intent(Intent.ACTION_VIEW,uri);
                context.startActivity(intent);
                break;
            case Constantes.MENU_ITEM_LISTA_INICIO:
                navigator.closeDrawer();
                navigator.inflateFragment(R.id.box_fragment, new AppListaFragment(model),null);
                break;
            case Constantes.MENU_ITEM_PREGUNTAS:
                navigator.closeDrawer();
                navigator.inflateFragment(R.id.box_fragment, new PreguntasFragment(),null);
                break;
            case Constantes.MENU_ITEM_PREGUNTAS_LECTURA:
                navigator.closeDrawer();
                navigator.inflateFragment(R.id.box_fragment, new PreguntasLecturaFragment(),null);
                break;
            default:
                Toast.makeText(context,"No se encuentra vista asociada", Toast.LENGTH_LONG).show();
                break;
        }

    }
}

