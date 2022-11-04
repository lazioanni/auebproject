package gr.aueb.sev.model;

import java.util.Objects;

/**
 * A POJO class to get the relationship 
 * between teachers and courses.
 * @author lazaros
 * @version 0.1
 *
 */
public class Course {
	//A single course id
	private int id;
	//Course Title
	private String title;
	//Course Description
	private String  description;
	//Teacher's who teaches this course id 
	private int teacherId;
	
	
	//Default constructor
	public Course() {}
	
	//Overloaded constructor
	public Course(int id, String title, String description, int teacherId) {
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

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", description=" + description + ", teacherId=" + teacherId
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id, teacherId, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(description, other.description) && id == other.id && teacherId == other.teacherId
				&& Objects.equals(title, other.title);
	}

	
}
