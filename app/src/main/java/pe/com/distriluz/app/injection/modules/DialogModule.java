package pe.com.distriluz.app.injection.modules;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import dagger.Module;
import dagger.Provides;
import pe.com.distriluz.app.injection.qualifier.ChildFragmentManager;
import pe.com.distriluz.app.injection.scopes.PerDialogFragment;
import pe.com.distriluz.app.ui.base.navigator.DialogFragmentNavigator;
import pe.com.distriluz.app.ui.base.navigator.DialogNavigator;

@Module
public class DialogModule {

    private final DialogFragment mDialogFragment;

    public DialogModule(DialogFragment dialogFragment) {
        mDialogFragment = dialogFragment;
    }

    @Provides
    @PerDialogFragment
    DialogNavigator provideDialogFragmentNavigator() {
        return new DialogFragmentNavigator(mDialogFragment);
    }

    @Provides
    @PerDialogFragment
    @ChildFragmentManager
    FragmentManager provideFragmentManager() {
        return mDialogFragment.getChildFragmentManager();
    }

}
