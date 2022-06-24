package bo.custom.impl;

import bo.custom.ReservationBO;
import dao.Custom.ReservationDAO;
import dao.DAOFactory;
import dto.ReservationDTO;
import entity.Reservation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ReservationBOImpl implements ReservationBO {
    private ReservationDAO rDAO = (ReservationDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.RESERVATION);
    @Override
    public boolean saveReservation(ReservationDTO dto) throws SQLException, ClassNotFoundException {
     return rDAO.save(new Reservation(dto.getResId(),dto.getDate(),dto.getStudent(),dto.getRoom(),dto.getStatus()));
    }

    @Override
    public boolean updateReservation(ReservationDTO dto) throws SQLException, ClassNotFoundException {
        return rDAO.update(new Reservation(dto.getResId(),dto.getDate(),dto.getStudent(),dto.getRoom(),dto.getStatus()));
    }

    @Override
    public boolean deleteReservation(String id) throws SQLException, ClassNotFoundException {
        return rDAO.delete(id);
    }

    @Override
    public ReservationDTO getReservation(String id) throws SQLException, ClassNotFoundException {
        Reservation reservation = rDAO.get(id);
        return new ReservationDTO(reservation.getResId(),reservation.getDate(),reservation.getStudent(),reservation.getRoom(),reservation.getStatus());
    }

    @Override
    public ArrayList<ReservationDTO> getAllReservations() throws SQLException, ClassNotFoundException {
        ArrayList<ReservationDTO> resList = new ArrayList<>();
        resList.addAll(rDAO.getAll().stream().map(reservation -> {
            return new ReservationDTO(reservation.getResId(),reservation.getDate(),reservation.getStudent(),reservation.getRoom(),reservation.getStatus());
        }).collect(Collectors.toList()));
        return resList;
    }

    @Override
    public ArrayList<ReservationDTO> getMatchingReservations(String search) throws SQLException, ClassNotFoundException {
        ArrayList<ReservationDTO> resList = new ArrayList<>();
        resList.addAll(rDAO.getMatchingResults("%"+search+"%").stream().map(reservation -> {
            return new ReservationDTO(reservation.getResId(),reservation.getDate(),reservation.getStudent(),reservation.getRoom(),reservation.getStatus());
        }).collect(Collectors.toList()));
        return resList;
    }
}
