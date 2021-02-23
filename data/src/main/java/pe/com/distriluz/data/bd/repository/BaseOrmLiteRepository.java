package pe.com.distriluz.data.bd.repository;

import android.content.Context;
import android.util.Log;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.table.TableUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import pe.com.distriluz.data.bd.AbstractDBHelper;
import pe.com.distriluz.data.bd.model.BaseModel;


/**
 * Created by gilson.maciel on 27/04/2015.
 */
public abstract class BaseOrmLiteRepository<T extends BaseModel, Id> implements IRepository<T, Id> {
    protected static Context context;
    private static Class<? extends AbstractDBHelper> helperClass;
    private static AbstractDBHelper instance;
    private Class<T> genericType;
    private Where<T, Id> where;


    public BaseOrmLiteRepository(Context context, Class<? extends AbstractDBHelper> helperClazz) {
        BaseOrmLiteRepository.context = context;
        helperClass = helperClazz;

        try {
            getModelClass();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected static AbstractDBHelper getPersistenceManager() {
        if (instance == null) {
            try {
                Log.d("", "CREATING PERSISTENCE MANAGER");
                instance = helperClass.getDeclaredConstructor(Context.class)
                        .newInstance(context);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return instance;
    }

    private void getModelClass() throws ClassNotFoundException {
        if (genericType == null) {
            Type mySuperclass = getClass().getGenericSuperclass();
            Type tType = ((ParameterizedType) mySuperclass).getActualTypeArguments()[0];
            String className = tType.toString().split(" ")[1];
            genericType = (Class<T>) Class.forName(className);
            Log.d(BaseOrmLiteRepository.class.getSimpleName(),
                    "Type class: " + genericType.getSimpleName());
        }
    }

    @Override
    public int save(T entity) throws SQLException {
        return getDao().create(entity);
    }

    @Override
    public void saveOrUpdate(T entity) throws SQLException {
        getDao().createOrUpdate(entity);
    }

    @Override
    public boolean update(T entity) throws SQLException {
        return getDao().update(entity) == 1;
    }

    @Override
    public int saveBatch(final List<T> entities) throws SQLException {
        int count = 0;
        for (T item : entities) {
            count += getDao().create(item);
        }
        return count;
    }

    @Override
    public List<T> queryAll() throws SQLException {
        return getDao().queryBuilder().where().query();
    }

    @Override
    public List<T> queryAllWhereObj(String columName, Object object) throws SQLException {
        return getDao().queryBuilder().where().and().eq(columName, object).query();
    }

    @Override
    public T findById(Id id) throws SQLException {
        return getDao().queryBuilder().where().idEq(id).and().queryForFirst();
    }

    @Override
    public void delete(T entity) throws SQLException {
        getDao().delete(entity);
    }

    @Override
    public int deleteById(Id id) throws SQLException {
        return getDao().deleteById(id);
    }

    @Override
    public int deleteBatchForID(List<Id> ids) throws SQLException {
        int count = 0;
        for (Id id : ids) {
            count += getDao().deleteById(id);
        }
        return count;
    }

    @Override
    public void deleteBatch(List<T> entities) throws SQLException {
        for (T entity : entities) {
            delete(entity);
        }
    }

    @Override
    public void safedelete(T entity) throws SQLException {
        if (getDao().countOf() > 0) {
            getDao().delete(entity);
        }
    }

    public Dao<T, Id> getDao() throws SQLException {
        return DaoManager.createDao(getPersistenceManager().getConnectionSource(),
                genericType);
    }

    public QueryBuilder<T, Id> getQueryBuilder() throws SQLException {
        return getDao().queryBuilder();
    }

    protected Where<T, Id> getWhere() throws SQLException {
        return getDao().queryBuilder().where().and();
    }

    public T getEntitySimpleWhere(String field, Object value) throws SQLException {
        Where<T, Id> where = getWhere();
        where.eq(field, value);
        return where.queryForFirst();
    }

    protected T getEntityWithWhereAND(Map<String, Object> values) throws SQLException {
        Where<T, Id> where = getWhere();

        Iterator entries = values.entrySet().iterator();

        while (entries.hasNext()) {
            Map.Entry<String, Object> entry = (Map.Entry) entries.next();
            where.eq(entry.getKey(), entry.getValue());

            if (entries.hasNext()) {
                where.and();
            }
        }

        return where.queryForFirst();
    }

    protected List<T> getListEntityWithWhereAND(Map<String, Object> values) throws SQLException {
        Where<T, Id> where = getWhere();

        Iterator entries = values.entrySet().iterator();

        while (entries.hasNext()) {
            Map.Entry<String, Object> entry = (Map.Entry) entries.next();
            where.eq(entry.getKey(), entry.getValue());

            if (entries.hasNext()) {
                where.and();
            }
        }

        return where.query();
    }

    public void clear() throws SQLException {
        TableUtils.clearTable(getPersistenceManager().getConnectionSource(), genericType);
    }

    public void beginTransation() {
        getPersistenceManager().getWritableDatabase().beginTransaction();
    }

    public void commitTransaction() {
        getPersistenceManager().getWritableDatabase().setTransactionSuccessful();
    }

    public void endTransaction() {
        getPersistenceManager().getWritableDatabase().endTransaction();
    }

    @Override
    public void clearSafeMode() throws SQLException {
        if (getDao().countOf() > 0) {
            clear();
        }
    }

    @Override
    public void saveOrUpdateBatch(List<T> entities) throws SQLException {
        for (T item : entities) {
            try {
                getDao().createOrUpdate(item);
            } catch (SQLException e) {
                Log.d(genericType.getName(), "saveOrUpdateBatch: " + e);
            }
        }
    }

    @Override
    public void clearAllForUser() throws SQLException {
        List<T> list = getDao().queryBuilder().where().query();
        if (list != null && !list.isEmpty()) {
            getDao().delete(list);
        }
    }
}
