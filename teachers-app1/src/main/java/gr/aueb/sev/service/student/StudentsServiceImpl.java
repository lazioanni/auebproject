package gr.aueb.sev.service.student;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.sev.dao.student.IStudentDAO;
import gr.aueb.sev.dto.StudentDTO;
import gr.aueb.sev.model.Student;

public class StudentsServiceImpl implements IStudentService {
	private final IStudentDAO studentDAO;
	
	public StudentsServiceImpl(IStudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Override
	public void insert(StudentDTO studentDTO) throws SQLException {
		try {
			studentDAO.insert(this.extract(studentDTO));
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public void delete(StudentDTO studentDTO) throws SQLException {
		Student student = this.extract(studentDTO);

		try {
			if(studentDAO.delete(student) == null);
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public void update(StudentDTO oldStudentDTO, StudentDTO newStudentDTO) throws SQLException {
		Student oldStudent = this.extract(oldStudentDTO);
		Student newStudent = this.extract(newStudentDTO);

		try {
			studentDAO.update(oldStudent,newStudent);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Student getStudentById(int id) throws SQLException {
		try {
			Student student =studentDAO.getStudentById(id);
			
			return student;
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<Student> getStudentsByLastname(String lastname) throws SQLException {
		try {
			return studentDAO.getStudentsByLastname(lastname);
		}catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<Student> getAllStudents() throws SQLException {
		return studentDAO.getAllStudents();
	}
	
	private Student extract(StudentDTO studentDTO) {
		Student student = new Student();
		student.setId(studentDTO.getId());
		student.setFirstname(studentDTO.getFirstname());
		student.setLastname(studentDTO.getLastname());
		student.setRank(studentDTO.getRank());
		student.setUniversity(studentDTO.getUniversity());
		student.setEmailId(studentDTO.getEmailId());
		return student;
	}

}
