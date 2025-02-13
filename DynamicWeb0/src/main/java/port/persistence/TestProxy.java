package port.persistence;

import java.util.Collection;

import model.ITest;
import model.Question;
import model.Test;

public class TestProxy extends Test implements ITest {

	private QuestionDAO questionDao;
	
	@Override
	public Collection<Question> getQuestions() {
		return questionDao.allQuestionsAssignedTo(this.id());
	}

	
}
