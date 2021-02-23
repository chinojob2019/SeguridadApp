package pe.com.distriluz.app.injection.components;

import android.content.Context;

import androidx.fragment.app.FragmentManager;

import dagger.Component;
import pe.com.distriluz.app.injection.modules.ActivityModule;
import pe.com.distriluz.app.injection.modules.ViewModelModule;
import pe.com.distriluz.app.injection.qualifier.ActivityContext;
import pe.com.distriluz.app.injection.qualifier.ActivityFragmentManager;
import pe.com.distriluz.app.injection.scopes.PerActivity;
import pe.com.distriluz.app.ui.appslista.AppsListaMapper;
import pe.com.distriluz.app.ui.base.navigator.Navigator;
import pe.com.distriluz.app.ui.changepassword.ChangePasswordActivity;
import pe.com.distriluz.app.ui.clientelistar.ClienteListarActivity;
import pe.com.distriluz.app.ui.clientelistar.ClienteListarMapper;
import pe.com.distriluz.app.ui.codeconfirm.CodeConfirmActivity;
import pe.com.distriluz.app.ui.editprofile.EditProfileActivity;
import pe.com.distriluz.app.ui.login.LoginActivity;
import pe.com.distriluz.app.ui.login.LoginMapper;
import pe.com.distriluz.app.ui.okrestorepass.OkRestorePassActivity;
import pe.com.distriluz.app.ui.restorepassword.RestorePasswordActivity;
import pe.com.distriluz.app.ui.validatecode.ValidateCodeActivity;
import pe.com.distriluz.domain.interactor.ChangePasswordUseCase;
import pe.com.distriluz.domain.interactor.LoginUseCase;


@PerActivity
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class, ViewModelModule.class})
public interface ActivityComponent extends AppComponent {

    @ActivityContext
    Context activityContext();

    @ActivityFragmentManager
    FragmentManager defaultFragmentManager();
    Navigator navigator();

    //mappers
    LoginMapper loginMapper();
    ClienteListarMapper clienteListarMapper();
    AppsListaMapper appsListaMapper();
   // CodeConfirmMapper codeConfirmMapper();
   void inject(LoginActivity activity);
    // inject Activities


    void inject(ChangePasswordActivity changePasswordActivity);
  //  void inject(CodeConfirmActivity codeConfirmActivity);
  void inject(ClienteListarActivity activity);

    //UseCase
    LoginUseCase loginUseCase();
    ChangePasswordUseCase changePassword();

    void inject(CodeConfirmActivity codeConfirmActivity);

    void inject(ValidateCodeActivity validateCodeActivity);

    void inject(RestorePasswordActivity restorePasswordActivity);

    void inject(OkRestorePassActivity okRestorePassActivity);

    void inject(EditProfileActivity editProfileActivity);
}
