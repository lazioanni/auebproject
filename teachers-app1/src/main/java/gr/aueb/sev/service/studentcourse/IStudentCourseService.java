package gr.aueb.sev.service.studentcourse;

import java.sql.SQLException;

import gr.aueb.sev.dto.StudentCourseDTO;

public interface IStudentCourseService {
	void insert(StudentCourseDTO studentCourseDTO) throws SQLException;
	void delete(StudentCourseDTO studentCourseDTO) throws SQLException;
}
