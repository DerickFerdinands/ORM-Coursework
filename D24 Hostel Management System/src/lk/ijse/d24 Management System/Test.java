import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<Object[]> list = session.createQuery("SELECT reservation.resId,s.StudentId,s.name, r.room_Type_id, r.type, reservation.status FROM Reservation reservation JOIN Student s ON reservation.student=s.StudentId JOIN Room r ON reservation.room=r.room_Type_id WHERE reservation.status='Pending'").list();
        for(Object[] o: list){
            System.out.println(o[0]+" : "+o[1]+" : "+o[2]+" : "+o[3]+" : "+o[4]+" : "+o[5]);
        }
        transaction.commit();
        session.close();
    }
}
