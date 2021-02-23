package pe.com.distriluz.app.binding;

import android.view.View;

import androidx.databinding.BindingConversion;

/**
 * Created by troy379 on 16.03.16.
 */
public final class BindingConversions {
    private BindingConversions() {
        throw new AssertionError();
    }

    @BindingConversion
    public static int convertBooleanToVisibility(boolean visible) {
        return visible ? View.VISIBLE : View.GONE;
    }
    @BindingConversion
    public static String convertLongToString(Long longObject) {
        return String.valueOf(longObject);
    }

    @BindingConversion
    public static String convertIntegerToString(Integer numberInt) {
        return String.valueOf(numberInt);
    }

}
