package gr.aueb.sev.dao.course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gr.aueb.sev.dao.dbutil.DBUtil;
import gr.aueb.sev.model.Course;

public class CourseDAOImpl implements ICourseDAO {

	@Override
	public void insert(Course course) throws SQLException {
		PreparedStatement pst = null;
		Connection conn = DBUtil.openConnection();
		
		try {
			//SQL statement
			String sql = "INSERT INTO COURSES (TITLE,DESCRIPTION,TEACHERS_ID) VALUES(?, ? ,? )";
			
			pst = conn.prepareStatement(sql);
			pst.setString(1,course.getTitle());
			pst.setString(2,course.getDescription());
			pst.setInt(3,course.getTeacherId());
					
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
	public Course delete(Course course) throws SQLException {
		PreparedStatement pst = null;
		Connection conn = DBUtil.openConnection();
		
		try {
			//SQL statement
			String sql = "DELETE FROM COURSES WHERE ID = ?";
			
			pst = conn.prepareStatement(sql);
			pst.setLong(1,course.getId());
			pst.executeUpdate();
			
			
			return course;
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(pst != null) pst.close();
			if(conn != null ) DBUtil.closeConnection();
		}
	}

	@Override
	public void update(Course oldCourse, Course newCourse) throws SQLException {
		PreparedStatement pst = null;
		Connection conn = DBUtil.openConnection();
		
		try {
			String sql = "UPDATE COURSES SET Title = ?, DESCRIPTION = ? , Teachers_ID = ? WHERE ID = ?";
			
			pst = conn.prepareStatement(sql);
			pst.setString(1,newCourse.getTitle());
			pst.setString(2,newCourse.getDescription());
			pst.setInt(3,newCourse.getTeacherId());
			pst.setInt(4,oldCourse.getId());
			
		
			
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
	public List<Course> getAllCourses() throws SQLException {
		PreparedStatement pst = null;
		Connection conn = DBUtil.openConnection();
		ResultSet resultSet = null;
		List<Course> courses = new ArrayList<>();
		
		try {
			//SQL statement
			String sql = "SELECT * FROM COURSES";
			
			pst = conn.prepareStatement(sql);
			resultSet = pst.executeQuery();
			
			while(resultSet.next()) {
				Course course = new Course();
				course.setId(resultSet.getInt("ID"));
				course.setTitle(resultSet.getString("TITLE"));
				course.setDescription(resultSet.getString("DESCRIPTION"));
				course.setTeacherId(resultSet.getInt("TEACHERS_ID"));
				courses.add(course);
			}
			
			
			return courses;
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(pst != null) pst.close();
			if(conn != null ) DBUtil.closeConnection();
		}
	}

}
