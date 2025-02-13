package web;

public class CategoryViewModel {

	private String name;
	private String categoryId;
	
	protected CategoryViewModel(String name, String categoryId) {
		super();
		this.name = name;
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public String getCategoryId() {
		return categoryId;
	}
	
	
}
