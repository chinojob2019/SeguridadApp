package pe.com.distriluz.app.injection.components;

import android.content.Context;

import androidx.fragment.app.FragmentManager;

import dagger.Component;
import pe.com.distriluz.app.injection.modules.ActivityModule;
import pe.com.distriluz.app.injection.modules.ViewModelModule;
import pe.com.distriluz.app.injection.qualifier.ActivityContext;
import pe.com.distriluz.app.injection.qualifier.ActivityFragmentManager;
import pe.com.distriluz.app.injection.scopes.PerActivity;
import pe.com.distriluz.app.ui.addpregunta.AddPreguntaActivity;
import pe.com.distriluz.app.ui.addrepuesta.AddRespuestaActivity;
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
import pe.com.distriluz.app.ui.updatepregunta.UpdatePreguntaActivity;
import pe.com.distriluz.app.ui.updaterespuesta.UpdateRespuestaActivity;
import pe.com.distriluz.app.ui.validatecode.ValidateCodeActivity;
import pe.com.distriluz.domain.interactor.AddPreguntaUseCase;
import pe.com.distriluz.domain.interactor.AddRespuestaUseCase;
import pe.com.distriluz.domain.interactor.ChangePasswordUseCase;
import pe.com.distriluz.domain.interactor.GetMenuUseCase;
import pe.com.distriluz.domain.interactor.GetParametrosUseCase;
import pe.com.distriluz.domain.interactor.LoginUseCase;
import pe.com.distriluz.domain.interactor.UpdatePreguntaUseCase;
import pe.com.distriluz.domain.interactor.UpdateRespuestaUseCase;


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
    GetMenuUseCase getMenu();

    void inject(CodeConfirmActivity codeConfirmActivity);

    void inject(ValidateCodeActivity validateCodeActivity);

    void inject(RestorePasswordActivity restorePasswordActivity);

    void inject(OkRestorePassActivity okRestorePassActivity);

    void inject(EditProfileActivity editProfileActivity);
    GetParametrosUseCase getParametro();

    void inject(AddPreguntaActivity addPreguntaActivity);

    AddPreguntaUseCase addPregunta();


    void inject(AddRespuestaActivity addRespuestaActivity);
    AddRespuestaUseCase addRespuesta();

    void inject(UpdatePreguntaActivity updatePreguntaActivity);
    UpdatePreguntaUseCase updatePregunta();

    void inject(UpdateRespuestaActivity updateRespuestaActivity);
    UpdateRespuestaUseCase updateRespuesta();

}
