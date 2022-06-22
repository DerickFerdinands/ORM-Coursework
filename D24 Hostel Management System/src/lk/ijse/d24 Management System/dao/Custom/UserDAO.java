package dao.Custom;

import dao.CrudDAO;
import entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO extends CrudDAO<User,String> {
    List<User> getMatchingResults(String search) throws SQLException, ClassNotFoundException;
}
