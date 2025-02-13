package application;

import model.IQuestion;

public interface IQuestionService {
	
	String assignQuestionToTest(String testId, IQuestion aQuestion);
}
