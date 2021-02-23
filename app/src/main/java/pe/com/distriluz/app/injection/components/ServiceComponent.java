package pe.com.distriluz.app.injection.components;

import android.content.Context;

import dagger.Component;
import pe.com.distriluz.app.injection.modules.ServiceModule;
import pe.com.distriluz.app.injection.qualifier.ServiceContext;
import pe.com.distriluz.app.injection.scopes.PerService;


@PerService
@Component(dependencies = AppComponent.class, modules = {ServiceModule.class})
public interface ServiceComponent extends AppComponent {

    @ServiceContext
    Context serviceContext();

  //  void inject(GpsServices gpsServices);

    //TrackingController trackingController();
}
