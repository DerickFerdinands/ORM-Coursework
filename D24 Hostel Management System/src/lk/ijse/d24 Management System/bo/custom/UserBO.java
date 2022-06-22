package bo.custom;

import bo.SuperBO;
import dto.UserDTO;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

public interface UserBO extends SuperBO {

    boolean saveUser(UserDTO dto) throws SQLException, ClassNotFoundException;

    boolean updateUser(UserDTO dto) throws SQLException, ClassNotFoundException;

    boolean deleteUser(String id) throws SQLException, ClassNotFoundException;

    UserDTO getUser(String id) throws SQLException, ClassNotFoundException;

    ArrayList<UserDTO> getAllUsers() throws SQLException, ClassNotFoundException;

    ArrayList<UserDTO> getMatchingUsers(String search) throws SQLException, ClassNotFoundException;
}
