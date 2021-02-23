package pe.com.distriluz.app.services;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

public class SimplePositionProvider extends PositionProvider implements LocationListener {

    public SimplePositionProvider(Context context, PositionListener listener) {
        super(context, listener);
    }

    @SuppressLint("MissingPermission")//TODO remover esto luego y hacer valdiacion de permiso desde el application context
    public void startUpdates() {
        locationManager.requestLocationUpdates( LocationManager.GPS_PROVIDER, 20000, 0, this);
    }

    @SuppressLint("MissingPermission")
    public void stopUpdates() {
        locationManager.removeUpdates(this);
    }

    @Override
    public void onLocationChanged(Location location) {
        updateLocation(location);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }

    @Override
    public void onProviderEnabled(String provider) {
    }

    @Override
    public void onProviderDisabled(String provider) {
    }

}
