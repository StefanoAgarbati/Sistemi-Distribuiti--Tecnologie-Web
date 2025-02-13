package application;

import java.util.Collection;

import model.Category;
import openejb.shade.org.apache.bcel.generic.RETURN;
import port.persistence.CategoryDao;
import port.persistence.ICategoryDao;
import port.persistence.IdGenerator;
import utils.OutUtils;


public class CategoryService {
	
	private ICategoryDao categoryDao;
	private QuestionService questionService;
	
	public CategoryService(QuestionService questionService, ICategoryDao categoryDao) {
		this.categoryDao = categoryDao; 
		this.questionService = questionService;
	}
	
	public boolean addCategory(Category aCategory) {
		return this.categoryDao.createNewcategory(aCategory);
	}
	
	public boolean changeCategoryName(String id, String aName) {
		Category aCategory = categoryDao.getCategoryById(id);
		
		if(aCategory == null)
			return false;
		aCategory.setName(aName);
		
		return categoryDao.updateCategory(aCategory);
	}
	public boolean deleteCategory(String categoryId) {
		int numberOfQuestions = this.questionService.getNumberOfQuestionsByCategory(categoryId);
		if(numberOfQuestions == 0)
			return this.categoryDao.deleteCategory(categoryId);
		return false;
	}
	public Collection<Category> getAllCategoriesByOwner(String ownerId) {
		Collection<Category> categories = this.categoryDao.getAllCategories(ownerId);
		OutUtils.out("CategoryService(categories("+categories+")");
		return categories;
	}

	public boolean addCategory(String categoryName, String ownerId) {
		if(categoryDao.hasCategory(categoryName))
			return false;
		Category category = Category.create(IdGenerator.generateId(), categoryName, ownerId);
		this.categoryDao.createNewcategory(category);
		return true;
	}

	public Category getCategoryById(String categoryId) {
		return this.categoryDao.getCategoryById(categoryId);
	}
	
}
