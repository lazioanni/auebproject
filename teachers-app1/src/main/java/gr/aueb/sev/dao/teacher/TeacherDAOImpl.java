package gr.aueb.sev.dao.teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import gr.aueb.sev.dao.dbutil.*;
import gr.aueb.sev.model.Teacher;

public class TeacherDAOImpl implements ITeacherDAO {

	@Override
	public void insert(Teacher teacher) throws SQLException {
		PreparedStatement pst = null;
		Connection conn = DBUtil.openConnection();
		
		try {
			
			String sql = "INSERT INTO TEACHERS (FIRSTNAME, LASTNAME, SUBJECT, TEACHER_RANK, EMAIL_ID) VALUES (?, ?, ?, ?, ?)";
			
			
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, teacher.getFirstname());
			pst.setString(2, teacher.getLastname());
			pst.setString(3, teacher.getSubject());
			pst.setString(4, teacher.getRank());
			pst.setInt(5, teacher.getEmailId());
					
			pst.executeUpdate();
					
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(pst != null) pst.close();
			if(conn != null ) DBUtil.closeConnection();
		}
		
	}

	@Override
	public Teacher delete(Teacher teacher) throws SQLException {
		PreparedStatement pst = null;
		Connection conn = DBUtil.openConnection();
		
		try {
			//SQL statement
			String sql = "DELETE FROM TEACHERS WHERE ID = ?";
			
			pst = conn.prepareStatement(sql);
			pst.setLong(1,teacher.getId());
			pst.executeUpdate();
			
			return teacher;
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(pst != null) pst.close();
			if(conn != null ) DBUtil.closeConnection();
		}
	}

	@Override
	public void update(Teacher oldTeacher, Teacher newTeacher) throws SQLException {

		PreparedStatement pst = null;
		Connection conn = DBUtil.openConnection();
		
		try {
			String sql = "UPDATE TEACHERS SET FIRSTNAME = ?, LASTNAME = ? ,SUBJECT = ?,"
					+ "TEACHER_RANK = ? , EMAIL_ID = ?  WHERE ID = ?";
			
			pst = conn.prepareStatement(sql);
			pst.setString(1,newTeacher.getFirstname());
			pst.setString(2,newTeacher.getLastname());
			pst.setString(3,newTeacher.getSubject());
			pst.setString(4,newTeacher.getRank());
			pst.setInt(5,newTeacher.getEmailId());
			pst.setInt(6,oldTeacher.getId());
			
			
			
			pst.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(pst != null) pst.close();
			if(conn != null ) DBUtil.closeConnection();
		}
	}

	@Override
	public Teacher getTeacherById(int id) throws SQLException {
		PreparedStatement pst = null;
		Connection conn = DBUtil.openConnection();
		ResultSet resultSet = null;
		Teacher teacher = new Teacher();
		
		try {
			//SQL statement
			String sql = "SELECT * FROM TEACHERS WHERE ID=?";
			
			pst = conn.prepareStatement(sql);
			pst.setLong(1,id);
			
			resultSet = pst.executeQuery();
			
			if(resultSet.next()) {
				teacher.setId(resultSet.getInt("ID"));
				teacher.setFirstname(resultSet.getString("FIRSTNAME"));
				teacher.setLastname(resultSet.getString("LASTNAME"));
				teacher.setSubject(resultSet.getString("SUBJECT"));
				teacher.setRank(resultSet.getString("TEACHER_RANK"));
				teacher.setEmailId(resultSet.getInt("EMAIL_ID"));
			}
			return teacher;
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(pst != null) pst.close();
			if(conn != null ) DBUtil.closeConnection();
		}
	}

	@Override
	public List<Teacher> getTeachersByLastname(String lastname) throws SQLException {
		PreparedStatement pst = null;
		Connection conn = DBUtil.openConnection();
		ResultSet resultSet = null;
		List<Teacher> teachers = new ArrayList<>();
		
		try {
			//SQL statement
			String sql = "SELECT * FROM TEACHERS WHERE LASTNAME LIKE ?";
			
			pst = conn.prepareStatement(sql);
			pst.setString(1,lastname+"%");
			
			resultSet = pst.executeQuery();
			
			while(resultSet.next()) {
				Teacher teacher = new Teacher();
				teacher.setId(resultSet.getInt("ID"));
				teacher.setFirstname(resultSet.getString("FIRSTNAME"));
				teacher.setLastname(resultSet.getString("LASTNAME"));
				teacher.setSubject(resultSet.getString("SUBJECT"));
				teacher.setRank(resultSet.getString("TEACHER_RANK"));
				teacher.setEmailId(resultSet.getInt("EMAIL_ID"));
				teachers.add(teacher);
			}
			
			JOptionPane.showMessageDialog(null, "Records found", "Founded", 
					JOptionPane.PLAIN_MESSAGE);
			
			return teachers;
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(pst != null) pst.close();
			if(conn != null ) DBUtil.closeConnection();
		}
	}

	@Override
	public List<Teacher> getAllTeachers() throws SQLException {
		PreparedStatement pst = null;
		Connection conn = DBUtil.openConnection();
		ResultSet resultSet = null;
		List<Teacher> teachers = new ArrayList<>();
		
		try {
			//SQL statement
			String sql = "SELECT * FROM TEACHERS";
			
			pst = conn.prepareStatement(sql);
			
			resultSet = pst.executeQuery();
			
			while(resultSet.next()) {
				Teacher teacher = new Teacher();
				teacher.setId(resultSet.getInt("ID"));
				teacher.setFirstname(resultSet.getString("FIRSTNAME"));
				teacher.setLastname(resultSet.getString("LASTNAME"));
				teacher.setSubject(resultSet.getString("SUBJECT"));
				teacher.setRank(resultSet.getString("TEACHER_RANK"));
				teacher.setEmailId(resultSet.getInt("EMAIL_ID"));
				teachers.add(teacher);
			}
			
			
			return teachers;
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(pst != null) pst.close();
			if(conn != null ) DBUtil.closeConnection();
		}
	}


}
