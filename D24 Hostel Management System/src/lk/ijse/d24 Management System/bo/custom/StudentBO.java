package bo.custom;

import bo.SuperBO;
import dto.StudentDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentBO extends SuperBO {
    boolean saveStudent(StudentDTO dto) throws SQLException, ClassNotFoundException;

    boolean updateStudent(StudentDTO dto) throws SQLException, ClassNotFoundException;

    boolean deleteStudent(String id) throws SQLException, ClassNotFoundException;

    StudentDTO getStudent(String id) throws SQLException, ClassNotFoundException;

    ArrayList<StudentDTO> getAllStudents() throws SQLException, ClassNotFoundException;

    ArrayList<StudentDTO> getMatchingStudents(String search) throws SQLException, ClassNotFoundException;
}
