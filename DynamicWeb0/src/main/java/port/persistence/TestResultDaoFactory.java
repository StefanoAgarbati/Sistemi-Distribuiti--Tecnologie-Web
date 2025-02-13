package port.persistence;

import port.persistence.inMemory.InMemoryTestResultDao;

public class TestResultDaoFactory {

	public static ITestResultDao createTestResultDao() {
		if(DaoConfig.testResultDaoType == DaoType.MEMORY)
			return new InMemoryTestResultDao();
		return  new InMemoryTestResultDao(); //default
	}
}
