package pe.com.distriluz.app.ui.clientelistar;


import android.graphics.drawable.Drawable;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;

import pe.com.distriluz.app.ApplicationContext;
import pe.com.distriluz.data.utiles.Utils;

/**
 * Created by pedro.zevallos on 9/07/2017.
 */

public class ClienteListarObservableModel extends BaseObservable {

    private ObservableList<NavigationItems> listItemsMenu = new ObservableArrayList<>();
    private Integer itemSelectPos = 0;
    private String query =  "";

    @Bindable
    public String getQuery() {
        return query;
    }
    @Bindable
    public String getSaludo() {
        return "¡Bienvenido, " + getName() + "!";
    }
    @Bindable
    public String getName() {
        return Utils.getfirstname(ApplicationContext.getInstance());
    }

    @Bindable
    public String getEmpresa() {
        try{
            return Utils.getInfo(ApplicationContext.getInstance()).getCorporativos().getEmpresa();
        }catch (Exception e){
            return "";
        }
    }
    @Bindable
    public String getLogin() {
        try{
            return Utils.getInfo(ApplicationContext.getInstance()).getPersonales().getLogin();
        }catch (Exception e){
            return "";
        }
    }
    public String getFoto() {
        try{
            return Utils.getInfo(ApplicationContext.getInstance()).getPersonales().getFoto();
        }catch (Exception e){
            return "";
        }
    }

    public void setQuery(String query) {
        this.query = query;
        notifyPropertyChanged(pe.com.distriluz.app.BR.query);
    }

    @Bindable
    public ObservableList<NavigationItems> getListItemsMenu() {
        return listItemsMenu;
    }

    public void setListItemsMenu(ObservableList<NavigationItems> listItemsMenu) {
        this.listItemsMenu = listItemsMenu;
        notifyPropertyChanged(pe.com.distriluz.app.BR.listItemsMenu);
    }

    @Bindable
    public Integer getItemSelectPos() {
        return itemSelectPos;
    }

    public Integer getTypeItemSelect() {
        return listItemsMenu.get(itemSelectPos).type;
    }

    public void setItemSelectPos(Integer itemSelectPos) {
        this.itemSelectPos = itemSelectPos;
        notifyPropertyChanged(pe.com.distriluz.app.BR.itemSelectPos);
    }

    public static class NavigationItems extends BaseObservable {

        String title, subtitle;
        Drawable icon;
        Integer type;

        public NavigationItems(String title, String subtitle, Drawable icon, Integer type) {
            this.title = title;
            this.subtitle = subtitle;
            this.icon = icon;
            this.type = type;
        }

        @Bindable
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
            notifyPropertyChanged(pe.com.distriluz.app.BR.title);
        }

        @Bindable
        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
            notifyPropertyChanged(pe.com.distriluz.app.BR.subtitle);
        }

        @Bindable
        public Drawable getIcon() {
            return icon;
        }

        public void setIcon(Drawable icon) {
            this.icon = icon;
            notifyPropertyChanged(pe.com.distriluz.app.BR.icon);
        }

        @Bindable
        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
            notifyPropertyChanged(pe.com.distriluz.app.BR.type);
        }
    }
}
