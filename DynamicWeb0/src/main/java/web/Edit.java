package web;

import java.util.Collection;

import application.CategoryService;
import application.QuestionService;
import application.ServiceFactory;
import application.TestService;
import model.Category;
import model.PossibleResponse;
import model.Question;
import model.Test;

public class Edit {

	private String testId;
	private String ownerId;
	
	private TestService testService;
	private QuestionService questionService;
	private CategoryService categoryService;
	
	public static Edit create(String ownerId, String testId) {
		return new Edit(ownerId, testId);
	}
	public Edit(String ownerId, String testId) {
		this.ownerId = ownerId;
		this.testId = testId;
		this.questionService = ServiceFactory.createQuestionService();
		this.testService = ServiceFactory.createTestService();
		this.categoryService = ServiceFactory.createCategoryService();
	}
	
	public Test getTest() {
		return testService.getTestById(testId);
	}
	public int getNumberOfQuestions() {
		return this.testService.getNumberOfQuestionsForTest(testId);
	}
	public Collection<Question> getQuestions() {
		return this.questionService.getQuestionsFromTest(testId);
	}
	public int getNumberOfQuestionInBank() {
		return this.questionService.getQuestionsByOwner(ownerId).size();
	}
	public Category getQuestionCategory(String categoryId) {
		return this.categoryService.getCategoryById(categoryId);
	}
	public Collection<PossibleResponse> getPossibleResponsesForQuestion(String questionId) {
		return this.questionService.getResponsesForQuestion(questionId);
	}
	public Collection<Test> getTestsWithQuestion(String questionId) {
		return this.testService.getTestsWithQuestion(questionId);
	}
 }
