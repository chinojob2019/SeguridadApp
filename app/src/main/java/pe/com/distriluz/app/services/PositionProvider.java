/*
 * Copyright 2013 - 2015 Anton Tananaev (anton.tananaev@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pe.com.distriluz.app.services;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationManager;
import android.os.BatteryManager;
import android.os.Build;

import java.util.Date;

import pe.com.distriluz.app.utils.Utils;



public abstract class PositionProvider {

    protected static final String TAG = PositionProvider.class.getSimpleName();

    public interface PositionListener {
      //  void onPositionUpdate(Position position);
    }

    private final PositionListener listener;

    private final Context context;
    protected final LocationManager locationManager;


    public PositionProvider(Context context, PositionListener listener) {
        this.context = context;
        this.listener = listener;
        this.locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
    }

    public abstract void startUpdates();

    public abstract void stopUpdates();

    protected void updateLocation(Location location) {
        if (location != null ) {
         //   listener.onPositionUpdate(new Position((int)location.getSpeed(),"31", String.valueOf(location.getLatitude()),1,String.valueOf(location.getLongitude()), Utils.getDateFormat(new Date(location.getTime()),"yyyy-MM-dd HH:mm:ss"),(int)location.getAltitude()));
        }
    }

    @TargetApi(Build.VERSION_CODES.ECLAIR)
    private double getBatteryLevel() {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.ECLAIR) {
            Intent batteryIntent = context.registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
            int level = batteryIntent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
            int scale = batteryIntent.getIntExtra(BatteryManager.EXTRA_SCALE, 1);
            return (level * 100.0) / scale;
        } else {
            return 0;
        }
    }
}
