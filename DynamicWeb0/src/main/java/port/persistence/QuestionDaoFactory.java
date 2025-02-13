package port.persistence;

import port.persistence.inMemory.InMemoryQuestionDao;

public class QuestionDaoFactory {

	public static IQuestionDao createQuestionDao() {
		if(DaoConfig.questionDaoType == DaoType.MEMORY)
			return new InMemoryQuestionDao();
		return new InMemoryQuestionDao();
	}

}
