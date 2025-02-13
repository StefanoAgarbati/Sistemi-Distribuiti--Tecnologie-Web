package application;

import port.persistence.DaoFactory;
import utils.OutUtils;

public class ServiceFactory {

	private static CategoryService categoryService;
	private static QuestionService questionService;
	private static TestService testService;
	private static RegistrationService registrationService;
	private static AuthenticationService authService;
	private static AssignmentService assignmentService;
	private static GroupService groupService;
	private static GroupMemberService groupMemberService;
	private static RegistrationCodeService registrationCodeService;
	private static TestResultService testResultService;
	
	public static synchronized CategoryService createCategoryService() {
		if(categoryService != null)
			return categoryService;
		categoryService = new CategoryService(createQuestionService(),DaoFactory.createCategoryDao());
		return categoryService;
	}

	public static synchronized QuestionService createQuestionService() {
		if(questionService == null) {
			questionService = new QuestionService(DaoFactory.createQuestionDao(), DaoFactory.createTestQuestionDao(), 
					DaoFactory.createPossibleResponseDao());
			OutUtils.out("QuestionService created");
		}
		return questionService;
	}

	public static synchronized TestService createTestService() {
		if(testService == null)
			testService = new TestService(DaoFactory.createTestDao(), DaoFactory.createTestQuestionDao(), createAssignmentService());
		return testService;
	}

	public static RegistrationService createRegistrationService() {
		if(registrationService == null)
			registrationService = new RegistrationService(DaoFactory.createUserDao(), 
					DaoFactory.createTestOwnerDao(), DaoFactory.createCategoryDao());
		return registrationService;
	}

	public static AuthenticationService createAuthenticationService() {
		if(authService == null)
			authService = new AuthenticationService(DaoFactory.createUserDao());
		return authService;
	}

	public static AssignmentService createAssignmentService() {
		if(assignmentService == null)
			assignmentService = new AssignmentService(DaoFactory.createGroupAssignmentDao(), DaoFactory.createLinkAssignmentDao(), 
					DaoFactory.createGroupDao(), DaoFactory.createLinkDao());
		return assignmentService;
	}

	public static GroupService createGroupService() {
		if(groupService == null)
			groupService = new GroupService(DaoFactory.createGroupDao());
		return groupService;
	}
	
	public static GroupMemberService createGroupMemberService() {
		if(groupMemberService == null)
			groupMemberService = new GroupMemberService(DaoFactory.createGroupMemberDao(), DaoFactory.createParticipationDao());
		return groupMemberService;
	}

	public static RegistrationCodeService createRegistrationCodeService() {
		if(registrationCodeService == null)
			registrationCodeService = new RegistrationCodeService(DaoFactory.createMemberRegistrationCodeDao());
		return registrationCodeService;
	}

	public static TestResultService createTestResultService() {
		if(testResultService == null)
			testResultService = new TestResultService(DaoFactory.createTestResultDao(), createQuestionService());
		return testResultService;
	}
	
}
