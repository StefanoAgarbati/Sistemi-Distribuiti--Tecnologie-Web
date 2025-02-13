package application;

import java.util.Collection;

import model.Category;

public interface ICategoryService {

	boolean addCategory(String name);
	
	Collection<Category> getAllCategories();
	
	
}
