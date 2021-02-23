package pe.com.distriluz.data.bd.repository;

import java.sql.SQLException;
import java.util.List;

import pe.com.distriluz.data.bd.model.BaseModel;

/**
 * Created by gilson.maciel on 27/04/2015.
 */
public interface IRepository<T extends BaseModel, Id> {
    int save(T entity) throws SQLException;

    void saveOrUpdate(T entity) throws SQLException;

    int saveBatch(List<T> entities) throws Exception;

    List<T> queryAll() throws SQLException;

    T findById(Id id) throws SQLException;

    void delete(T entity) throws SQLException;

    int deleteById(Id id) throws SQLException;

    int deleteBatchForID(List<Id> ids) throws SQLException;

    void deleteBatch(List<T> entities) throws SQLException;

    boolean update(T entity) throws SQLException;

    void clearSafeMode() throws SQLException;

    void safedelete(T entity) throws SQLException;

    void saveOrUpdateBatch(List<T> entities) throws SQLException;

    void clearAllForUser() throws SQLException;

    List<T> queryAllWhereObj(String columName, Object object) throws SQLException;
}
