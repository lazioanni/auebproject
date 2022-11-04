package gr.aueb.sev.service.course;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.sev.dto.CourseDTO;
import gr.aueb.sev.model.Course;

public interface ICourseService {
	void insert(CourseDTO courseDTO) throws SQLException;
	void delete(CourseDTO courseDTO) throws SQLException;
	void update(CourseDTO oldCourseDTO, CourseDTO newCourseDTO) throws SQLException;
	List<Course> getAllCourses() throws SQLException;
}
