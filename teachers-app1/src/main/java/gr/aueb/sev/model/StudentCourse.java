package gr.aueb.sev.model;

import java.util.Objects;

/**
 * A POJO class to get the relationship between students and courses.
 * 
 * @author lazaros
 * @version 0.1
 *
 */
public class StudentCourse {
	// A single student id
	private int studentId;
	// A single course id
	private int courseId;

	// Default Constructor
	public StudentCourse() {
	}

	// Overloaded Constructor
	public StudentCourse(int studentId, int courseId) {
		this.studentId = studentId;
		this.courseId = courseId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	@Override
	public String toString() {
		return "StudentCourse [studentId=" + studentId + ", courseId=" + courseId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(courseId, studentId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentCourse other = (StudentCourse) obj;
		return courseId == other.courseId && studentId == other.studentId;
	}
	
	

}
