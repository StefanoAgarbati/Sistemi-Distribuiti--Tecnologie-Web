package web;

import java.util.Collection;
import java.util.List;

import application.CategoryService;
import application.QuestionService;
import application.ServiceFactory;
import application.TestService;
import model.Category;
import model.PossibleResponse;
import model.Question;
import model.Test;
import utils.CollectionsUtils;

public class EditQuestion {

	private String questionId;
	private String testId;
	private String ownerId;
	private QuestionService questionService;
	private CategoryService  categoryService;
	private TestService testService;
	
	private Question question;
	private Test test;
	private Category category;
	private Collection<PossibleResponse> responses;
	private Collection<Category> categories;
	
	public static EditQuestion create(String questionId, String testId, String ownerId) {
		return new EditQuestion(questionId, testId, ownerId);
	}
	public EditQuestion(String questionId, String testId, String ownerId) {
		this.questionId = questionId;
		this.testId = testId;
		this.ownerId = ownerId;
		this.questionService = ServiceFactory.createQuestionService();
		this.categoryService = ServiceFactory.createCategoryService();
		this.testService = ServiceFactory.createTestService();
		this.question = this.questionService.getQuestionById(questionId);
		this.test = this.testService.getTestById(testId);
		this.responses = this.questionService.getResponsesForQuestion(questionId);
		this.category = this.categoryService.getCategoryById(this.getQuestion().getCategoryId());
		this.categories = this.categoryService.getAllCategoriesByOwner(ownerId);
	}
	public Test getTest() {
		System.out.println("EditQuestion test is " + test);
		return this.test;
	}
	public Question getQuestion() {
		return this.question;
	}
	public Collection<PossibleResponse> getResponses() {
		return this.responses;
	}
	public PossibleResponse getResponseByName(String name) {
		PossibleResponse respi = CollectionsUtils.filterOne(responses, response -> response.getName().equals(name));
		System.out.println("EditQuestion possible response " + respi);
		return respi;
	}
	public Category getCategory() {
		return this.category;
	}
	public Collection<Category> getCategories() {
		return this.categories;
	}
	
}
