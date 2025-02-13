package model;

import java.util.Collection;

public interface QuestionRepository {

	void save(Question aQuestion);
	
	Question findQuestionById(String id);
	
	Collection<Question> allQuestions();
	
	Collection<Question> allQuestions(String categoryId);
	
	Collection<Question> getTestQuestions(String testId);
	
}
