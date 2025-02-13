package port.persistence;

import java.util.Collection;

import model.Test;

public class TestRepository implements ITestRepository {

	private TestDao testDao;
	
	public TestRepository() {
		testDao = new TestDao();
	}
	
	public Collection<Test> findByOwner(String ownerId) {
		testDao.
	}
}
