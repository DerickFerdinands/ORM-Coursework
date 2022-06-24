package bo.custom;

import bo.SuperBO;
import dto.ReservationDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ReservationBO extends SuperBO {
    boolean saveReservation(ReservationDTO dto) throws SQLException, ClassNotFoundException;

    boolean updateReservation(ReservationDTO dto) throws SQLException, ClassNotFoundException;

    boolean deleteReservation(String id) throws SQLException, ClassNotFoundException;

    ReservationDTO getReservation(String id) throws SQLException, ClassNotFoundException;

    ArrayList<ReservationDTO> getAllReservations() throws SQLException, ClassNotFoundException;

    ArrayList<ReservationDTO> getMatchingReservations(String search) throws SQLException, ClassNotFoundException;
}
