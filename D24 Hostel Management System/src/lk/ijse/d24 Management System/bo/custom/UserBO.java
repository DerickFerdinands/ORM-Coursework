package bo.custom;

import dto.UserDTO;

import java.sql.SQLException;

public interface UserBO {

    boolean saveUser(UserDTO dto) throws SQLException, ClassNotFoundException;

    boolean updateUser(UserDTO dto) throws SQLException, ClassNotFoundException;

    boolean deleteUser(String id) throws SQLException, ClassNotFoundException;

    UserDTO getUser(String id) throws SQLException, ClassNotFoundException;
}
