package dao.Custom.impl;

import dao.Custom.StudentDAO;
import entity.Student;

import java.sql.SQLException;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public boolean save(Student entity) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public boolean update(Student entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Student get(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<Student> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }
}
