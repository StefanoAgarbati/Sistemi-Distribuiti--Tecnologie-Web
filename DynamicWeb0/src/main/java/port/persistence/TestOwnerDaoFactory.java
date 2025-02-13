package port.persistence;

import port.persistence.inMemory.InMemoryTestOwnerDao;

public class TestOwnerDaoFactory {

	public static ITestOwnerDao createTestOwnerDao() {
		ITestOwnerDao instance = new InMemoryTestOwnerDao();
		if(DaoConfig.testOwnerDaoType == DaoType.MEMORY)
			return new InMemoryTestOwnerDao();
		return instance;
	}
	
}
