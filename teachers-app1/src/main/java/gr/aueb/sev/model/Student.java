package gr.aueb.sev.model;

import java.util.Objects;

/**
 * A POJO class who represents an 
 * individual student.
 * 
 * @author lazaros
 * @version 0.1
 */
public class Student {
	private int id;
	private int emailId;
	private String firstname;
	private String lastname;
	private String rank;
	private String university;
	
	//Default Constructor
	public Student() {}

	//Overloaded Constructor
	public Student(int id, int emailId, String firstname, String lastname, String rank, String university) {
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

	@Override
	public String toString() {
		return "Student [id=" + id + ", emailId=" + emailId + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", rank=" + rank + ", university=" + university + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(emailId, firstname, id, lastname, rank, university);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return emailId == other.emailId && Objects.equals(firstname, other.firstname) && id == other.id
				&& Objects.equals(lastname, other.lastname) && Objects.equals(rank, other.rank)
				&& Objects.equals(university, other.university);
	}
	
	
	
	

}