package gr.aueb.sev.service.teacher;

import java.sql.SQLException;

import java.util.List;

import gr.aueb.sev.dao.teacher.ITeacherDAO;
import gr.aueb.sev.dto.TeacherDTO;
import gr.aueb.sev.model.Teacher;



public class TeacherServiceImpl implements ITeacherService {
	
	private final ITeacherDAO teacherDAO;
	
	public TeacherServiceImpl(ITeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	@Override
	public void insertTeacher(TeacherDTO teacherDTO) throws SQLException {
		Teacher teacher = this.extract(teacherDTO);
		try {
			
			teacherDAO.insert(teacher);
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public void deleteTeacher(TeacherDTO teacherDTO) throws SQLException {
		Teacher teacher = this.extract(teacherDTO);

		try {
			if(teacherDAO.delete(teacher) == null);
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public void updateTeacher(TeacherDTO oldTeacherDTO, TeacherDTO newTeacherDTO) throws SQLException {
		Teacher oldTeacher = this.extract(oldTeacherDTO);
		Teacher newTeacher = this.extract(newTeacherDTO);

		try {
			teacherDAO.update(oldTeacher,newTeacher);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<Teacher> getTeachersBySurname(String surname) throws SQLException {
		try {
			return teacherDAO.getTeachersByLastname(surname);
		}catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Teacher getTeacherById(int id) throws SQLException {
		try {
			Teacher teacher = teacherDAO.getTeacherById(id);
			
			return teacher;
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<Teacher> getAllTeachers() throws SQLException {
		return teacherDAO.getAllTeachers();
	}
	
	private Teacher extract(TeacherDTO teacherDTO) {
		Teacher teacher = new Teacher();
		teacher.setId(teacherDTO.getId());
		teacher.setFirstname(teacherDTO.getFirstname());
		teacher.setLastname(teacherDTO.getLastname());
		teacher.setSubject(teacherDTO.getSubject());
		teacher.setRank(teacherDTO.getRank());
		teacher.setEmailId(teacherDTO.getEmailId());
		return teacher;
	}

}
