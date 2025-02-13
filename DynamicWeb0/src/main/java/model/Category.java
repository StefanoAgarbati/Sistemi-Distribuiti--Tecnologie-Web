package model;

public class Category implements ICategory{

	private String name;
	private String id;
	private String ownerId;
	
	public Category() {
		
	}
	
	public Category(String name) {
		this.name = name;
	}
	public Category(String id, String name) {
		setName(name);
		setId(id);
	}
	
	public String getOwnerId() {
		return this.ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	
	public boolean ofName(String aName) {
		return name.equals(aName);
	}

	public static Category create(String id, String name, String ownerId) {
		Category category = new Category();
		category.setId(id);
		category.setName(name);
		category.setOwnerId(ownerId);
		return category;
	}
	public static Category of(String categoryName) {
		return new Category(categoryName);
	}
	public static Category of(String id, String categoryName) {
		return new Category(id, categoryName);
	}
}
