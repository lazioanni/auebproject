package gr.aueb.sev.dto;
/**
 * A POJO class who represents a
 * Student-Course Transfer Object.
 * @author lazaros
 * @version 0.1
 *
 */
public class StudentCourseDTO {
	// A single student id
		private int studentId;
		// A single course id
		private int courseId;

		// Default Constructor
		public StudentCourseDTO() {
		}

		// Overloaded Constructor
		public StudentCourseDTO(int studentId, int courseId) {
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
}