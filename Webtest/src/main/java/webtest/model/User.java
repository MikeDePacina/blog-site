package webtest.model;

public class User {
	private String userName;
	private String fullName;
	private String role;
	
	public User() {
		this.userName = null;
		this.fullName = null;
		this.role = null;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
