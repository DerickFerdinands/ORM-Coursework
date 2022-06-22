package dao.Custom.impl;

import dao.Custom.ReservationDAO;
import entity.Reservation;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;

import java.sql.SQLException;
import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {
    @Override
    public boolean save(Reservation entity) throws ClassNotFoundException, SQLException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Reservation entity) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(session.load(Reservation.class, s));
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Reservation get(String s) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Reservation reservation = session.get(Reservation.class, s);
        transaction.commit();
        session.close();
        return reservation;
    }

    @Override
    public List<Reservation> getAll() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List list = session.createQuery("From Reservation").list();
        transaction.commit();
        session.close();
        return list;
    }
}
