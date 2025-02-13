package web;

import java.util.Collection;

import application.CategoryService;
import application.ServiceFactory;
import model.Category;

public class AddQuestionToBank {

	private CategoryService categoryService;
	private String ownerId;
	
	public AddQuestionToBank(String ownerId) {
		this.ownerId = ownerId;
		this.categoryService = ServiceFactory.createCategoryService();
	}
	
	public Collection<Category> getCategories() {
		return this.categoryService.getAllCategoriesByOwner(ownerId);
	}
}
