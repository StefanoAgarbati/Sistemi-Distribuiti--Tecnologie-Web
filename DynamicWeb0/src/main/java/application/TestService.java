package application;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import model.Group;
import model.GroupAssignment;
import model.IQuestion;
import model.Link;
import model.Question;
import model.QuestionRepository;
import model.Test;
import model.TestQuestion;
import model.TestRepository;
import port.persistence.DaoFactory;
import port.persistence.ITestDao;
import port.persistence.ITestQuestionDao;
import port.persistence.IdGenerator;
import utils.OutUtils;

public class TestService {

	private ITestDao testDao;
	private ITestQuestionDao testQuestionDao;
	private AssignmentService assignmentService;
	
	public TestService() {
		this.testDao = DaoFactory.createTestDao();
		this.testQuestionDao = DaoFactory.createTestQuestionDao();
		this.assignmentService = ServiceFactory.createAssignmentService();
	}
	public TestService(ITestDao testDao, ITestQuestionDao testQuestionDao, AssignmentService assignmentService) {
		this.testDao = testDao;
		this.testQuestionDao = testQuestionDao;
		this.assignmentService = assignmentService;
	}

	public void addNewTest(String name, String categoryId, String ownerId) {
		OutUtils.out("TestService-addNewTest name: " + name + " category: " + categoryId + " owner:" +ownerId);
		this.getTestDao().create(Test.create(IdGenerator.generateId(), name, categoryId, ownerId));
	}

	public Collection<Test> getAllTestsByOwner(String ownerId) {
		return this.getTestDao().getAllTestsByOwner(ownerId);
	}

	public Collection<Test> getAllTestsByCategory(String categoryId) {
		return this.getTestDao().getAllTestsByCategory(categoryId);
	}

	public Collection<Test> getTestsWithQuestion(String questionId) {
		return this.testQuestionDao.getTestsWithQuestion(questionId);

	}
	public Collection<Test> getTestsAssignedToGroup(String groupId) {
		Collection<GroupAssignment> assignments = this.assignmentService.getGroupAssignmentsForGroup(groupId);
		Collection<Test> tests = new LinkedList<>();
		for(GroupAssignment assignment : assignments) {
			String testId = assignment.getTestId();
			Test test = this.getTestById(testId);
			tests.add(test);
		}
		return tests;
	}
	public Test getTestById(String testId) {
		return this.testDao.getTestById(testId);
	}
	public int getNumberOfQuestionsForTest(String testId) {
		return this.testQuestionDao.getQuestionsWithTest(testId).size();
	}
	private ITestDao getTestDao() {
		return this.testDao;
	}

}
