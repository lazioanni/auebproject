package gr.aueb.sev.service.studentcourse;

import java.sql.SQLException;

import gr.aueb.sev.dao.studentcourse.IStudentCourseDAO;
import gr.aueb.sev.dto.StudentCourseDTO;
import gr.aueb.sev.model.StudentCourse;

public class StudentCourseServiceImpl implements IStudentCourseService {
	
	private final IStudentCourseDAO studentCourseDAO;
	
	public StudentCourseServiceImpl(IStudentCourseDAO studentCourseDAO) {
		this.studentCourseDAO = studentCourseDAO;
	}

	@Override
	public void insert(StudentCourseDTO studentCourseDTO) throws SQLException {
		try {
			studentCourseDAO.insert(this.extract(studentCourseDTO));
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public void delete(StudentCourseDTO studentCourseDTO) throws SQLException {
		try {
			studentCourseDAO.delete(this.extract(studentCourseDTO));
		} catch (SQLException e) {
			throw e;
		}
	}
	
	private StudentCourse extract(StudentCourseDTO studentCourseDTO) {
		StudentCourse studentCourse = new StudentCourse();
		studentCourse.setCourseId(studentCourseDTO.getCourseId());
		studentCourse.setStudentId(studentCourseDTO.getStudentId());
		return studentCourse;
	}

}
