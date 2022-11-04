package gr.aueb.sev.service.teacher;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.sev.dto.TeacherDTO;
import gr.aueb.sev.model.Teacher;


public interface ITeacherService {
	void insertTeacher(TeacherDTO teacherDTO) throws  SQLException;
	void deleteTeacher(TeacherDTO teacherDTO) throws SQLException;
	void updateTeacher(TeacherDTO oldTeacherDTO, TeacherDTO newTeacherDTO) throws SQLException;
	List<Teacher> getTeachersBySurname(String surname) throws SQLException;
	Teacher getTeacherById(int id) throws SQLException;
	List<Teacher> getAllTeachers() throws SQLException;
}
