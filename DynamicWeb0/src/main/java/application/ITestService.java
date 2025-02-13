package application;

import java.util.Collection;

import model.IQuestion;
import model.Test;

public interface ITestService {

	String addNewTest(String testName, String categoryId, String ownerId);
	
	String addQuestion(IQuestion aQuestion);
	
	Collection<Test> getAllTests();
}
