package port.persistence;

import java.util.Collection;
import java.util.List;

import model.Question;
import model.Test;
import model.TestQuestion;

public interface ITestQuestionDao {

	
	Collection<Test>getTestsWithQuestion(String questionId);

	boolean addTestQuestion(TestQuestion aTestQuestion);

	boolean deleteTestQuestion(String testId, String questionId);

	Collection<Question> getQuestionsWithTest(String testId);

}
