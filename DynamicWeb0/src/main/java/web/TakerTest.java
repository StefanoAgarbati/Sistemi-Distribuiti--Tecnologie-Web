package web;

import java.util.Collection;

import application.QuestionService;
import application.ServiceFactory;
import application.TestService;
import model.PossibleResponse;
import model.Question;
import model.Test;

public class TakerTest {

	private String testId;
	private TestService testService;
	private QuestionService questionService;
	
	public TakerTest(String testId) {
		this.testId = testId;
		this.testService = ServiceFactory.createTestService();
		this.questionService = ServiceFactory.createQuestionService();
	}
	public static TakerTest create(String testId) {
		return new TakerTest(testId);
	}
	public Test getTest() {
		return this.testService.getTestById(testId);
	}
	public Collection<Question> getQuestions() {
		return this.questionService.getQuestionsFromTest(testId);
	}
	public Collection<PossibleResponse> getResponsesForQuestion(String questionId) {
		return this.questionService.getResponsesForQuestion(questionId);
	}
}
