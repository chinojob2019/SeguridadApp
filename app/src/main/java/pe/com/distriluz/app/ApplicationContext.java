package pe.com.distriluz.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import com.miguelbcr.ui.rx_paparazzo2.RxPaparazzo;

import pe.com.distriluz.app.injection.components.AppComponent;
import pe.com.distriluz.app.injection.components.DaggerAppComponent;
import pe.com.distriluz.app.injection.modules.AppModule;

public class ApplicationContext  extends MultiDexApplication {

    private static Context context;
    private static ApplicationContext sInstance = null;

    private static AppComponent sAppComponent = null;
    private static Intent intent=null;

    public static ApplicationContext getInstance() {
        return sInstance;
    }

    public static AppComponent getAppComponent() {
        return sAppComponent;
    }

    public static Resources getRes() {
        return sInstance.getResources();
    }
    public static Intent getIntentGpsServices() {
        return intent;
    }

    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
        ApplicationContext.context = getApplicationContext();
        sInstance = this;
      //  intent = new Intent(sInstance, GpsServices.class);
        sAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        RxPaparazzo.register(this);
        DisplayMetrics metrics = getRes().getDisplayMetrics();
    }
}