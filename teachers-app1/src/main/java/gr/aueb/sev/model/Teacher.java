package gr.aueb.sev.model;

import java.util.Objects;

/**
 * A POJO class who represents an 
 * individual teacher.
 * 
 * @author lazaros
 * @version 0.1
 */
public class Teacher {
	private int id;
	private int emailId;
	private String firstname;
	private String lastname;
	private String subject;
	private String rank;
	
	
	//Default Constructor
	public Teacher() {
	}

	//Overloaded Constructor
	public Teacher(int id, int emailId, String firstname, String lastname, String subject, String rank) {
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

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", emailId=" + emailId + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", subject=" + subject + ", rank=" + rank + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(emailId, firstname, id, lastname, rank, subject);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teacher other = (Teacher) obj;
		return emailId == other.emailId && Objects.equals(firstname, other.firstname) && id == other.id
				&& Objects.equals(lastname, other.lastname) && Objects.equals(rank, other.rank)
				&& Objects.equals(subject, other.subject);
	}
	
	

	
	
}
