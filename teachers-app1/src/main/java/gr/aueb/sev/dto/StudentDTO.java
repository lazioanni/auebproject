package gr.aueb.sev.dto;
/**
 * A POJO class who represents a
 * Student Data Transfer Object.
 * @author lazaros
 * @version 0.1
 *
 */
public class StudentDTO {
	private int id;
	private int emailId;
	private String firstname;
	private String lastname;
	private String rank;
	private String university;
	
	//Default Constructor
	public StudentDTO() {}

	//Overloaded Constructor
	public StudentDTO(int id, int emailId, String firstname, String lastname, String rank, String university) {
		this.id = id;
		this.emailId = emailId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.rank = rank;
		this.university = university;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmailId() {
		return emailId;
	}

	public void setEmailId(int emailId) {
		this.emailId = emailId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}
}