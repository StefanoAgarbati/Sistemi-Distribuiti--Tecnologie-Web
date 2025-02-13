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

public class Questions {

	private String ownerId;
	private QuestionService questionService;
	private TestService testService;
	private CategoryService categoryService;
	
	public Questions(String ownerId) {
		this.ownerId = ownerId;
		this.questionService = ServiceFactory.createQuestionService();
		this.testService = ServiceFactory.createTestService();
		this.categoryService = ServiceFactory.createCategoryService();
	}
	public Collection<Question> getQuestions() {
		return this.questionService.getQuestionsByOwner(ownerId);
	}
	public Collection<PossibleResponse> getResponsesForQuestion(String questionId) {
		return this.questionService.getResponsesForQuestion(questionId);
	}
	public Collection<Test> getTestsWithQuestion(String questionId) {
		return this.testService.getTestsWithQuestion(questionId);
	}
	public Category getCategoryById(String categoryId) {
		return this.categoryService.getCategoryById(categoryId);
	}
	public static Questions create(String ownerId) {
		return new Questions(ownerId);
	}
}
