package model;

public class TestOwnerId {

	private String id;
	
	public TestOwnerId(String id) {
		setId(id);
	}
	
	public String id() {
		return this.id;
	}
	
	private void setId(String id) {
		this.id = id;
	}
	public boolean equalsTo(TestOwnerId anId) {
		return this.id.equals(anId);
	}
}
