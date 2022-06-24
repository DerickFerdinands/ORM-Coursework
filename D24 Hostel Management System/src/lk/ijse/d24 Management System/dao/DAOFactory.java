package dao;

import dao.Custom.impl.ReservationDAOImpl;
import dao.Custom.impl.RoomDAOImpl;
import dao.Custom.impl.StudentDAOImpl;
import dao.Custom.impl.UserDaoImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {

    }

    public static DAOFactory getInstance() {
        return daoFactory == null ? daoFactory = new DAOFactory() : daoFactory;
    }

    public SuperDAO getDAO(DAOTypes DAOTypes) {
        switch (DAOTypes) {
            case USER:
                return new UserDaoImpl();
            case STUDENT:
                return new StudentDAOImpl();
            case ROOM:
                return new RoomDAOImpl();
            case RESERVATION:
                return new ReservationDAOImpl();
            default:
                return null;
        }
    }

    public enum DAOTypes {
        USER, STUDENT, ROOM, RESERVATION
    }
}
