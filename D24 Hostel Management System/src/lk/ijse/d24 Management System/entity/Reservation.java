package entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Reservation {
    @Id
    private String resId;
    private LocalDate date;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="studentId",referencedColumnName = "StudentId")
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="room_type_id", referencedColumnName = "room_Type_id")
    private Room room;
    private String status;

    public Reservation() {
    }
}
