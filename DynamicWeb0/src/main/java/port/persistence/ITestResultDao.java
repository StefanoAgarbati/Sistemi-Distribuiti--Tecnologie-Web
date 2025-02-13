package port.persistence;

import java.util.Collection;

import model.TestResult;

public interface ITestResultDao {

	void createTestResult(TestResult aTestResult);
	
	Collection<TestResult> getResultsByTaker(String takerId);
	
	Collection<TestResult> getResultsByTestAndTaker(String takerId, String testId);
	
}
