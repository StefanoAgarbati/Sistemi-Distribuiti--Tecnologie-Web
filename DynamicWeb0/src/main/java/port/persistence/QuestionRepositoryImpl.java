package port.persistence;

import java.util.Collection;

import model.Question;
import model.QuestionRepository;

public class QuestionRepositoryImpl implements QuestionRepository {

	private QuestionDAO questionDao;
	private TestDao testDao;
	private AssignedQuestionDao assignedDao;
	
	@Override
	public void save(Question aQuestion) {
	}

	@Override
	public Question findQuestionById(String id) {
		return null;
	}

	@Override
	public Collection<Question> allQuestions() {
		return null;
	}

	@Override
	public Collection<Question> allQuestions(String categoryId) {
		return null;
	}

	@Override
	public Collection<Question> getTestQuestions(String testId) {
		
	}

}
