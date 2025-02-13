package port.persistence;

import port.persistence.inMemory.InMemoryCategoryDao;

public class CategoryDaoFactory {

	
	public static ICategoryDao createCategoryDao() {
		ICategoryDao instance = new InMemoryCategoryDao();
		if(DaoConfig.categoryDaoType == DaoType.MEMORY) {
			return new InMemoryCategoryDao();
		}
		return instance;
	}

}
