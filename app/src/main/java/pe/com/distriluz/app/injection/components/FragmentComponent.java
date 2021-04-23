package pe.com.distriluz.app.injection.components;

import androidx.fragment.app.FragmentManager;

import dagger.Component;
import pe.com.distriluz.app.injection.modules.FragmentModule;
import pe.com.distriluz.app.injection.modules.ViewModelModule;
import pe.com.distriluz.app.injection.qualifier.ChildFragmentManager;
import pe.com.distriluz.app.injection.scopes.PerFragment;
import pe.com.distriluz.app.ui.appslista.AppListaFragment;
import pe.com.distriluz.app.ui.preguntas.PreguntasFragment;
import pe.com.distriluz.app.ui.preguntas.PreguntasMapper;

import pe.com.distriluz.app.ui.preguntaslectura.PreguntasLecturaFragment;
import pe.com.distriluz.app.ui.preguntaslectura.PreguntasLecturaMapper;
import pe.com.distriluz.app.ui.profile.ProfileFragment;
import pe.com.distriluz.app.ui.profile.ProfileMapper;

@PerFragment
@Component(dependencies = ActivityComponent.class, modules = {FragmentModule.class, ViewModelModule.class})
public interface FragmentComponent {

    @ChildFragmentManager
    FragmentManager defaultFragmentManager();

    void inject(AppListaFragment appListaFragment);

    void inject(PreguntasFragment preguntasFragment);

    void inject(PreguntasLecturaFragment preguntasLecturaFragment);

    void inject(ProfileFragment profileFragment);


    ProfileMapper profileMapper();

    PreguntasMapper preguntasMapper();

    PreguntasLecturaMapper preguntasLecturaMapper();
}
