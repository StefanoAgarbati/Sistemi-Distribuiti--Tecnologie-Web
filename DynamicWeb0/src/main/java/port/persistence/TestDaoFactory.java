package port.persistence;

import port.persistence.inMemory.InMemoryTestDao;

public class TestDaoFactory {

	public static ITestDao createTestDao() {
		ITestDao testDao = new InMemoryTestDao();
		if(DaoConfig.testDaoType == DaoType.MEMORY)
			return new InMemoryTestDao();
		return testDao;
	}

}
