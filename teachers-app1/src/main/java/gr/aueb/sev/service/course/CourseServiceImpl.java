package gr.aueb.sev.service.course;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.sev.dao.course.ICourseDAO;
import gr.aueb.sev.dto.CourseDTO;
import gr.aueb.sev.model.Course;

public class CourseServiceImpl implements ICourseService{
	private final ICourseDAO courseDAO;
	
	public CourseServiceImpl(ICourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	@Override
	public void insert(CourseDTO courseDTO) throws SQLException {
		try {
			courseDAO.insert(this.extract(courseDTO));
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public void delete(CourseDTO courseDTO) throws SQLException {
		Course course = this.extract(courseDTO);

		try {
			if(courseDAO.delete(course) == null);
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public void update(CourseDTO oldCourseDTO, CourseDTO newCourseDTO) throws SQLException {
		Course oldCourse = this.extract(oldCourseDTO);
		Course newCourse = this.extract(newCourseDTO);

		try {
			courseDAO.update(oldCourse,newCourse);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<Course> getAllCourses() throws SQLException {
		return courseDAO.getAllCourses();
	}
	
	private Course extract(CourseDTO courseDTO) {
		Course course = new Course();
		course.setId(courseDTO.getId());
		course.setDescription(courseDTO.getDescription());
		course.setTitle(courseDTO.getTitle());
		course.setTeacherId(courseDTO.getTeacherId());
		return course;
	}

}
