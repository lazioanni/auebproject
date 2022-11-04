package gr.aueb.sev.dao.email;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import gr.aueb.sev.dao.dbutil.DBUtil;
import gr.aueb.sev.model.Email;

public class EmailDAOImpl implements IEmailDAO {

	@Override
	public void insert(Email email) throws SQLException {
		PreparedStatement pst = null;
		Connection conn = DBUtil.openConnection();
		
		try {
			//SQL statement
			String sql = "INSERT INTO EMAILS (EMAIL) VALUES(?)";
			
			pst = conn.prepareStatement(sql);
			pst.setString(1,email.getEmail());
			
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
	public void delete(Email email) throws SQLException {
		PreparedStatement pst = null;
		Connection conn = DBUtil.openConnection();
		
		try {
			//SQL statement
			String sql = "DELETE FROM EMAILS WHERE ID = ?";
			
			pst = conn.prepareStatement(sql);
			pst.setLong(1,email.getId());
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
	public Email getUserByEmail(String email) throws SQLException {
		PreparedStatement pst = null;
		Connection conn = DBUtil.openConnection();
		ResultSet resultSet = null;
		Email emailFind = new Email();
		
		try {
			//SQL statement
			String sql = "SELECT * FROM EMAILS WHERE EMAIL  = ?";
			
			pst = conn.prepareStatement(sql);
			pst.setString(1,email);
			
			resultSet = pst.executeQuery();
			
			if(resultSet.next()) {
				emailFind.setId(resultSet.getInt("ID"));
				emailFind.setEmail(resultSet.getString("EMAIL"));
			}
			return emailFind;
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(pst != null) pst.close();
			if(conn != null ) DBUtil.closeConnection();
		}
	}

	@Override
	public Email getEmailById(int id) throws SQLException {
		PreparedStatement pst = null;
		Connection conn = DBUtil.openConnection();
		ResultSet resultSet = null;
		Email emailFind = new Email();
		
		try {
			//SQL statement
			String sql = "SELECT * FROM EMAILS WHERE ID  = ?";
			
			pst = conn.prepareStatement(sql);
			pst.setInt(1,id);
			
			resultSet = pst.executeQuery();
			
			if(resultSet.next()) {
				emailFind.setId(resultSet.getInt("ID"));
				emailFind.setEmail(resultSet.getString("EMAIL"));
			}
			return emailFind;
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(pst != null) pst.close();
			if(conn != null ) DBUtil.closeConnection();
		}
	}

}
