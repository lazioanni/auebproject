package gr.aueb.sev.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gr.aueb.sev.model.User;
import gr.aueb.sev.dao.dbutil.*;
import gr.aueb.sev.enums.ROLE;

public class UserDAOImpl implements IUserDAO {

	@Override
	public void insert(User user) throws SQLException {
		PreparedStatement pst = null;
		Connection conn = DBUtil.openConnection();
		
		try {
			//SQL statement
			String sql = "INSERT INTO USERS (PASSWORD,ROLE,EMAIL_ID) VALUES(?, ?, ?)";
			
			pst = conn.prepareStatement(sql);
			pst.setString(1,user.getPassword());
			pst.setString(2,user.getRole());
			pst.setInt(3,user.getEmailId());
			
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
	public void delete(User user) throws SQLException {
		PreparedStatement pst = null;
		Connection conn = DBUtil.openConnection();
		
		try {
			//SQL statement
			String sql = "DELETE FROM USERS WHERE ID = ?";
			
			pst = conn.prepareStatement(sql);
			pst.setLong(1,user.getId());
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
	public User getUserByEmailId(int emailId) throws SQLException {
		PreparedStatement pst = null;
		Connection conn = DBUtil.openConnection();
		ResultSet resultSet = null;
		User user = new User();
		
		try {
			//SQL statement
			String sql = "SELECT * FROM USERS WHERE EMAIL_ID = ?";
			
			pst = conn.prepareStatement(sql);
			pst.setInt(1,emailId);
			
			resultSet = pst.executeQuery();
			
			if(resultSet.next()) {
				user.setId(resultSet.getInt("ID"));
				user.setPassword(resultSet.getString("PASSWORD"));
				user.setRole(resultSet.getString("ROLE"));
				user.setEmailId(resultSet.getInt("EMAIL_ID"));
			}
			return user;
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(pst != null) pst.close();
			if(conn != null ) DBUtil.closeConnection();
		}
	}

	@Override
	public List<User> getAllTeachers() throws SQLException {
		PreparedStatement pst = null;
		Connection conn = DBUtil.openConnection();
		ResultSet resultSet = null;
		List<User> users = new ArrayList<>();
		
		try {
			//SQL statement
			String sql = "SELECT * FROM USERS WHERE ROLE LIKE ?";
			
			pst = conn.prepareStatement(sql);
			pst.setString(1,ROLE.TEACHER.toString());
			
			resultSet = pst.executeQuery();
			
			while(resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt("ID"));
				user.setEmailId(resultSet.getInt("EMAIL_ID"));
				user.setPassword(resultSet.getString("PASSWORD"));
				user.setRole(resultSet.getString("ROLE"));
				users.add(user);
			}
			
			
			return users;
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(pst != null) pst.close();
			if(conn != null ) DBUtil.closeConnection();
		}
	}

	@Override
	public List<User> getAllStudents() throws SQLException {
		PreparedStatement pst = null;
		Connection conn = DBUtil.openConnection();
		ResultSet resultSet = null;
		List<User> users = new ArrayList<>();
		
		try {
			//SQL statement
			String sql = "SELECT * FROM USERS WHERE ROLE LIKE ?";
			
			pst = conn.prepareStatement(sql);
			pst.setString(1,ROLE.STUDENT.toString());
			
			resultSet = pst.executeQuery();
			
			while(resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt("ID"));
				user.setEmailId(resultSet.getInt("EMAIL_ID"));
				user.setPassword(resultSet.getString("PASSWORD"));
				user.setRole(resultSet.getString("ROLE"));
				users.add(user);
			}
			
			
			return users;
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(pst != null) pst.close();
			if(conn != null ) DBUtil.closeConnection();
		}
	}

}
