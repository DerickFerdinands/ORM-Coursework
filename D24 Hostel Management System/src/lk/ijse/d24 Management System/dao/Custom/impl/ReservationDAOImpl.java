package dao.Custom.impl;

import dao.Custom.ReservationDAO;
import entity.Reservation;

import java.sql.SQLException;
import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {
    @Override
    public boolean save(Reservation entity) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public boolean update(Reservation entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Reservation get(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<Reservation> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }
}
