package pe.com.distriluz.data.net;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.google.gson.Gson;

import pe.com.distriluz.data.utiles.Utils;

public abstract class BaseRestApiImpl {

    protected Context context;

    public BaseRestApiImpl(Context context) {
        this.context = context.getApplicationContext();
    }

    @SuppressLint("MissingPermission")
    protected boolean isThereInternetConnection() {
        boolean isConnected;

        ConnectivityManager connectivityManager =
                (ConnectivityManager) this.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        isConnected = (networkInfo != null && networkInfo.isConnected());

        return isConnected;
    }

    protected String toJson(Object o) {
        return new Gson().toJson(o);
    }

    protected <T> T fromJson(String json, Class<T> clazz) {
        return new Gson().fromJson(json, clazz);
    }
    protected String getToken(){
        return Utils.getToken(context);
    }

}
