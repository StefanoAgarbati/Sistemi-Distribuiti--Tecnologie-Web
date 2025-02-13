package model;

public class RegisteredUser {
	
	private String email;

	private boolean emailVerified = false;
	private String firstname;
	private String lastname;
	private String password;
	private String roleId;
	private String userId;
	private String displayName = firstname;
	private String username;

	public static RegisteredUser create(String userId, String username, String password, String firstname, String lastname,
			String roleId) {
		return new RegisteredUser(userId, username, password, firstname, lastname, roleId);
	}
	
	public RegisteredUser() {

	}

	public RegisteredUser(String userId, String username, String password, String firstname, String lastname, String roleId) {
		setUsername(username);
		this.setPassword(password);
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setRoleId(roleId);
		this.setUserId(userId);
	}

	public void changePassword(String newPassword) {
		setPassword(newPassword);
	}

	public String getDisplayName() {
		return displayName;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getPassword() {
		return password;
	}

	public String getRoleId() {
		return roleId;
	}

	public String getStringRep() {
		String rep = "{\n" + "username : " + getUsername() + "\n" + "password : " + getPassword() + "\n"
				+ "firstname : " + getFirstname() + "\n" + "lastname : " + this.getLastname() + "\n" + "role : "
				+ this.getRoleId() + "\n" + "}";
		return rep;
	}

	public String getUserId() {
		return userId;
	}

	public String getUsername() {
		return username;
	}

	public boolean hasPassword(String password) {
		return this.password.equals(password);
	}

	public boolean hasUsername(String username) {
		return this.username.equals(username);
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
