package web;

import java.util.Collection;

import application.CategoryService;
import application.ServiceFactory;
import application.TestService;
import model.Category;
import model.Test;

public class AddQuestionToTest {

	private CategoryService categoryService;
	private TestService testService;
	private String ownerId;
	private String testId;
	
	public static AddQuestionToTest create(String ownerId, String testId) {
		return new AddQuestionToTest(ownerId, testId);
	}
	public AddQuestionToTest(String ownerId, String testId) {
		this.ownerId = ownerId;
		this.testId = testId;
		this.categoryService = ServiceFactory.createCategoryService();
		this.testService = ServiceFactory.createTestService();
	}
	
	public Collection<Category> getCategories() {
		return this.categoryService.getAllCategoriesByOwner(ownerId);
	}
	public Test getTest() {
		return this.testService.getTestById(testId);
	}
}
