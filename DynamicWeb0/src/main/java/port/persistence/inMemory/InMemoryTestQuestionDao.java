package port.persistence.inMemory;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import model.Question;
import model.Test;
import model.TestQuestion;
import port.persistence.IQuestionDao;
import port.persistence.ITestDao;
import port.persistence.ITestQuestionDao;
import utils.CollectionsUtils;

public class InMemoryTestQuestionDao implements ITestQuestionDao {

	private Collection<TestQuestion> testQuestions = new LinkedList<>();
	private ITestDao testDao;
	private IQuestionDao questionDao;
	
	public InMemoryTestQuestionDao(ITestDao testDao, IQuestionDao questionDao) {
		this.testDao = testDao;
		this.questionDao = questionDao;
		init();
	}
	@Override
	public boolean addTestQuestion(TestQuestion aTestQuestion) {
		System.out.println("Question added to test " + aTestQuestion.getTestId());
		return this.testQuestions.add(aTestQuestion);
	}
	
	@Override
	public boolean deleteTestQuestion(String testId, String questionId) {
		// to control for possible null pointer exception caused by get(0)
		return testQuestions.remove(
				CollectionsUtils.filter(testQuestions, (item) -> item.hasTestId(testId) && item.hasQuestionId(questionId))
				.get(0)
				);
	}

	@Override
	public Collection<Test> getTestsWithQuestion(String questionId) {
		Collection<TestQuestion> testsQuestion = CollectionsUtils.filter(testQuestions, 
				tq -> tq.getQuestionId().equals(questionId));
		Collection<Test> tests = new LinkedList<>();
		Iterator<TestQuestion> it = testsQuestion.iterator();
		while(it.hasNext()) {
			TestQuestion tq = it.next();
			Test test = this.testDao.getTestById(tq.getTestId());
			tests.add(test);
		}
		return tests;
	}
	@Override
	public Collection<Question> getQuestionsWithTest(String testId) {
		Collection<TestQuestion> tq = CollectionsUtils.filter(testQuestions, item -> item.getTestId().equals(testId));
		Collection<Question> questions = new LinkedList<>();
		tq.forEach(item -> questions.add(this.questionDao.getQuestionById(item.getQuestionId())));
		return questions;
	}
	private void init() {
		TestQuestion tq0 = TestQuestion.create("1", "1");
		TestQuestion tq1 = TestQuestion.create("1", "2");
		
		this.addTestQuestion(tq0);
		this.addTestQuestion(tq1);
		
	}
	
}
