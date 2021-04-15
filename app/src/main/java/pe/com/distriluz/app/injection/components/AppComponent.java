package pe.com.distriluz.app.injection.components;

import android.content.Context;
import android.content.res.Resources;

import javax.inject.Singleton;

import dagger.Component;
import pe.com.distriluz.app.injection.modules.AppModule;
import pe.com.distriluz.app.injection.qualifier.AppContext;
import pe.com.distriluz.data.net.acceso.AccesoRestApiImpl;
import pe.com.distriluz.data.net.apps.AppsRestApiImpl;
import pe.com.distriluz.data.net.auth.AuthRestApiImpl;
import pe.com.distriluz.data.net.auth.ChangePasswordRestApiImpl;
import pe.com.distriluz.data.repository.AccesoDataRepository;
import pe.com.distriluz.data.repository.AppsDataRepository;
import pe.com.distriluz.data.repository.AuthDataRepository;
import pe.com.distriluz.data.repository.ChangePasswordDataRepository;
import pe.com.distriluz.data.repository.datasource.acceso.AccesoCloudDataStore;
import pe.com.distriluz.data.repository.datasource.acceso.AccesoDBDataStore;
import pe.com.distriluz.data.repository.datasource.acceso.AccesoDataMapper;
import pe.com.distriluz.data.repository.datasource.acceso.AccesoDataStoreFactory;
import pe.com.distriluz.data.repository.datasource.apps.AppsCloudDataStore;
import pe.com.distriluz.data.repository.datasource.apps.AppsDBDataStore;
import pe.com.distriluz.data.repository.datasource.apps.AppsDataMapper;
import pe.com.distriluz.data.repository.datasource.apps.AppsDataStoreFactory;
import pe.com.distriluz.data.repository.datasource.auth.AuthCloudDataStore;
import pe.com.distriluz.data.repository.datasource.auth.AuthDBDataStore;
import pe.com.distriluz.data.repository.datasource.auth.AuthDataMapper;
import pe.com.distriluz.data.repository.datasource.auth.AuthDataStoreFactory;
import pe.com.distriluz.data.repository.datasource.changepassword.ChangePasswordCloudDataStore;
import pe.com.distriluz.data.repository.datasource.changepassword.ChangePasswordDBDataStore;
import pe.com.distriluz.data.repository.datasource.changepassword.ChangePasswordDataMapper;
import pe.com.distriluz.data.repository.datasource.changepassword.ChangePasswordDataStoreFactory;
import pe.com.distriluz.domain.executor.PostExecutionThread;
import pe.com.distriluz.domain.executor.ThreadExecutor;
import pe.com.distriluz.domain.repository.AccesoRepository;
import pe.com.distriluz.domain.repository.AppsRepository;
import pe.com.distriluz.domain.repository.AuthRepository;
import pe.com.distriluz.domain.repository.ChangePasswordRepository;


@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    @AppContext
    Context appContext();
    Context context();
    Resources resources();
    ThreadExecutor threadExecutor();
    PostExecutionThread postExecutionThread();


    /**Modulo Auth**/
    AuthRepository authRepository();
    AuthDBDataStore authDbDataStore();
    AuthDataMapper authDataMapper();
    AuthCloudDataStore authCloudDataStore();
    AuthRestApiImpl authRestApi();
    AuthDataRepository authDataRepository();
    AuthDataStoreFactory authDataStoreFactory();
    /**Modulo ChangePasswors**/


   ChangePasswordRepository changePasswordRepository();

    ChangePasswordDBDataStore changePasswordDbDataStore();
    ChangePasswordDataMapper changePasswordDataMapper();
    ChangePasswordCloudDataStore changePasswordCloudDataStore();
    ChangePasswordRestApiImpl changePasswordRestApi();
    ChangePasswordDataRepository changePasswordDataRepository();
    ChangePasswordDataStoreFactory changePasswordDataStoreFactory();


    /**Modulo Apps**/
    AppsRepository appsRepository();
    AppsDBDataStore appsDbDataStore();
    AppsDataMapper appsDataMapper();
    AppsCloudDataStore appsCloudDataStore();
    AppsRestApiImpl appsRestApi();
    AppsDataRepository appsDataRepository();
    AppsDataStoreFactory appsDataStoreFactory();


    /**Modulo Acceso**/
    AccesoRepository accesoRepository();
    AccesoDBDataStore accesoDbDataStore();
    AccesoDataMapper accesoDataMapper();
    AccesoCloudDataStore accesoCloudDataStore();
    AccesoRestApiImpl accesoRestApi();
    AccesoDataRepository accesoDataRepository();
    AccesoDataStoreFactory accesoDataStoreFactory();
}
