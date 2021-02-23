package pe.com.distriluz.data.bd;

import android.content.Context;

import pe.com.distriluz.data.BuildConfig;


/**
 * Created by pedro.zevallos on 26/10/2017.
 */

public class DBHelper extends AbstractDBHelper {

    private static final String DATABASENAME = BuildConfig.BDNAME;

    public DBHelper(Context context) {
        super(context, DATABASENAME);
    }

    @Override
    protected Class<?>[] getTableClassList() {
        return new Class<?>[]{

        };

    }
}
