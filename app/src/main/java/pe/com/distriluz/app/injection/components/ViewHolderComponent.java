package pe.com.distriluz.app.injection.components;


import dagger.Component;
import pe.com.distriluz.app.injection.modules.ViewHolderModule;
import pe.com.distriluz.app.injection.modules.ViewModelModule;
import pe.com.distriluz.app.injection.scopes.PerViewHolder;
import pe.com.distriluz.app.ui.appslista.recyclerView.AppsListViewHolder;
import pe.com.distriluz.app.ui.appslista.recyclerView.AppsViewHolder;
import pe.com.distriluz.app.ui.clientelistar.navigatoritems.NavigatorItemViewHolder;
import pe.com.distriluz.app.ui.preguntas.recyclerview.PreguntaItemViewHolder;
import pe.com.distriluz.app.ui.preguntaslectura.recyclerview.PreguntaLecturaItemViewHolder;


@PerViewHolder
@Component(dependencies = ActivityComponent.class, modules = {ViewHolderModule.class, ViewModelModule.class})
public interface ViewHolderComponent {
    void inject(NavigatorItemViewHolder navigatorItemViewHolder);

    void inject(AppsViewHolder appsViewHolder);

    void inject(AppsListViewHolder appsListViewHolder);

    void inject(PreguntaItemViewHolder preguntaItemViewHolder);

    void inject(PreguntaLecturaItemViewHolder preguntaLecturaItemViewHolder);


    // create inject methods for your ViewHolders here
}
