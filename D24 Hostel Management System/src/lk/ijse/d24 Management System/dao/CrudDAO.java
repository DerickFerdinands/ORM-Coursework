package dao;

import java.sql.SQLException;

public interface CrudDAO<T, ID> extends SuperDAO {

    boolean save(T entity) throws SQLException, ClassNotFoundException;

    boolean update(T entity) throws SQLException, ClassNotFoundException;

    boolean delete(ID id) throws SQLException, ClassNotFoundException;

    T get(ID id) throws SQLException, ClassNotFoundException;
}
