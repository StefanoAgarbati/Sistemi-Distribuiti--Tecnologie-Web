package port.persistence;

import java.util.Collection;

import model.Question;

public interface IQuestionDao {

	boolean addNewQuestion(Question aQuestion);

	Collection<Question> getQuestionsByOwner(String ownerId);

	Collection<Question> getQuestionsByCategory(String categoryId);

	Question getQuestionById(String questionId);

	boolean updateQuestion(Question aQuestion);
	
	boolean deleteQuestion(String questionId);
}