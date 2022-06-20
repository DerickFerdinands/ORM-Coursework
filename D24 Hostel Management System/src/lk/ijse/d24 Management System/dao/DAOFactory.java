package dao;

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
            default:
                return null;
        }
    }

    public enum DAOTypes {
        USER
    }
}
