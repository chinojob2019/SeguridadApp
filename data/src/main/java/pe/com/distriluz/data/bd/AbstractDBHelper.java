package pe.com.distriluz.data.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import pe.com.distriluz.data.BuildConfig;

/**
 * Created by gilson.maciel on 27/04/2015.
 */
public abstract class AbstractDBHelper extends OrmLiteSqliteOpenHelper {
    private static final int DATABASE_VERSION = BuildConfig.BDVERSION;

    public AbstractDBHelper(Context context,
                            String databaseName) {
        super(context, databaseName, null, DATABASE_VERSION);
    }

    protected abstract Class<?>[] getTableClassList();

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        for (Class clazz : getTableClassList()) {
            try {
                TableUtils.createTable(connectionSource, clazz);
            } catch (SQLException e) {
                Log.e(AbstractDBHelper.class.getSimpleName(), "Error Creating Tables.");
            }
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource,
                          int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            for (Class clazz : getTableClassList()) {
                try {
                    TableUtils.dropTable(connectionSource, clazz, true);
                } catch (SQLException e) {
                    Log.e(AbstractDBHelper.class.getSimpleName(), "Error Creating Tables.");
                }
            }
            onCreate(database, connectionSource);
        }

    }
}
