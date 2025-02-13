package port.persistence;

import java.util.Collection;

import model.Question;

public class QuestionDAO implements IQuestionDao {
	
	
	@Override
	public boolean addNewQuestion(Question aQuestion) {
		return false;
	}

	@Override
	public Collection<Question> getQuestionsByOwner(String ownerId) {
		return null;
	}

	@Override
	public Collection<Question> getQuestionsByCategory(String categoryId) {
		return null;
	}

	@Override
	public Question getQuestionById(String questionId) {
		return null;
	}
	
	
}
