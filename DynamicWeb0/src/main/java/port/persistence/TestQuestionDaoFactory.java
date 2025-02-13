package port.persistence;

import port.persistence.inMemory.InMemoryTestQuestionDao;

public class TestQuestionDaoFactory {

	public static ITestQuestionDao createTestQuestionDao(ITestDao aTestDao, IQuestionDao aQuestionDao) {
		ITestQuestionDao instance = new InMemoryTestQuestionDao(aTestDao, aQuestionDao);
		if(DaoConfig.testQuestionDaoType == DaoType.MEMORY)
			return new InMemoryTestQuestionDao(aTestDao, aQuestionDao);
		return instance;
	}

}
