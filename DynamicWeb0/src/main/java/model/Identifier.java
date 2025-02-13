package model;

public class Identifier {
	
	private String id;
	
	public Identifier(String id) {
		this.setId(id);
	}
	
	public String getId() {
		return this.id;
	}
	
	public boolean equalsTo(Identifier anId) {
		return this.getId().equals(anId.getId());
	}
	private void setId(String id) {
		this.id = id;
	}
}
