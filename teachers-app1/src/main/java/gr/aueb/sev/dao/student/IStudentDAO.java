package gr.aueb.sev.dao.student;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.sev.model.Student;


/**
 * A interface who gives virtual methods to Data Access Object for Model class
 * Student.
 * 
 * @author lazaros
 * @version 0.1
 */
public interface IStudentDAO {
	void insert(Student student) throws SQLException;
	Student delete(Student student) throws SQLException;
	void update(Student oldStudent, Student newStudent) throws SQLException;
	Student getStudentById(int id) throws SQLException;
	List<Student> getStudentsByLastname(String lastname) throws SQLException;
	List<Student> getAllStudents() throws SQLException;
}

