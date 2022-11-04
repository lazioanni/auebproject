package gr.aueb.sev.dao.studentcourse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import gr.aueb.sev.dao.dbutil.DBUtil;
import gr.aueb.sev.model.Course;
import gr.aueb.sev.model.Student;
import gr.aueb.sev.model.StudentCourse;

public class StudentCourseDAOImpl implements IStudentCourseDAO {

	@Override
	public void insert(StudentCourse studentCourse) throws SQLException {
		PreparedStatement pst = null;
		Connection conn = DBUtil.openConnection();
		
		try {
			//SQL statement
			String sql = "INSERT INTO STUDENTCOURSE (COURSES_ID,STUDENTS_ID) VALUES(?, ?)";
			
			pst = conn.prepareStatement(sql);
			pst.setInt(1,studentCourse.getCourseId());
			pst.setInt(2,studentCourse.getStudentId());
			
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
	public StudentCourse delete(StudentCourse studentCourse) throws SQLException {
		PreparedStatement pst = null;
		Connection conn = DBUtil.openConnection();
		
		try {
			//SQL statement
			String sql = "DELETE FROM STUDENTCOURSE WHERE COURSES_ID = ?";
			
			pst = conn.prepareStatement(sql);
			pst.setLong(1,studentCourse.getCourseId());
			pst.executeUpdate();
			
			
			return studentCourse;
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(pst != null) pst.close();
			if(conn != null ) DBUtil.closeConnection();
		}
	}

	@Override
	public List<Course> getStudentCourses(Student student, Course course) {
		
		return null;
	}

	@Override
	public List<Student> getCourseStudents(Course course, Student student) {
		// TODO Auto-generated method stub
		return null;
	}

}
