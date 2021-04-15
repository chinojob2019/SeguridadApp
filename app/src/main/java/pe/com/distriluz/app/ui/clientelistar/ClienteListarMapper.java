package pe.com.distriluz.app.ui.clientelistar;


import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;

import javax.inject.Inject;
import javax.inject.Singleton;

import pe.com.distriluz.app.ApplicationContext;
import pe.com.distriluz.app.R;
import pe.com.distriluz.app.ui.appslista.AppsObservableModel;
import pe.com.distriluz.app.utils.Constantes;
import pe.com.distriluz.domain.model.App;
import pe.com.distriluz.domain.model.Apps;
import pe.com.distriluz.domain.model.OpcionesMenu;

/**
 * domain layer.
 */
@Singleton
public class ClienteListarMapper {


    @Inject
    public ClienteListarMapper() {
    }

    public void mapperOpcionesMenu(ClienteListarObservableModel model, OpcionesMenu apps) {
        ObservableList<ClienteListarObservableModel.NavigationItems> opciones= new ObservableArrayList<>();

        for(OpcionesMenu.OpcionesMenuItem item : apps.getOpcionesMenu()) {
            ClienteListarObservableModel.NavigationItems navigationItems = new ClienteListarObservableModel.NavigationItems();



            switch (item.getImagen())
            {
                case "ic_menu_home":
                    navigationItems.icon = ApplicationContext.getInstance().getResources().getDrawable(R.drawable.ic_menu_home);
                    break;
                case "ic_menu_questions":
                    navigationItems.icon = ApplicationContext.getInstance().getResources().getDrawable(R.drawable.ic_menu_questions);
                    break;
                case "ic_menu_servicio":
                    navigationItems.icon = ApplicationContext.getInstance().getResources().getDrawable(R.drawable.ic_mesa_servicio);
                    break;
                default:
                    navigationItems.icon = ApplicationContext.getInstance().getResources().getDrawable(R.drawable.ic_menu_default);
                    break;

            }



            switch (item.getVista().getEnsamblado()) {
                case "AppListaFragment":
                   // navigationItems.icon = ApplicationContext.getInstance().getResources().getDrawable(R.drawable.ic_menu_home);
                    navigationItems.title = item.getVista().getNombre();
                    navigationItems.subtitle = item.getVista().getDescripcion();
                    navigationItems.type = Constantes.MENU_ITEM_LISTA_INICIO;
                    opciones.add(navigationItems);
                    break;
                case "PreguntasFragment":
                //    navigationItems.icon = ApplicationContext.getInstance().getResources().getDrawable(R.drawable.ic_menu_questions);
                    navigationItems.title = item.getVista().getNombre();
                    navigationItems.subtitle = item.getVista().getDescripcion();
                    navigationItems.type = Constantes.MENU_ITEM_PREGUNTAS;
                    opciones.add(navigationItems);
                    break;

                case "MesaServicio":
                 //  navigationItems.icon = ApplicationContext.getInstance().getResources().getDrawable(R.drawable.ic_mesa_servicio);
                    navigationItems.title = item.getVista().getNombre();
                    navigationItems.subtitle = item.getVista().getDescripcion();
                    navigationItems.type = Constantes.MENU_ITEM_MESA_SERVICIO;
                    opciones.add(navigationItems);
                    break;

                default:

                    navigationItems.title = item.getVista().getNombre();
                    navigationItems.subtitle = item.getVista().getDescripcion();
                    navigationItems.type = Constantes.MENU_ITEM_NO_DEFINIDO;
                    opciones.add(navigationItems);
                    break;
            }


        }
        model.setListItemsMenu(opciones);
        model.notifyChange();
    }



}
