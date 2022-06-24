package bo.custom;

import bo.SuperBO;
import dto.RoomDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RoomBO extends SuperBO {
    boolean saveRoom(RoomDTO dto) throws SQLException, ClassNotFoundException;

    boolean updateRoom(RoomDTO dto) throws SQLException, ClassNotFoundException;

    boolean deleteRoom(String id) throws SQLException, ClassNotFoundException;

    RoomDTO getRoom(String id) throws SQLException, ClassNotFoundException;

    ArrayList<RoomDTO> getAllRooms() throws SQLException, ClassNotFoundException;

    ArrayList<RoomDTO> getMatchingRooms(String search) throws SQLException, ClassNotFoundException;
}
