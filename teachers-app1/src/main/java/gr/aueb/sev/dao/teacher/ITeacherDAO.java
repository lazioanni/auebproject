package gr.aueb.sev.dao.teacher;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.sev.model.Teacher;



/**
 * A interface who gives virtual methods to Data Access Object for Model class
 * Teacher.
 * 
 * @author lazaros
 * @version 0.1
 */
public interface ITeacherDAO {
	void insert(Teacher teacher) throws SQLException;
	Teacher delete(Teacher teacher) throws SQLException;
	void update(Teacher oldTeacher, Teacher newTeacher) throws SQLException;
	Teacher getTeacherById(int id) throws SQLException;
	List<Teacher> getTeachersByLastname(String lastname) throws SQLException;
	List<Teacher> getAllTeachers() throws SQLException;
	//List<Course> getTeacherCourses(int teacherId) throws SQLException;
}
