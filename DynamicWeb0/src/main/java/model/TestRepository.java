package model;

import java.util.Collection;

public interface TestRepository {
	
	Test findTestById(String testId);
	
	void save(Test aTest);
	
	Collection<Test> getAllTests();
	
	long nextId();
	
}
