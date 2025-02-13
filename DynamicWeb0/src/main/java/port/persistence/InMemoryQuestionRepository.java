package port.persistence;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import model.Question;
import model.QuestionRepository;

public class InMemoryQuestionRepository implements QuestionRepository {

	private static InMemoryQuestionRepository instance;
	private Map<String, Question> repo = new HashMap<>();
	
	public static InMemoryQuestionRepository create() {
		if(instance==null) {
			instance = new InMemoryQuestionRepository();
		}
		return instance;
	}
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

}
