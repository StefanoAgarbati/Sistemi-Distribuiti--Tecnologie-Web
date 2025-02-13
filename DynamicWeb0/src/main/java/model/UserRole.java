package model;

public class UserRole {

	private String roleId;
	private String name;
	
	public static UserRole create(String id, String name) {
		return new UserRole(id, name);
	}
	public UserRole(String id, String name) {
		this.setId(id);
		this.setName(name);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public void setId(String id) {
		this.roleId = id;
	}
	public String getId() {
		return this.roleId;
	}
	public boolean equalsTo(UserRole aRole) {
		return getName().equals(aRole.getName());
	}
	
}
