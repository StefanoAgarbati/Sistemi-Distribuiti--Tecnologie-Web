package web;

import java.util.Collection;

import application.CategoryService;
import application.QuestionService;
import application.ServiceFactory;
import model.Category;

public class Categories {

	private String ownerId;
	private CategoryService categoryService;
	private QuestionService questionService;
	
	public static Categories create(String ownerId) {
		Categories instance = new Categories();
		instance.setOwnerId(ownerId);
		return instance;
	}
	private Categories() {
		categoryService = ServiceFactory.createCategoryService();
		questionService = ServiceFactory.createQuestionService();
	}
	public int getNumberOfQuestionsBelongingToCategory(String categoryId) {
		return this.questionService.getNumberOfQuestionsByCategory(categoryId);
	}
	
	public Collection<Category> getCategories() {
		return this.categoryService.getAllCategoriesByOwner(this.ownerId);
	}
	private void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
}
