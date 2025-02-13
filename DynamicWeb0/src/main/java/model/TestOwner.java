package model;

public class TestOwner {

	private String id;
	private String registeredUserId;
	
	public static TestOwner create(String id, String username) {
		TestOwner to = new TestOwner();
		to.setId(id);
		to.setId(username);
		return to;
	}

	public static TestOwner create(String id) {
		TestOwner to = new TestOwner();
		to.setId(id);
		return to;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return this.id;
	}

	public String getRegisteredUserId() {
		return registeredUserId;
	}

	public void setRegisteredUserId(String registeredUserId) {
		this.registeredUserId = registeredUserId;
	}
	
	
}
