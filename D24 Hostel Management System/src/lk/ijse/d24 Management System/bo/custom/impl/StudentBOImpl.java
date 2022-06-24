package bo.custom.impl;

import bo.custom.StudentBO;
import dao.Custom.StudentDAO;
import dao.DAOFactory;
import dto.StudentDTO;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class StudentBOImpl implements StudentBO {
    private StudentDAO sDAO = (StudentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STUDENT);


    @Override
    public boolean saveStudent(StudentDTO dto) throws SQLException, ClassNotFoundException {
        return sDAO.save(new Student(dto.getStudentId(),dto.getName(),dto.getAddress(),dto.getContactNo(),dto.getDob(),dto.getGender(),null));
    }

    @Override
    public boolean updateStudent(StudentDTO dto) throws SQLException, ClassNotFoundException {
        return sDAO.update(new Student(dto.getStudentId(),dto.getName(),dto.getAddress(),dto.getContactNo(),dto.getDob(),dto.getGender(),null));
    }

    @Override
    public boolean deleteStudent(String id) throws SQLException, ClassNotFoundException {
        return sDAO.delete(id);
    }

    @Override
    public StudentDTO getStudent(String id) throws SQLException, ClassNotFoundException {
        Student student = sDAO.get(id);
        return new StudentDTO(student.getStudentId(),student.getName(),student.getAddress(),student.getContactNo(),student.getDob(),student.getGender());
    }

    @Override
    public ArrayList<StudentDTO> getAllStudents() throws SQLException, ClassNotFoundException {
        ArrayList<StudentDTO> studentList = new ArrayList<>();
        studentList.addAll(sDAO.getAll().stream().map(student -> {return new StudentDTO(student.getStudentId(),student.getName(),student.getAddress(),student.getContactNo(),student.getDob(),student.getGender());}).collect(Collectors.toList()));
        return studentList;
    }

    @Override
    public ArrayList<StudentDTO> getMatchingStudents(String search) throws SQLException, ClassNotFoundException {
        ArrayList<StudentDTO> studentList = new ArrayList<>();
        studentList.addAll(sDAO.getMatchingResults("%"+search+"%").stream().map(student -> {return new StudentDTO(student.getStudentId(),student.getName(),student.getAddress(),student.getContactNo(),student.getDob(),student.getGender());}).collect(Collectors.toList()));
        return studentList;
    }
}
