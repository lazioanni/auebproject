package gr.aueb.sev.dto;

/**
 * A POJO class who represents a
 * Teacher Data Transfer Object.
 * 
 * @author lazaros
 * @version 0.1
 */
public class TeacherDTO {
	private int id;
	private int emailId;
	private String firstname;
	private String lastname;
	private String subject;
	private String rank;
	
	
	//Default Constructor
	public TeacherDTO() {
	}

	//Overloaded Constructor
	public TeacherDTO(int id, int emailId, String firstname, String lastname, String subject, String rank) {
		this.id = id;
		this.emailId = emailId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.subject = subject;
		this.rank = rank;
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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}
	
}
