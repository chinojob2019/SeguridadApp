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

    public BaseRestApiImpl() {

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
    protected void setToken(String token){
        Utils.setToken(context, token);
    }
    protected String getRefreshToken(){
        return Utils.getrefreshToken(context);
    }
    protected void setRefreshToken(String refreshToken){
        Utils.setrefreshToken(context, refreshToken);
    }

    protected int getIdPerson(){
        String idPerson = Utils.getIdPerson(context);
        return idPerson == "0" ? 0 : Integer.getInteger(idPerson);
    }
    protected void setIdPerson(String idPerson){
        Utils.setIdPerson(context, idPerson);
    }

    protected int getIdUser(){
        return Utils.getid_user(context);
    }
    protected void setIdUser(int idUser){
        Utils.setid_user(context, idUser);
    }

}
