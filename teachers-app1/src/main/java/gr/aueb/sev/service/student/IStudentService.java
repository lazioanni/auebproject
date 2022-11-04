package gr.aueb.sev.service.student;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.sev.dto.StudentDTO;
import gr.aueb.sev.model.Student;

public interface IStudentService {
	void insert(StudentDTO studentDTO) throws SQLException;
	void delete(StudentDTO studentDTO) throws SQLException;
	void update(StudentDTO oldStudentDTO,StudentDTO newStudentDTO) throws SQLException;
	Student getStudentById(int id) throws SQLException;
	List<Student> getStudentsByLastname(String lastname) throws SQLException;
	List<Student> getAllStudents() throws SQLException;
}
