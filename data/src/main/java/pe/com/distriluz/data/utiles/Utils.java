package pe.com.distriluz.data.utiles;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.reactivex.Observable;
import io.reactivex.Single;
import pe.com.distriluz.data.exception.ErrorException;
import pe.com.distriluz.data.net.auth.model.DetailUserResponse;
import pe.com.distriluz.data.net.auth.model.LoginResponse;
import pe.com.distriluz.domain.model.DetailUser;

public class Utils {

    public static <T> Observable<T> defaultErrorBDObservable() {
        return Observable.create(subscriber -> subscriber.onError(new ErrorException("no existe llamado BD Interna")));
    }

    public static <T> Observable<T> defaultErrorCloudObservable() {
        return Observable.create(subscriber -> subscriber.onError(new ErrorException("no existe llamado Cloud")));
    }

    public static <T> Single<T> defaultErrorBDSingle() {
        return Single.create(subscriber -> subscriber.onError(new ErrorException("no existe llamado BD Interna")));
    }

    public static <T> Single<T> defaultErrorCloudSingle() {
        return Single.create(subscriber -> subscriber.onError(new ErrorException("no existe llamado Cloud")));
    }

    public static void saveSession(Context context, LoginResponse serverResponse, String username, String pass, boolean session, String token) {
        setToken(context, token);
        setrefreshToken(context, serverResponse.getrefreshToken());
        setfirstname(context, serverResponse.getUsuario().getNombre());
        setemail(context, serverResponse.getUsuario().getEmail());
        setpass(context, pass);
        setusername(context, username);
        setLogin(context, session);
        setIdPerson(context, "" + serverResponse.getUsuario().getIdPersona());
        setid_user(context, serverResponse.getUsuario().getId());
    }

    public static String getPicturePerfil(Context context) {
        String result = context.getSharedPreferences(Constantes.PREFERENCES, Context.MODE_PRIVATE).getString(Constantes.PREF_PICTURE_PERFIL, "");
        return !result.isEmpty() ? result : getInitialName(getusername(context));
    }

    public static String getInitialName(String username) {
        String result = "";
        try {
            String[] split = username.split(" ");
            result = split[0];
            result += split[1];
        } catch (Exception e) {
            Log.i("InitialName", "getInitialName: ", e);
        }
        return result;
    }

    public static void setPicturePerfil(Context context, String value) {
        context.getSharedPreferences(Constantes.PREFERENCES, Context.MODE_PRIVATE).edit().putString(Constantes.PREF_PICTURE_PERFIL, value).apply();
    }

    public static boolean isLogin(Context context) {
        return context.getSharedPreferences(Constantes.PREFERENCES, Context.MODE_PRIVATE).getBoolean(Constantes.PREF_login, false);
    }

    public static void setLogin(Context context, boolean login) {
        context.getSharedPreferences(Constantes.PREFERENCES, Context.MODE_PRIVATE).edit().putBoolean(Constantes.PREF_login, login).apply();
    }

    public static String getToken(Context context) {
        return context.getSharedPreferences(Constantes.PREFERENCES, Context.MODE_PRIVATE).getString(Constantes.PREF_TOKEN, "");
    }

    public static void setIdPerson(Context context, String value) {
        context.getSharedPreferences(Constantes.PREFERENCES, Context.MODE_PRIVATE).edit().putString(Constantes.PREF_ID_PERSON, value).apply();
    }

    public static String getIdPerson(Context context) {
        return context.getSharedPreferences(Constantes.PREFERENCES, Context.MODE_PRIVATE).getString(Constantes.PREF_ID_PERSON, "");
    }

    public static void setToken(Context context, String value) {
        context.getSharedPreferences(Constantes.PREFERENCES, Context.MODE_PRIVATE).edit().putString(Constantes.PREF_TOKEN, value).apply();
    }

    public static int getid_user(Context context) {
        return context.getSharedPreferences(Constantes.PREFERENCES, Context.MODE_PRIVATE).getInt(Constantes.PREF_id_user, 0);
    }

    public static void setid_user(Context context, int id_user) {
        context.getSharedPreferences(Constantes.PREFERENCES, Context.MODE_PRIVATE).edit().putInt(Constantes.PREF_id_user, id_user).apply();
    }

    public static String getusername(Context context) {
        return context.getSharedPreferences(Constantes.PREFERENCES, Context.MODE_PRIVATE).getString(Constantes.PREF_username, "");
    }

    public static void setusername(Context context, String username) {
        context.getSharedPreferences(Constantes.PREFERENCES, Context.MODE_PRIVATE).edit().putString(Constantes.PREF_username, username).apply();
    }

    public static String getemail(Context context) {
        return context.getSharedPreferences(Constantes.PREFERENCES, Context.MODE_PRIVATE).getString(Constantes.PREF_email, "");
    }

    public static void setemail(Context context, String email) {
        context.getSharedPreferences(Constantes.PREFERENCES, Context.MODE_PRIVATE).edit().putString(Constantes.PREF_email, email).apply();
    }

