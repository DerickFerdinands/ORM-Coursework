package bo.custom.impl;

import bo.custom.UserBO;
import dao.Custom.UserDAO;
import dao.DAOFactory;
import dto.UserDTO;
import entity.User;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserBOImpl implements UserBO {
    UserDAO uDAO = (UserDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.USER);


    @Override
    public boolean saveUser(UserDTO dto) throws SQLException, ClassNotFoundException {
        return uDAO.save(new User(dto.getNic(), dto.getName(), dto.getUserName(), dto.getPassword()));
    }

    @Override
    public boolean updateUser(UserDTO dto) throws SQLException, ClassNotFoundException {
        return uDAO.update(new User(dto.getNic(), dto.getName(), dto.getUserName(), dto.getPassword()));
    }

    @Override
    public boolean deleteUser(String id) throws SQLException, ClassNotFoundException {
        return uDAO.delete(id);
    }

    @Override
    public UserDTO getUser(String id) throws SQLException, ClassNotFoundException {
        User user = uDAO.get(id);
        return new UserDTO(user.getNic(), user.getName(), user.getUserName(), user.getPassword());
    }

    @Override
    public ArrayList<UserDTO> getAllUsers() throws SQLException, ClassNotFoundException {
        List<User> all = uDAO.getAll();
        ArrayList<UserDTO> allUsers = new ArrayList<>();
        allUsers.addAll(all.stream().map((Function<? super User, UserDTO>) user -> {
            return new UserDTO(user.getNic(), user.getName(), user.getUserName(), user.getPassword());
        }).collect(Collectors.toList()));
        return allUsers;
    }

    @Override
    public ArrayList<UserDTO> getMatchingUsers(String search) throws SQLException, ClassNotFoundException {
        List<User> all = uDAO.getMatchingResults("%" + search + "%");
        ArrayList<UserDTO> allUsers = new ArrayList<>();
        allUsers.addAll(all.stream().map((Function<? super User, UserDTO>) user -> {
            return new UserDTO(user.getNic(), user.getName(), user.getUserName(), user.getPassword());
        }).collect(Collectors.toList()));
        return allUsers;
    }
}
