package gr.aueb.sev.dao.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gr.aueb.sev.model.Student;
import gr.aueb.sev.dao.dbutil.*;

public class StudentDAOImpl implements IStudentDAO{

	@Override
	public void insert(Student student) throws SQLException {
		PreparedStatement pst = null;
		Connection conn = DBUtil.openConnection();
		
		try {
			String sql = "INSERT INTO STUDENTS (FIRSTNAME, LASTNAME, STUDENT_RANK, UNIVERSITY, EMAIL_ID) VALUES (?, ?, ?, ?, ?)";
			
		
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, student.getFirstname());
			pst.setString(2, student.getLastname());
			pst.setString(3, student.getRank());
			pst.setString(4, student.getUniversity());
			pst.setInt(5, student.getEmailId());
					
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
	public Student delete(Student student) throws SQLException {
		PreparedStatement pst = null;
		Connection conn = DBUtil.openConnection();
		
		try {
			//SQL statement
			String sql = "DELETE FROM STUDENTS WHERE ID = ?";
			
			pst = conn.prepareStatement(sql);
			pst.setLong(1,student.getId());
			pst.executeUpdate();
			
			
			return student;
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(pst != null) pst.close();
			if(conn != null ) DBUtil.closeConnection();
		}
	}

	@Override
	public void update(Student oldStudent, Student newStudent) throws SQLException {
		PreparedStatement pst = null;
		Connection conn = DBUtil.openConnection();
		
		try {
			String sql = "UPDATE STUDENTS SET FIRSTNAME = ?, LASTNAME = ? ,STUDENT_RANK = ?,"
					+ " UNIVERSITY = ? , EMAIL_ID = ?  WHERE ID = ?";
			
			pst = conn.prepareStatement(sql);
			pst.setString(1,newStudent.getFirstname());
			pst.setString(2,newStudent.getLastname());
			pst.setString(3,newStudent.getRank());
			pst.setString(4,newStudent.getUniversity());
			pst.setInt(5,newStudent.getEmailId());
			pst.setInt(6,oldStudent.getId());
			
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
	public Student getStudentById(int id) throws SQLException {
		PreparedStatement pst = null;
		Connection conn = DBUtil.openConnection();
		ResultSet resultSet = null;
		Student student =  new Student();
		
		try {
			//SQL statement
			String sql = "SELECT * FROM STUDENTS WHERE ID=?";
			
			pst = conn.prepareStatement(sql);
			pst.setLong(1,id);
			
			resultSet = pst.executeQuery();
			
			if(resultSet.next()) {
				student.setId(resultSet.getInt("ID"));
				student.setFirstname(resultSet.getString("FIRSTNAME"));
				student.setLastname(resultSet.getString("LASTNAME"));
				student.setRank(resultSet.getString("STUDENT_RANK"));
				student.setUniversity(resultSet.getString("UNIVERSITY"));
				student.setEmailId(resultSet.getInt("EMAIL_ID"));
			}
			return student;
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(pst != null) pst.close();
			if(conn != null ) DBUtil.closeConnection();
		}
	}

	@Override
	public List<Student> getStudentsByLastname(String lastname) throws SQLException {
		PreparedStatement pst = null;
		Connection conn = DBUtil.openConnection();
		ResultSet resultSet = null;
		List<Student> students = new ArrayList<>();
		
		try {
			//SQL statement
			String sql = "SELECT * FROM STUDENTS WHERE LASTNAME LIKE ?";
			
			pst = conn.prepareStatement(sql);
			pst.setString(1,lastname+"%");
			
			resultSet = pst.executeQuery();
			
			while(resultSet.next()) {
				Student student = new Student();
				student.setId(resultSet.getInt("ID"));
				student.setFirstname(resultSet.getString("FIRSTNAME"));
				student.setLastname(resultSet.getString("LASTNAME"));
				student.setRank(resultSet.getString("STUDENT_RANK"));
				student.setUniversity(resultSet.getString("UNIVERSITY"));
				student.setEmailId(resultSet.getInt("EMAIL_ID"));
				students.add(student);
			}
			
			
			return students;
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(pst != null) pst.close();
			if(conn != null ) DBUtil.closeConnection();
		}
	}

	@Override
	public List<Student> getAllStudents() throws SQLException {
		PreparedStatement pst = null;
		Connection conn = DBUtil.openConnection();
		ResultSet resultSet = null;
		List<Student> students = new ArrayList<>();
		
		try {
			//SQL statement
			String sql = "SELECT * FROM STUDENTS";
			
			pst = conn.prepareStatement(sql);
			resultSet = pst.executeQuery();
			
			while(resultSet.next()) {
				Student student = new Student();
				student.setId(resultSet.getInt("ID"));
				student.setFirstname(resultSet.getString("FIRSTNAME"));
				student.setLastname(resultSet.getString("LASTNAME"));
				student.setRank(resultSet.getString("STUDENT_RANK"));
				student.setUniversity(resultSet.getString("UNIVERSITY"));
				student.setEmailId(resultSet.getInt("EMAIL_ID"));
				students.add(student);
			}
			
			
			return students;
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(pst != null) pst.close();
			if(conn != null ) DBUtil.closeConnection();
		}
	}

}
