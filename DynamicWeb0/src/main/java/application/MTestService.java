package application;

import java.util.ArrayList;
import java.util.Collection;

import model.Category;
import model.CategoryId;
import model.Question;
import model.Test;
import model.TestId;
import model.TestOwner;
import model.TestOwnerId;
import model.TestQuestion;
import port.persistence.CategoryDao;
import port.persistence.IdGenerator;
import port.persistence.QuestionDAO;
import port.persistence.TestDao;
import port.persistence.TestOwnerDao;

public class MTestService {

	private TestOwnerDao testOwnerDao;
	private TestDao testDao;
	private QuestionDAO questionDao;
	private CategoryDao categoryDao;
	
	public MTestService() {
		testDao = new TestDao();
		questionDao = new QuestionDAO();
		testOwnerDao = new TestOwnerDao();
		categoryDao = new CategoryDao();
	}
	public Test addANewTest(String testName, String ownerId) {
		Test test = new Test(testName);
		TestOwner owner = testOwnerDao.find(ownerId);
		owner.addTest(test);
		test.setOwner(owner);
		System.out.println("Test ttest owner " + test.getOwner().getId());
		testDao.create(test);
		testOwnerDao.update(owner);
		return test;
	}
	public void addNewTest(String testName, String ownerId, String categoryId) {
		TestId testId = new TestId(IdGenerator.generateId());
		TestOwnerId anOwnerId = new TestOwnerId(ownerId);
		CategoryId aCategoryId = new CategoryId(categoryId);
		Collection<TestQuestion> questions = new ArrayList<>();
		
		Test test = new Test(testId, testName, anOwnerId, aCategoryId, questions);

		testDao.create(test);
	}
	public Collection<Question> allQuestionFromTest(String testId) {
		Test test = testDao.find(testId);
		return test.getQuestions();
	}
	public Collection<Test> allTestOfOwner(String ownerId) {
		//TestOwner owner = testOwnerDao.find(ownerId);
		System.out.println("Finding tests of " + ownerId);
		Collection<Test> tests = testDao.findTestByOwner(ownerId);
		System.out.println("Found " + tests.toString());
		return tests;
	}
	public Collection<Category> getAllCategories() {
		return categoryDao.getAllCategories();
	}
	public void addQuestion(String testId, Question aQuestion) {
		Test test = testDao.find(testId);
		test.addQuestion(aQuestion);
		questionDao.create(aQuestion);
		
		testDao.update(test);
	}
}
