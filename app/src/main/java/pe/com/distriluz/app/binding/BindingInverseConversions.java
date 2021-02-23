package pe.com.distriluz.app.binding;


import androidx.databinding.InverseMethod;

/**
 * Created by troy379 on 16.03.16.
 */
public class BindingInverseConversions {
    @InverseMethod("toLong")
    public static final String toString(Long numberInt) {
        return numberInt==0 ? null : String.valueOf(numberInt);
    }

    public static final Long toLong(String numberString) {
        return numberString.equals("") ? 0 : Long.parseLong(numberString);
    }
    @InverseMethod("stringToDouble")
    public static final String doubletoString(Double numberDouble) {
        return numberDouble==0.0 ? null : String.valueOf(numberDouble);
    }

    public static final Double stringToDouble(String numberString) {
        return numberString.equals("") ? 0.0 : Double.parseDouble(numberString);
    }
    @InverseMethod("stringToint")
    public static final String intToString(int numberDouble) {
        return numberDouble==0 ? "" : String.valueOf(numberDouble);
    }

    public static final int stringToint(String numberString) {
        return numberString.equals("") ? 0 : Integer.parseInt(numberString);
    }
}
