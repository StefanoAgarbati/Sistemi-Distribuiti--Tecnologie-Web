package application;

import java.util.Collection;

import model.Test;
import port.persistence.ITestDao;
import port.persistence.IdGenerator;

public class TestServiceImpl {
	
	public void addNewTest(String name, String categoryId, String ownerId) {
		this.getTestDao().create(Test.create(IdGenerator.generateId(), name, categoryId, ownerId));
	}
	
	public Collection<Test> getAllTestsByOwner(String ownerId) {
		return this.getTestDao().getAllTestsByOwner(ownerId);
	}
	public Collection<Test> getAllTestsByCategory(String categoryId) {
		return this.getTestDao().getAllTestsByCategory(categoryId);
	}
	private ITestDao getTestDao() {
		return null;
	}

}
