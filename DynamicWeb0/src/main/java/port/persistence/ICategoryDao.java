package port.persistence;

import java.util.Collection;

import model.Category;

public interface ICategoryDao {

	boolean createNewcategory(Category aCategory);
	
	Category getCategoryById(String categoryId);
	
	Collection<Category> getAllCategories(String ownerId);

	boolean updateCategory(Category aCategory);

	boolean hasCategory(String categoryName);

	boolean deleteCategory(String categoryId);
	
}
