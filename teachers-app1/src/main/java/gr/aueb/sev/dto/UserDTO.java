package gr.aueb.sev.dto;

public class UserDTO {
	private int id;
	private int emailId;
	private String password;
	private String role;
	
	
	public UserDTO() {}


	public UserDTO(int id, int emailId, String password, String role) {
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

}
