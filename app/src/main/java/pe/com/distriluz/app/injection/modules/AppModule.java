package pe.com.distriluz.app.injection.modules;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pe.com.distriluz.app.UIThread;
import pe.com.distriluz.app.injection.qualifier.AppContext;
import pe.com.distriluz.data.executor.JobExecutor;
import pe.com.distriluz.data.net.apps.AppsRestApiImpl;
import pe.com.distriluz.data.net.auth.AuthRestApiImpl;
import pe.com.distriluz.data.net.auth.ChangePasswordRestApiImpl;
import pe.com.distriluz.data.repository.AppsDataRepository;
import pe.com.distriluz.data.repository.AuthDataRepository;
import pe.com.distriluz.data.repository.ChangePasswordDataRepository;
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
import pe.com.distriluz.domain.repository.AppsRepository;
import pe.com.distriluz.domain.repository.AuthRepository;
import pe.com.distriluz.domain.repository.ChangePasswordRepository;


@Module
public class AppModule {

    private final Application mApp;

    public AppModule(Application app) {
        mApp = app;
    }

    @Provides
    @Singleton
    @AppContext
    Context provideAppContext() {
        return mApp;
    }

    @Provides
    Context provideContext() {
        return mApp;
    }

    @Provides
    @Singleton
    Resources provideResources() {
        return mApp.getResources();
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

    /**Modulo Auth**/
    @Provides
    @Singleton
    AuthRepository provideAuthRepository(AuthDataRepository dataRepository) {
        return dataRepository;
    }
    @Provides
    @Singleton
    AuthDBDataStore provideAuthDBDataStore(AuthDataMapper mapper){
        return new AuthDBDataStore(mapper);
    }
    @Provides
    @Singleton
    AuthDataMapper provideAuthDataMapper(){
        return new AuthDataMapper();
    }
    @Provides
    @Singleton
    AuthCloudDataStore provideAuthCloudDataStore(AuthRestApiImpl restApi, AuthDataMapper mapper){
        return new AuthCloudDataStore(restApi,mapper);
    }
    @Provides
    @Singleton
    AuthRestApiImpl provideAuthRestApiImpl(){
        return new AuthRestApiImpl(mApp);
    }
    @Provides
    @Singleton
    AuthDataRepository provideAuthDataRepository(AuthDataStoreFactory factory, AuthDataMapper mapper){
        return new AuthDataRepository(factory,mapper);
    }
    @Provides
    @Singleton
    AuthDataStoreFactory provideAuthDataStoreFactory(AuthDBDataStore authDBDataStore, AuthCloudDataStore authCloudDataStore){
        return new AuthDataStoreFactory(authDBDataStore, authCloudDataStore);
    }

    /**Modulo ChangePassword**/


    @Provides
    @Singleton
    ChangePasswordRepository provideChangePasswordRepository(ChangePasswordDataRepository dataRepository) {
        return dataRepository;
    }
    @Provides
    @Singleton
    ChangePasswordDBDataStore provideChangePasswordDBDataStore(ChangePasswordDataMapper mapper){
        return new ChangePasswordDBDataStore(mapper);
    }
    @Provides
    @Singleton
    ChangePasswordDataMapper provideChangePasswordDataMapper(){
        return new ChangePasswordDataMapper();
    }
    @Provides
    @Singleton
    ChangePasswordCloudDataStore provideChangePasswordCloudDataStore(ChangePasswordRestApiImpl restApi, ChangePasswordDataMapper mapper){
        return new ChangePasswordCloudDataStore(restApi,mapper);
    }
    @Provides
    @Singleton
    ChangePasswordRestApiImpl provideChangePasswordRestApiImpl(){
        return new ChangePasswordRestApiImpl(mApp);
    }
    @Provides
    @Singleton
    ChangePasswordDataRepository provideChangePasswordDataRepository(ChangePasswordDataStoreFactory factory, ChangePasswordDataMapper mapper){
        return new ChangePasswordDataRepository(factory,mapper);
    }
    @Provides
    @Singleton
    ChangePasswordDataStoreFactory provideChangePasswordDataStoreFactory(ChangePasswordDBDataStore changePasswordDBDataStore, ChangePasswordCloudDataStore changePasswordCloudDataStore){
        return new ChangePasswordDataStoreFactory(changePasswordDBDataStore,changePasswordCloudDataStore);
    }



    /**Modulo Apps**/
    @Provides
    @Singleton
    AppsRepository provideAppsRepository(AppsDataRepository dataRepository) {
        return dataRepository;
    }
    @Provides
    @Singleton
    AppsDBDataStore provideAppsDBDataStore(AppsDataMapper mapper){
        return new AppsDBDataStore(mapper);
    }
    @Provides
    @Singleton
    AppsDataMapper provideAppsDataMapper(){
        return new AppsDataMapper();
    }
    @Provides
    @Singleton
    AppsCloudDataStore provideAppsCloudDataStore(AppsRestApiImpl restApi, AppsDataMapper mapper){
        return new AppsCloudDataStore(restApi,mapper);
    }
    @Provides
    @Singleton
    AppsRestApiImpl provideAppsRestApiImpl(){
        return new AppsRestApiImpl(mApp);
    }
    @Provides
    @Singleton
    AppsDataRepository provideAppsDataRepository(AppsDataStoreFactory factory, AppsDataMapper mapper){
        return new AppsDataRepository(factory,mapper);
    }
    @Provides
    @Singleton
    AppsDataStoreFactory provideAppsDataStoreFactory(AppsDBDataStore dBDataStore, AppsCloudDataStore cloudDataStore){
        return new AppsDataStoreFactory(dBDataStore, cloudDataStore);
    }

}
