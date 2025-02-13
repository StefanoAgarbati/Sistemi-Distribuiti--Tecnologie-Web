package port.persistence;

import java.util.Collection;

import model.Test;

public interface ITestDao {
	
	Test getTestById(String testId);
	
	Collection<Test> getAllTestsByOwner(String ownerId);
	
	void create(Test aTest);

	Collection<Test> getAllTestsByCategory(String categoryId);
	
	
	
}
