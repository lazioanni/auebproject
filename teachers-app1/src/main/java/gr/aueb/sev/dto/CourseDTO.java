package gr.aueb.sev.dto;

/**
 * A POJO class who represents a
 * Course Data Transfer Object.
 * @author lazaros
 * @version 0.1
 *
 */
public class CourseDTO {
	//A single course id
	private int id;
	//Course Title
	private String title;
	//Course Description
	private String  description;
	//Teacher's who teaches this course id 
	private int teacherId;
	
	
	//Default constructor
	public CourseDTO() {}
	
	//Overloaded constructor
	public CourseDTO(int id, String title, String description, int teacherId) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.teacherId = teacherId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
}
