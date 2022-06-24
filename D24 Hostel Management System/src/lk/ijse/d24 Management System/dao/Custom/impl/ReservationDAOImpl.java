package dao.Custom.impl;

import dao.Custom.ReservationDAO;
import entity.Reservation;
import entity.Room;
import entity.Student;
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
        Student student = entity.getStudent();
        student.getResList().add(entity);
        Room room = entity.getRoom();
        room.getResList().add(entity);
        session.update(student);
        session.update(room);
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

    @Override
    public List<Reservation> getMatchingResults(String search) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List list = session.createQuery("From Reservation WHERE resId LIKE: ID OR date = : Date OR student = : Student OR room =:Room OR status LIKE: Status")
                .setParameter("ID",search)
                .setParameter("Date",search)
                .setParameter("Student",session.load(Student.class,search))
                .setParameter("Room",session.load(Room.class,search))
                .setParameter("Status",search)
                .list();
        transaction.commit();
        session.close();
        return list;
    }
}
