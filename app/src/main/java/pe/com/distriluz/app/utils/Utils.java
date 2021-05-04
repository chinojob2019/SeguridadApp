package pe.com.distriluz.app.utils;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import pe.com.distriluz.app.ApplicationContext;
import pe.com.distriluz.app.R;
import pe.com.distriluz.app.ui.base.exceptions.ErrorException;
import pe.com.distriluz.app.ui.respuestas.RespuestasObservableModel;
import pe.com.distriluz.data.net.auth.model.DetailUserResponse;


/**
 * Created by pedro.zevallos on 10/07/2017.
 */
@Singleton
public class Utils {

    private Utils() {
        throw new IllegalStateException("Utility class");
    }

    public static <T extends RecyclerView.ViewHolder> T createViewHolder(@NonNull ViewGroup viewGroup, @LayoutRes int layoutResId, @NonNull PlainFunction<View, T> newViewHolderAction) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(layoutResId, viewGroup, false);

        return newViewHolderAction.apply(view);
    }
    public static final String TAG= Utils.class.getName();

    // Tries to cast an Activity Context to another type
    @SuppressWarnings("unchecked")
    @Nullable
    public static <T> T castActivityFromContext(Context context, Class<T> castClass) {
        if (castClass.isInstance(context)) {
            return (T) context;
        }

        while (context instanceof ContextWrapper) {
            context = ((ContextWrapper) context).getBaseContext();

            if (castClass.isInstance(context)) {
                return (T) context;
            }
        }

        return null;
    }

    public static void setFondoCompleto(ImageView view, String url) {
        Glide.with(view.getContext())
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .fitCenter()
                .into(view);
    }

    public static String getAndroidID(Context con) {
        return Settings.Secure.getString(con.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    public static String formatingTime(long millis)
    {
        // Create a DateFormatter object for displaying date in specified format.
        return String.format(Locale.getDefault(),"%02d : %02d : %02d sec",
                TimeUnit.MILLISECONDS.toHours(millis),
                TimeUnit.MILLISECONDS.toMinutes(millis) -
                        TimeUnit.MINUTES.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                TimeUnit.MILLISECONDS.toSeconds(millis) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))
        );
    }

    public static boolean isSimulado(Location location) {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2 && location.isFromMockProvider();
    }

    public static void validarBorrarTemp(String image) {
        if(!image.isEmpty()){
            File photoFile = new File(image);
            if(photoFile.exists()) photoFile.delete();
        }
    }

    public static String getFilename() {
        File file = new File(Environment.getExternalStorageDirectory().getPath(), "PF_DIST/Images");
        if (!file.exists()) {
            file.mkdirs();
        }
        return (file.getAbsolutePath() + "/" + System.currentTimeMillis() + ".jpeg");

    }

    public static byte[] getBitmapAsByteArray(String filePath) throws ErrorException {
        File imgFile = new File(filePath);
        if(imgFile.exists()){
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            myBitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
            return outputStream.toByteArray();
        }else{
            throw new ErrorException("No Existe la imagen en el Sistema");
        }
    }

    public static boolean validarToken(Throwable e) {
        return (e instanceof ErrorException) && ((ErrorException) (e)).isTokenValid();
    }

    public static boolean isLoggin(Context con){
        return con.getSharedPreferences(Constantes.PREFERENCES, Context.MODE_PRIVATE).getBoolean(Constantes.PREF_LOGGIN,false);
    }

    public static String getFilePathFrom(String fileName, Context con) {
        File dir = con.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        File path = new File(dir + File.separator + fileName);
        return path.getAbsolutePath();
    }

    public static String getDateFormat(Date fecha, String format){
        SimpleDateFormat simpleDate =  new SimpleDateFormat(format);//2018-05-10 24:23

        return simpleDate.format(fecha);
    }

    public static  <T> List<List<T>> chunkList(List<T> list, int chunkSize) {
        if (chunkSize <= 0) {
            throw new IllegalArgumentException("Invalid chunk size: " + chunkSize);
        }
        List<List<T>> chunkList = new ArrayList<>(list.size() / chunkSize);
        for (int i = 0; i < list.size(); i += chunkSize) {
            chunkList.add(list.subList(i, i + chunkSize >= list.size() ? list.size() : i + chunkSize));
        }
        return chunkList;
    }

    public static  <T> ObservableList<ObservableList<T>> chunkList(ObservableList<T> list, int totalItemsScreen) {
        List<List<T>> chunkList = new ArrayList<>(list.size() / totalItemsScreen);
        for (int i = 0; i < list.size(); i += totalItemsScreen) {
            chunkList.add(list.subList(i, i + totalItemsScreen >= list.size() ? list.size() : i + totalItemsScreen));
        }
        ObservableList<ObservableList<T>> datasObser = new ObservableArrayList<>();

        for(List<T> data :chunkList){
            ObservableList<T> subdatasObser = new ObservableArrayList<>();
            subdatasObser.addAll(data);
            datasObser.add(subdatasObser);
        }
        return datasObser;
    }
    public static  <T> ObservableList<ObservableList<T>> chunkList2(ObservableList<T> list, int type, int totalItemsScreen) {
        int chunkSize =0;
        int limitFirstList=0;
        chunkSize = totalItemsScreen;
        switch (type){
            case Constantes.FORM_INPECTIONS:
                limitFirstList = totalItemsScreen - Constantes.STATIC_ITEMS_FORM_INSPECTION;
                break;
            case Constantes.FORM_DECLARATION_CLAIM:
                limitFirstList = totalItemsScreen - Constantes.STATIC_ITEMS_FORM_CLAIM;
                break;
        }
        if (chunkSize <= 0 && limitFirstList <= 0) {
            throw new IllegalArgumentException("Invalid chunk size: " + chunkSize);
        }
        ObservableList<T> firstList = new ObservableArrayList<>();
        firstList.addAll(list.subList(0,limitFirstList));
        ObservableList<T> secondList = new ObservableArrayList<>();
        secondList.addAll(list.subList(limitFirstList,list.size()));
        ObservableList<ObservableList<T>> datasObser = new ObservableArrayList<>();
        datasObser.add(firstList);
        datasObser.addAll(chunkList(secondList,totalItemsScreen));
        return datasObser;
    }

    public static String getTypeDensity(){
        Log.i(TAG, "getTypeDensity: "+ ApplicationContext.getRes().getDisplayMetrics().densityDpi);
        switch (ApplicationContext.getRes().getDisplayMetrics().densityDpi) {
            case DisplayMetrics.DENSITY_LOW:
                return "ldpi";
            case DisplayMetrics.DENSITY_MEDIUM:
                return "mdpi";
            case DisplayMetrics.DENSITY_TV:
            case DisplayMetrics.DENSITY_HIGH:
                return "hdpi";
            case DisplayMetrics.DENSITY_260:
            case DisplayMetrics.DENSITY_280:
            case DisplayMetrics.DENSITY_300:
            case DisplayMetrics.DENSITY_XHIGH:
                return "xhdpi";
            case DisplayMetrics.DENSITY_340:
            case DisplayMetrics.DENSITY_360:
            case DisplayMetrics.DENSITY_400:
            case DisplayMetrics.DENSITY_420:
            case DisplayMetrics.DENSITY_440:
            case DisplayMetrics.DENSITY_XXHIGH:
                return "xxhdpi";
            case DisplayMetrics.DENSITY_560:
            case DisplayMetrics.DENSITY_XXXHIGH:
                return "xxxhdpi";
                default: return "not density";
        }
    }




    private static Random rand = new Random();
    public static int getRandomForRange(int min, int max){
        return rand.nextInt(((max - min) + 1) + min);
    }

    public static void expand(final View v) {
        if(v.getVisibility()==View.GONE) {
        v.measure(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        final int targetHeight = (int)(v.getContext().getResources().getDisplayMetrics().density * 200 +0.5);
            v.getLayoutParams().height = 1;
            v.setVisibility(View.VISIBLE);
            Animation a = new Animation() {
                @Override
                protected void applyTransformation(float interpolatedTime, Transformation t) {
                    v.getLayoutParams().height = interpolatedTime == 1
                            ? ViewGroup.LayoutParams.WRAP_CONTENT
                            : (int) (targetHeight * interpolatedTime);
                    v.requestLayout();
                }

                @Override
                public boolean willChangeBounds() {
                    return true;
                }
            };
            a.setDuration((int) (targetHeight * 2 / v.getContext().getResources().getDisplayMetrics().density));
            v.startAnimation(a);
        }
    }

    public static void collapse(final View v) {
        if(v.getVisibility()==View.VISIBLE) {
            final int initialHeight = v.getMeasuredHeight();

            Animation a = new Animation() {
                @Override
                protected void applyTransformation(float interpolatedTime, Transformation t) {
                    if (interpolatedTime == 1) {
                        v.setVisibility(View.GONE);
                    } else {
                        v.getLayoutParams().height = initialHeight - (int) (initialHeight * interpolatedTime);
                        v.requestLayout();
                    }
                }

                @Override
                public boolean willChangeBounds() {
                    return true;
                }
            };

            // 1dp/ms
            a.setDuration((int) (initialHeight*2 / v.getContext().getResources().getDisplayMetrics().density));
            v.startAnimation(a);
        }
    }

    public static int getDifferentDaysToday(long datefinal){
        long different = datefinal - Calendar.getInstance().getTimeInMillis();

        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;

        long elapsedDays = different / daysInMilli;
        return (int)(elapsedDays);
    }



    public static void updateStrings(){
        Configuration config = new Configuration();
        config.locale =Locale.getDefault();
        ApplicationContext.getRes().updateConfiguration(config, ApplicationContext.getRes().getDisplayMetrics());
    }



    public SizeScreen getScreenSize(){
        return new SizeScreen(ApplicationContext.getRes().getDisplayMetrics().widthPixels, ApplicationContext.getRes().getDisplayMetrics().heightPixels);
    }

    public static class SizeScreen {
        int widthPixels;
        int heightPixels;
        public SizeScreen(int widthPixels, int heightPixels) {
            this.widthPixels=widthPixels;
            this.heightPixels=heightPixels;
        }

        public int getWidthPixels() {
            return widthPixels;
        }

        public void setWidthPixels(int widthPixels) {
            this.widthPixels = widthPixels;
        }

        public int getHeightPixels() {
            return heightPixels;
        }

        public void setHeightPixels(int heightPixels) {
            this.heightPixels = heightPixels;
        }
    }

    public static ColorStateList getColorActive(){
        int[][] states = new int[][] {
                new int[] {android.R.attr.state_enabled},
                new int[] {-android.R.attr.state_enabled}
        };

        int[] colorsactive = new int[] {
                ResourcesCompat.getColor(ApplicationContext.getRes(), R.color.colorEndIconactivo, null),
                ResourcesCompat.getColor(ApplicationContext.getRes(), R.color.colorEndIconactivo, null)
        };
        return new  ColorStateList(states, colorsactive);
    }

    public static ColorStateList getColorInactive(){
        int[][] states = new int[][] {
                new int[] {android.R.attr.state_enabled},
                new int[] {-android.R.attr.state_enabled}
        };

        int[] colorsinactive = new int[] {
                ResourcesCompat.getColor(ApplicationContext.getRes(), R.color.colorEndIconInactivo, null),
                ResourcesCompat.getColor(ApplicationContext.getRes(), R.color.colorEndIconInactivo, null)
        };
        return new  ColorStateList(states, colorsinactive);
    }

    public static ColorStateList getColorError(){
        int[][] states = new int[][] {
                new int[] {android.R.attr.state_enabled},
                new int[] {-android.R.attr.state_enabled}
        };

        int[] colorserror = new int[] {
                ResourcesCompat.getColor(ApplicationContext.getRes(), R.color.rojo, null),
                ResourcesCompat.getColor(ApplicationContext.getRes(), R.color.rojo, null)
        };

        return new  ColorStateList(states, colorserror);
    }


}
