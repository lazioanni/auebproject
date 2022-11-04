package gr.aueb.sev.dao.course;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.sev.model.Course;

public interface ICourseDAO {
	void insert(Course course) throws SQLException;
	Course delete(Course course) throws SQLException;
	void update(Course oldCourse, Course newCourse) throws SQLException;
	List<Course> getAllCourses() throws SQLException;
}
