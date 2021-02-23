package pe.com.distriluz.app.injection.modules;

import android.app.Service;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import pe.com.distriluz.app.injection.qualifier.ServiceContext;
import pe.com.distriluz.app.injection.scopes.PerService;


@Module
public class ServiceModule {

    private final Service mServices;

    public ServiceModule(Service mServices) {
        this.mServices = mServices;
    }

    @Provides
    @PerService
    @ServiceContext
    Context provideServiceContext() {
        return mServices;
    }

   /* @Provides
    TrackingController provideTrackingController(SendLocationUseCase guardarPositionServerUseCase) {
        return new TrackingController(mServices,guardarPositionServerUseCase);
    }*/
}
