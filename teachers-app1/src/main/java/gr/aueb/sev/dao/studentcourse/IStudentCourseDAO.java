package gr.aueb.sev.dao.studentcourse;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.sev.model.Course;
import gr.aueb.sev.model.Student;
import gr.aueb.sev.model.StudentCourse;



public interface IStudentCourseDAO {
	void insert(StudentCourse studentCourse) throws SQLException;
	StudentCourse delete(StudentCourse studentCourse) throws SQLException;
	
	List<Course> getStudentCourses(Student student, Course course);
	List<Student> getCourseStudents(Course course, Student student);
	
	
	
}
