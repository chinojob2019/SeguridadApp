package pe.com.distriluz.app.utils;


import pe.com.distriluz.data.BuildConfig;

/**
 * Created by pedro.zevallos on 10/07/2017.
 */

public class Constantes {
    public static final String PACKAGE_NAME = BuildConfig.APPLICATION_ID;
    public static final String PREFERENCES = PACKAGE_NAME + ".pref";
    public static final String PREF_LOGGIN = "loggin";
    public static final String PREF_TOKEN  = "pref_token ";
    public static final String PREF_THIRDPARTYID  = "pref_thirdpartyId ";
    public static final String PREF_THIRDPARTYNAME  = "pref_thirdpartyName ";
    public static final String PREF_USERLOGIN  = "pref_userLogin ";
    public static final String PREF_USERPASSWORD  = "pref_userPassword ";
    public static final String PREF_USERROLES  = "pref_userRoles ";
    public static final String PREF_USERTYPE  = "pref_userType ";

    public static final float maxWidth = 720.0f;
    public static final float maxHeight= 576.0f;
    public static final Integer twoMinuts= 1000*60*1;
    public static final Integer seconds30= 1000*30;
    public static final int TYPE_TEXT = 1;
    public static final int TYPE_LIST = 2;
    public static final int TYPE_RADIO = 3;
    public static final int TYPE_TEXTAREA = 4;
    public static final int TYPE_SPLIT = 5;
    public static final int TYPE_CHECK = 6;
    public static final int TYPE_TAB = 7;
    public static final int TYPE_DATE = 8;
    public static final int TYPE_MULTI = 9;
    public static final int TYPE_EMAIL = 10;
    public static final int TYPE_NUMBER = 11;
    public static final int TYPE_DECIMAL = 12;
    public static final int TYPE_READONLY = 13;
    public static final String REQUIRED = "required";
    public final static int LIMIT_TRANSFORMS=2;
    public static final String LONGITUD = "OR_LONGITUD";
    public static final String LATITUD = "OR_LATITUD";
    public static final int MOSTRAR_DETALLE_CLIENTE = 4;
    public static final int MAXFOTOS = 8;
    public static final int NOT_MODIFIED = 1;
    public static final int MODIFIED = 2;
    public static final int APPLIED = 3;
    public static final int SYNCHRONIZED = 4;
    public static final String COLOR_NOT_MODIFIED = "#777777";
    public static final String COLOR_MODIFIED = "#F14545";
    public static final String COLOR_APPLIED = "#2F89C8";
    public static final String COLOR_SYNCHRONIZED = "#80b201";
    public static final String POLICY_APPLIED = "applied";
    public static final String POLICY_ACTIVE = "active";
    public static final int FORM_INPECTIONS = 1;
    public static final int FORM_DECLARATION_CLAIM = 2;
    public static final int SIZE_ITEM_FORM_APROX=98;
    public static final int STATIC_ITEMS_FORM_INSPECTION=4;
    public static final int STATIC_ITEMS_FORM_CLAIM=5;



    public static final int MENU_ITEM_LISTA_INICIO=1;
    public static final int MENU_ITEM_PREGUNTAS=2;
    public static final int MENU_ITEM_MESA_SERVICIO =3;
    public static final int MENU_ITEM_CERRAR_SESSION =4;
}
