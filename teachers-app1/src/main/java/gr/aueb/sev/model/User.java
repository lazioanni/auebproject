package gr.aueb.sev.model;

import java.util.Objects;

public class User {
	private int id;
	private int emailId;
	private String password;
	private String role;
	
	
	public User() {}


	public User(int id, int emailId, String password, String role) {
		super();
		this.id = id;
		this.emailId = emailId;
		this.password = password;
		this.role = role;
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", emailId=" + emailId + ", password=" + password + ", role=" + role + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(emailId, id, password, role);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return emailId == other.emailId && id == other.id && Objects.equals(password, other.password)
				&& Objects.equals(role, other.role);
	}


	
	
}
