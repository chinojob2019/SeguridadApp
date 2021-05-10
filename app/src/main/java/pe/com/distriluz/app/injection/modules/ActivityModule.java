package pe.com.distriluz.app.injection.modules;

import android.content.Context;

import androidx.fragment.app.FragmentManager;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import pe.com.distriluz.app.injection.qualifier.ActivityContext;
import pe.com.distriluz.app.injection.qualifier.ActivityFragmentManager;
import pe.com.distriluz.app.injection.scopes.PerActivity;
import pe.com.distriluz.app.ui.appslista.AppsListaMapper;
import pe.com.distriluz.app.ui.base.BaseActivity;
import pe.com.distriluz.app.ui.base.navigator.ActivityNavigator;
import pe.com.distriluz.app.ui.base.navigator.Navigator;
import pe.com.distriluz.app.ui.clientelistar.ClienteListarMapper;
import pe.com.distriluz.app.ui.codeconfirm.CodeConfirmMapper;
import pe.com.distriluz.app.ui.login.LoginMapper;
import pe.com.distriluz.domain.executor.PostExecutionThread;
import pe.com.distriluz.domain.executor.ThreadExecutor;
import pe.com.distriluz.domain.interactor.AddPreguntaUseCase;
import pe.com.distriluz.domain.interactor.AddRespuestaUseCase;
import pe.com.distriluz.domain.interactor.ChangePasswordUseCase;
import pe.com.distriluz.domain.interactor.GetMenuUseCase;
import pe.com.distriluz.domain.interactor.GetParametrosUseCase;
import pe.com.distriluz.domain.interactor.LoginUseCase;
import pe.com.distriluz.domain.interactor.UpdatePreguntaUseCase;
import pe.com.distriluz.domain.interactor.UpdateRespuestaUseCase;
import pe.com.distriluz.domain.repository.AccesoRepository;
import pe.com.distriluz.domain.repository.AppsRepository;
import pe.com.distriluz.domain.repository.AuthRepository;



@Module
public class ActivityModule {

    private final BaseActivity mActivity;

    public ActivityModule(BaseActivity activity) {
        mActivity = activity;
    }

    @Provides
    @PerActivity
    @ActivityContext
    Context provideActivityContext() {
        return mActivity;
    }

    @Provides
    @PerActivity
    @ActivityFragmentManager
    FragmentManager provideFragmentManager() {
        return mActivity.getSupportFragmentManager();
    }

    @Provides
    @PerActivity
    Navigator provideNavigator() {
        return new ActivityNavigator(mActivity);
    }


    //Mapper
    @Provides
    @PerActivity
    LoginMapper provideLoginMapper() {
        return new LoginMapper();
    }

    @Provides
    @PerActivity
    ClienteListarMapper provideClienteListarMapper() {
        return new ClienteListarMapper();
    }

    @Provides
    @PerActivity
    CodeConfirmMapper provideCodeConfirmMapper() {
        return new CodeConfirmMapper();
    }

    @Provides
    @PerActivity
    AppsListaMapper provideAppsListaMapper() {
        return new AppsListaMapper();
    }

    //UseCase
    @Provides
    @Named("LoginUseCase")
    LoginUseCase provideLoginUseCase(AuthRepository repository, ThreadExecutor threadExecutor,
                                     PostExecutionThread postExecutionThread) {
        return new LoginUseCase(repository, threadExecutor, postExecutionThread);
    }

    @Provides
    @Named("ChangePasswordUseCase")
    ChangePasswordUseCase provideChangePasswordUseCase(AuthRepository repository, ThreadExecutor threadExecutor,
                                              PostExecutionThread postExecutionThread) {
        return new ChangePasswordUseCase(repository, threadExecutor, postExecutionThread);
    }

    @Provides
    @Named("GetMenuUseCase")
    GetMenuUseCase provideGetMenuUseCase(AccesoRepository repository, ThreadExecutor threadExecutor,
                                                PostExecutionThread postExecutionThread) {
        return new GetMenuUseCase(repository, threadExecutor, postExecutionThread);
    }

    @Provides
    @Named("AddPreguntaUseCase")
    AddPreguntaUseCase provideAddPreguntaUseCase(AppsRepository repository, ThreadExecutor threadExecutor,
                                                 PostExecutionThread postExecutionThread) {
        return new AddPreguntaUseCase(repository, threadExecutor, postExecutionThread);
    }

    @Provides
    @Named("UpdatePreguntaUseCase")
    UpdatePreguntaUseCase provideUpdatePreguntaUseCase(AppsRepository repository, ThreadExecutor threadExecutor,
                                                    PostExecutionThread postExecutionThread) {
        return new UpdatePreguntaUseCase(repository, threadExecutor, postExecutionThread);
    }

    @Named("AddRespuestaUseCase")
    AddRespuestaUseCase provideAddRespuestaUseCase(AppsRepository repository, ThreadExecutor threadExecutor,
                                                 PostExecutionThread postExecutionThread) {
        return new AddRespuestaUseCase(repository, threadExecutor, postExecutionThread);
    }

    @Provides
    @Named("UpdateRespuestaUseCase")
    UpdateRespuestaUseCase provideUpdateRespuestaUseCase(AppsRepository repository, ThreadExecutor threadExecutor,
                                                         PostExecutionThread postExecutionThread) {
        return new UpdateRespuestaUseCase(repository, threadExecutor, postExecutionThread);
    }

    @Named("GetParametrosUseCase")
    GetParametrosUseCase provideGetParametrosUseCase(AuthRepository repository, ThreadExecutor threadExecutor,
                                                     PostExecutionThread postExecutionThread) {
        return new GetParametrosUseCase(repository, threadExecutor, postExecutionThread);
    }

}
