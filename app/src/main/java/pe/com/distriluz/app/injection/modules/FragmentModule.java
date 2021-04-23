package pe.com.distriluz.app.injection.modules;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import dagger.Module;
import dagger.Provides;
import pe.com.distriluz.app.injection.qualifier.ChildFragmentManager;
import pe.com.distriluz.app.injection.scopes.PerActivity;
import pe.com.distriluz.app.injection.scopes.PerFragment;
import pe.com.distriluz.app.ui.appslista.AppsListaMapper;
import pe.com.distriluz.app.ui.base.navigator.ChildFragmentNavigator;
import pe.com.distriluz.app.ui.base.navigator.FragmentNavigator;
import pe.com.distriluz.app.ui.preguntas.PreguntasMapper;
import pe.com.distriluz.app.ui.preguntaslectura.PreguntasLecturaMapper;
import pe.com.distriluz.app.ui.profile.ProfileMapper;

@Module
public class FragmentModule {

    private final Fragment mFragment;

    public FragmentModule(Fragment fragment) {
        mFragment = fragment;
    }

    @Provides
    @PerFragment
    @ChildFragmentManager
    FragmentManager provideChildFragmentManager() {
        return mFragment.getChildFragmentManager();
    }

    @Provides
    @PerFragment
    FragmentNavigator provideFragmentNavigator() {
        return new ChildFragmentNavigator(mFragment);
    }


    @Provides
    @PerFragment
    ProfileMapper provideProfileMapper() {
        return new ProfileMapper();
    }

    @Provides
    @PerFragment
    PreguntasMapper providePreguntasMapper() {
        return new PreguntasMapper();
    }

    @Provides
    @PerFragment
    PreguntasLecturaMapper providePreguntasLecturaMapper() {
        return new PreguntasLecturaMapper();
    }

}
