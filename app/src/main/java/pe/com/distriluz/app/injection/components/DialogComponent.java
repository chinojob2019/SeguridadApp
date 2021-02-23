package pe.com.distriluz.app.injection.components;


import androidx.fragment.app.FragmentManager;

import dagger.Component;
import pe.com.distriluz.app.injection.modules.DialogModule;
import pe.com.distriluz.app.injection.modules.ViewModelModule;
import pe.com.distriluz.app.injection.qualifier.ChildFragmentManager;
import pe.com.distriluz.app.injection.scopes.PerDialogFragment;
import pe.com.distriluz.app.injection.scopes.PerFragment;
import pe.com.distriluz.app.ui.alerts.AlertEmailErrorDialog;
import pe.com.distriluz.app.ui.alerts.AlertLoadingDialog;
import pe.com.distriluz.app.ui.alerts.AlertSelectPhotoDialog;


@PerDialogFragment
@PerFragment
@Component(dependencies = ActivityComponent.class, modules = {DialogModule.class, ViewModelModule.class})
public interface DialogComponent {

    @ChildFragmentManager
    FragmentManager defaultFragmentManager();

    void inject(AlertEmailErrorDialog alertEmailError);



    void inject(AlertLoadingDialog alertLoadingDialog);

    void inject(AlertSelectPhotoDialog alertSelectPhotoDialog);


    // create inject methods for your DialogFragments here
}
