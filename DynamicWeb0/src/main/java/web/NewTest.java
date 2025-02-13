package web;

import java.util.Collection;

import application.CategoryService;
import application.ServiceFactory;
import model.Category;

public class NewTest {

	private String ownerId;
	private CategoryService categoryService;
	
	public NewTest(String ownerId) {
		this.ownerId = ownerId;
		this.categoryService = ServiceFactory.createCategoryService();
	}
	public Collection<Category> getCategories() {
		return this.categoryService.getAllCategoriesByOwner(ownerId);
	}
}
