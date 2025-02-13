package port.persistence.inMemory;

import java.util.Collection;
import java.util.LinkedList;

import model.TestResult;
import port.persistence.ITestResultDao;
import utils.CollectionsUtils;

public class InMemoryTestResultDao implements ITestResultDao {

	private Collection<TestResult> results = new LinkedList<>();
	
	public void createTestResult(TestResult aTestResult) {
		results.add(aTestResult);
	}

	@Override
	public Collection<TestResult> getResultsByTaker(String takerId) {
		return CollectionsUtils.filter(results, result -> result.getTakerId().equals(takerId));
	}

	@Override
	public Collection<TestResult> getResultsByTestAndTaker(String takerId, String testId) {
		return CollectionsUtils.filter(results, result -> result.getTakerId().equals(testId) && result.getTestId().equals(testId));
	}
	
}
