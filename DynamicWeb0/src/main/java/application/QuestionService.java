package application;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import model.PossibleResponse;
import model.Question;
import model.TestQuestion;
import port.persistence.DaoFactory;
import port.persistence.IPossibleResponseDao;
import port.persistence.IQuestionDao;
import port.persistence.ITestDao;
import port.persistence.ITestQuestionDao;
import port.persistence.IdGenerator;
import utils.OutUtils;


public class QuestionService {

	private ITestDao testDao;
	private ITestQuestionDao testQuestionDao;
	private IPossibleResponseDao possibleResponseDao;
	private IQuestionDao questionDao;
	
	public QuestionService(IQuestionDao questionDao, ITestQuestionDao testQuestionDao, IPossibleResponseDao possibleResponseDao) {
		this.questionDao = questionDao;
		this.testQuestionDao = testQuestionDao;
		this.possibleResponseDao = possibleResponseDao;
	}
	
//	public void addQuestionToBank(String ownerId, String categoryId, String text, float score, List<PossibleResponse> responses) {
//		Question q = Question.create(IdGenerator.generateId(), text, score, ownerId, categoryId);
//		responses.forEach(response-> this.possibleResponseDao.createNewResponse(response));
//		.
//	}
	
	public String addQuestionToBank(String ownerId, String categoryId, String text, float points, List<PossibleResponse> responses) {
		String questionId = IdGenerator.generateId();
		Question aQuestion = Question.create(questionId, text, points, ownerId, categoryId);
		this.addQuestionToBank(aQuestion, responses);
		return questionId;
	}
	public String addQuestionToBank(Question aQuestion, List<PossibleResponse> responses) {
		this.questionDao.addNewQuestion(aQuestion);
		for(PossibleResponse response : responses) {
			this.possibleResponseDao.createNewResponse(response);
		}
		return aQuestion.getQuestionId();
	}
	public void addQuestionToTest(String testId, Question aQuestion,List<PossibleResponse> responses) {
		this.assignQuestionToTest(testId, this.addQuestionToBank(aQuestion, responses));
	}
	public void addQuestionToTest(String testId, String ownerId, String categoryId, String text, 
			float points, List<PossibleResponse> responses) {
		String questionId = this.addQuestionToBank(ownerId, categoryId, text, points, responses);
		this.assignQuestionToTest(testId, questionId);
	}
	public void assignQuestionToTest(String testId, String questionId) {
		TestQuestion aTestQuestion = TestQuestion.create(testId, questionId);
		this.testQuestionDao.addTestQuestion(aTestQuestion);
	}
	public void updateQuestion(Question aQuestion, List<PossibleResponse> responses) {
		this.questionDao.updateQuestion(aQuestion);
		this.possibleResponseDao.updateResponses(responses, aQuestion.getQuestionId());
	}
	public boolean deleteQuestionFromTest(String testId, String questionId) {
		return this.testQuestionDao.deleteTestQuestion(testId, questionId);
	}
	public boolean deleteQuestionFromBank(String questionId) {
		if(canRemoveQuestionFromBank(questionId)) {
			return this.questionDao.deleteQuestion(questionId);
		}
		return false;
	}
	private boolean canRemoveQuestionFromBank(String questionId) {
		int numberOfTestsWithQuestion = this.testQuestionDao.getTestsWithQuestion(questionId).size();
		boolean canRemoveQuestion = numberOfTestsWithQuestion == 0;
		return canRemoveQuestion;
	}

	public int totalQuestions(String ownerId) {
		return this.getQuestionsByOwner(ownerId).size();
	}
	public Question getQuestionById(String questionId) {
		return this.questionDao.getQuestionById(questionId);
	}
	public Collection<Question> getQuestionsByOwner(String ownerId) {
		return this.questionDao.getQuestionsByOwner(ownerId);
	}
	public Collection<Question> getQuestionsFromTest(String testId) {
		return testQuestionDao.getQuestionsWithTest(testId);
		
	}
	public float getTotalPointsForTest(String testId) {
		Collection<Question> questions = this.getQuestionsFromTest(testId);
		float total = 0;
		for(Question question : questions) {
			total = total + question.getPoints();
		}
		return total;
	}
	public int getNumberOfQuestionsByCategory(String categoryId) {
		OutUtils.out("QuestionService-getNumQByCat invoked");
		Collection<Question> questions = this.questionDao.getQuestionsByCategory(categoryId);
		OutUtils.out("QuestionService-getNumQByCat questions " + questions);
		return questions.size();
	}
	public Collection<PossibleResponse> getResponsesForQuestion(String questionId) {
		return this.possibleResponseDao.getReponsesByQuestion(questionId);
	}
}
