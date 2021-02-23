package pe.com.distriluz.app.injection.modules;


import dagger.Binds;
import dagger.Module;
import pe.com.distriluz.app.ui.appslista.AppListaMvvm;
import pe.com.distriluz.app.ui.appslista.AppListaViewModel;
import pe.com.distriluz.app.ui.appslista.recyclerView.AppsItemMvvm;
import pe.com.distriluz.app.ui.appslista.recyclerView.AppsItemViewModel;
import pe.com.distriluz.app.ui.changepassword.ChangePasswordMvvm;
import pe.com.distriluz.app.ui.changepassword.ChangePasswordViewModel;
import pe.com.distriluz.app.ui.clientelistar.ClienteListarMvvm;
import pe.com.distriluz.app.ui.clientelistar.ClienteListarViewModel;
import pe.com.distriluz.app.ui.clientelistar.navigatoritems.NavigatorItemMvvm;
import pe.com.distriluz.app.ui.clientelistar.navigatoritems.NavigatorItemViewModel;
import pe.com.distriluz.app.ui.codeconfirm.CodeConfirmMvvm;
import pe.com.distriluz.app.ui.codeconfirm.CodeConfirmViewModel;
import pe.com.distriluz.app.ui.editprofile.EditProfileMvvm;
import pe.com.distriluz.app.ui.editprofile.EditProfileViewModel;
import pe.com.distriluz.app.ui.login.LoginMvvm;
import pe.com.distriluz.app.ui.login.LoginViewModel;
import pe.com.distriluz.app.ui.preguntas.PreguntasMvvm;
import pe.com.distriluz.app.ui.preguntas.PreguntasViewModel;
import pe.com.distriluz.app.ui.preguntas.recyclerview.PreguntaItemMvvm;
import pe.com.distriluz.app.ui.preguntas.recyclerview.PreguntaItemViewModel;
import pe.com.distriluz.app.ui.profile.ProfileMvvm;
import pe.com.distriluz.app.ui.profile.ProfileViewModel;
import pe.com.distriluz.app.ui.restorepassword.RestorePasswordMvvm;
import pe.com.distriluz.app.ui.restorepassword.RestorePasswordViewModel;
import pe.com.distriluz.app.ui.validatecode.ValidateCodeMvvm;
import pe.com.distriluz.app.ui.validatecode.ValidateCodeViewModel;


@Module
public abstract class ViewModelModule {
    @Binds
    abstract LoginMvvm.ViewModel bindLoginViewModel(LoginViewModel viewModel);
    @Binds
    abstract ChangePasswordMvvm.ViewModel bindChangePasswordViewModel(ChangePasswordViewModel  viewModel);
    @Binds
    abstract CodeConfirmMvvm.ViewModel bindCodeConfirmViewModel(CodeConfirmViewModel viewModel);
    @Binds
    abstract ClienteListarMvvm.ViewModel bindClienteListarViewModel(ClienteListarViewModel viewModel);
    @Binds
    abstract ValidateCodeMvvm.ViewModel bindValidateCodeViewModel(ValidateCodeViewModel viewModel);
    @Binds
    abstract RestorePasswordMvvm.ViewModel bindRestorePasswordViewModel(RestorePasswordViewModel viewModel);
    @Binds
    abstract NavigatorItemMvvm.ViewModel bindNavigatorItemViewModel(NavigatorItemViewModel viewModel);
    @Binds
    abstract PreguntasMvvm.ViewModel bindPreguntasViewModel(PreguntasViewModel viewModel);
    @Binds
    abstract AppListaMvvm.ViewModel bindAppListaViewModel(AppListaViewModel viewModel);
    @Binds
    abstract AppsItemMvvm.ViewModel bindAppsItemViewModel(AppsItemViewModel viewModel);
    @Binds
    abstract ProfileMvvm.ViewModel bindProfileViewModel(ProfileViewModel viewModel);
    @Binds
    abstract EditProfileMvvm.ViewModel bindEditProfileViewModel(EditProfileViewModel viewModel);
    @Binds
    abstract PreguntaItemMvvm.ViewModel bindPreguntaItemViewModel(PreguntaItemViewModel viewModel);
}
