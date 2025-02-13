package port.persistence.inMemory;

import java.util.Collection;
import java.util.LinkedList;

import model.Category;
import port.persistence.ICategoryDao;
import utils.CollectionsUtils;

public class InMemoryCategoryDao implements ICategoryDao {

	
	private Collection<Category> categories = new LinkedList<>();

	public InMemoryCategoryDao() {
		init();
		showMsg("categories field is " + categories);
	}
	@Override
	public boolean createNewcategory(Category aCategory) {
		boolean res = categories.add(aCategory);
		showMsg("New category added.");
		return res;
	}

	@Override
	public Collection<Category> getAllCategories(String ownerId) {
		return CollectionsUtils.filter(categories, category -> category.getOwnerId().equals(ownerId));
	}
	private void showMsg(String msg) {
		String m = this.getClass().getSimpleName()+"("+msg+")";
		System.out.println(m);
	}
	public static void main(String[] args) {
		InMemoryCategoryDao dao = new InMemoryCategoryDao();
		dao.createNewcategory(new Category());
	}
	@Override
	public Category getCategoryById(String categoryId) {
		for(Category c : categories) {
			if(c.getId().equals(categoryId))
				return c;
		}
		return null;
	}
	@Override
	public boolean updateCategory(Category aCategory) {
		Category category = this.getCategoryById(aCategory.getId());
		categories.remove(category);
		return categories.add(aCategory);
	}
	@Override
	public boolean hasCategory(String categoryName) {
		for(Category c : categories) {
			if(c.getName().equals(categoryName))
				return true;
		}
		return false;
	}
	@Override
	public boolean deleteCategory(String categoryId) {
		for(Category c : categories) {
			if(c.getId().equals(categoryId)) {
				categories.remove(c);
				return true;
			}
		}
		return false;
	}
	private void init() {
		Category c0 = Category.create("1", "Generic", "1");
		Category c1 = Category.create("2", "Science", "1");
		this.categories.add(c0);
		this.categories.add(c1);
	}

}
