package dao.Custom.impl;

import dao.Custom.RoomDAO;
import entity.Room;

import java.sql.SQLException;
import java.util.List;

public class RoomDAOImpl implements RoomDAO {
    @Override
    public boolean save(Room entity) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public boolean update(Room entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Room get(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<Room> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }
}