    public static long getid_register(Context context) {
        return context.getSharedPreferences(Constantes.PREFERENCES, Context.MODE_PRIVATE).getLong(Constantes.PREF_id_register, 0);
    }

    public static void setid_register(Context context, long id_register) {
        context.getSharedPreferences(Constantes.PREFERENCES, Context.MODE_PRIVATE).edit().putLong(Constantes.PREF_id_register, id_register).apply();
    }

    public static String getusernames(Context context) {
        return context.getSharedPreferences(Constantes.PREFERENCES, Context.MODE_PRIVATE).getString(Constantes.PREF_usernames, "");
    }

    public static void setusernames(Context context, String usernames) {
        context.getSharedPreferences(Constantes.PREFERENCES, Context.MODE_PRIVATE).edit().putString(Constantes.PREF_usernames, usernames).apply();
    }

    public static String getfirstname(Context context) {
        return context.getSharedPreferences(Constantes.PREFERENCES, Context.MODE_PRIVATE).getString(Constantes.PREF_firstname, "");
    }

    public static void setrefreshToken(Context context, String refreshToken) {
        context.getSharedPreferences(Constantes.PREFERENCES, Context.MODE_PRIVATE).edit().putString(Constantes.PREF_refreshToken, refreshToken).apply();
    }

    public static String getrefreshToken(Context context) {
        return context.getSharedPreferences(Constantes.PREFERENCES, Context.MODE_PRIVATE).getString(Constantes.PREF_refreshToken, "");
    }

    public static void setfirstname(Context context, String firstname) {
        context.getSharedPreferences(Constantes.PREFERENCES, Context.MODE_PRIVATE).edit().putString(Constantes.PREF_firstname, firstname).apply();
    }

    public static String getlastname(Context context) {
        return context.getSharedPreferences(Constantes.PREFERENCES, Context.MODE_PRIVATE).getString(Constantes.PREF_lastname, "");
    }

    public static void setlastname(Context context, String lastname) {
        context.getSharedPreferences(Constantes.PREFERENCES, Context.MODE_PRIVATE).edit().putString(Constantes.PREF_lastname, lastname).apply();
    }

    public static int getid_rol(Context context) {
        return context.getSharedPreferences(Constantes.PREFERENCES, Context.MODE_PRIVATE).getInt(Constantes.PREF_id_rol, 0);
    }

    public static void setid_rol(Context context, int id_rol) {
        context.getSharedPreferences(Constantes.PREFERENCES, Context.MODE_PRIVATE).edit().putInt(Constantes.PREF_id_rol, id_rol).apply();
    }

    public static String getpass(Context context) {
        return context.getSharedPreferences(Constantes.PREFERENCES, Context.MODE_PRIVATE).getString(Constantes.PREF_pass, "");
    }

    public static void setpass(Context context, String pass) {
        context.getSharedPreferences(Constantes.PREFERENCES, Context.MODE_PRIVATE).edit().putString(Constantes.PREF_pass, pass).apply();
    }

    public static String toBase64(String ruta) {
        try {
            return "data:image/" + ruta.split("\\.")[1] + ";base64," + Base64.encodeToString(Utils.getBitmapAsByteArray(ruta), Base64.NO_WRAP);
        } catch (ErrorException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String formateDateFromstring(String inputFormat, String outputFormat, String inputDate) {
        Date parsed = null;
        String outputDate = "";

        SimpleDateFormat df_input = new SimpleDateFormat(inputFormat, java.util.Locale.getDefault());
        SimpleDateFormat df_output = new SimpleDateFormat(outputFormat, java.util.Locale.getDefault());

        try {
            parsed = df_input.parse(inputDate);
            outputDate = df_output.format(parsed);

        } catch (ParseException e) {
            Log.e("Format Date", "ParseException - dateFormat");
        }

        return outputDate;
    }

    public static byte[] getBitmapAsByteArray(String filePath) throws ErrorException {
        File imgFile = new File(filePath);
        if (imgFile.exists()) {
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            myBitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
            return outputStream.toByteArray();
        } else {
            throw new ErrorException("No Existe la imagen en el Sistema");
        }

    }

    public static void saveInfo(Context context, DetailUserResponse body) {
        if (body != null && body.getPersonales() != null) {
            String fecha = formateDateFromstring("yyyy-MM-dd'T'HH:mm:ss", "dd/MM/yyyy", body.getPersonales().getFechanacimiento());
            body.getPersonales().setFechanacimiento(fecha);
            setfirstname(context, body.getPersonales().getNombre() + " " + body.getPersonales().getApellidopaterno());
        }
        context.getSharedPreferences(Constantes.PREFERENCES, Context.MODE_PRIVATE).edit().putString(Constantes.PREF_INFOR_USER, new Gson().toJson(body)).apply();
    }

    public static DetailUserResponse getInfo(Context context) {
        return new Gson().fromJson(
                context.getSharedPreferences(Constantes.PREFERENCES, Context.MODE_PRIVATE)
                        .getString(Constantes.PREF_INFOR_USER, ""),
                DetailUserResponse.class
        );
    }
}
