package application;

public class RegistrationData {

	private String role;
	private String username;
	private String password;
	private String lastname;
	private String firstname;
	
	public static RegistrationData create(String username, String password, String firstname, String lastname, String role) {
		return new RegistrationData(username, password, firstname, lastname, role);
	}
	
	public RegistrationData(String username, String password, String lastname, String firstname, String role) {
		this.role = role;
		this.username = username;
		this.password = password;
		this.lastname = lastname;
		this.firstname = firstname;
	}

	public String getRole() {
		return role;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getLastname() {
		return lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	
	

}
