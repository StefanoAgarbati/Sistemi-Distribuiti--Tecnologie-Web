package port.persistence;

public class DaoFactory {

	private static ICategoryDao categoryDao;
	private static IQuestionDao questionDao;
	private static ITestDao testDao;
	private static ITestQuestionDao testQuestionDao;
	private static IRegisteredUserDao registeredUserDao;
	private static IPossibleResponseDao possibleResponseDao;
	private static ITestOwnerDao testOwnerDao;
	private static IGroupAssignmentDao groupAssignmentDao;
	private static ILinkAssignmentDao linkAssignmentDao;
	private static IGroupDao groupDao;
	private static ILinkDao linkDao;
	private static IGroupMemberDao groupMemberDao;
	private static IParticipationDao participationDao;
	private static IMemberRegistrationCodeDao memberRegistrationCodeDao;
	private static ITestResultDao testResultDao;
	
	public static synchronized ICategoryDao createCategoryDao() {
		if(categoryDao == null)
			categoryDao = CategoryDaoFactory.createCategoryDao();
		return categoryDao;
	}

	public static synchronized IQuestionDao createQuestionDao() {
		if(questionDao == null)
			questionDao = QuestionDaoFactory.createQuestionDao();
		return questionDao;
	}

	public static synchronized ITestDao createTestDao() {
		if(testDao == null)
			testDao = TestDaoFactory.createTestDao();
		return testDao;
	}

	public static synchronized ITestQuestionDao createTestQuestionDao() {
		if(testQuestionDao == null)
			testQuestionDao = TestQuestionDaoFactory.createTestQuestionDao(createTestDao(), createQuestionDao());
		return testQuestionDao;
	}

	public static synchronized IRegisteredUserDao createUserDao() {
		if(registeredUserDao == null)
			registeredUserDao = RegisteredUserDaoFactory.createRegisteredUserDao();
		return registeredUserDao;
	}

	public static IPossibleResponseDao createPossibleResponseDao() {
		if(possibleResponseDao == null)
			possibleResponseDao = PossibleResponseDaoFactory.createPossibleResponseDao();
		return possibleResponseDao;
	}

	public static ITestOwnerDao createTestOwnerDao() {
		if(testOwnerDao == null)
			testOwnerDao = TestOwnerDaoFactory.createTestOwnerDao();
		return testOwnerDao;
	}

	public static IGroupAssignmentDao createGroupAssignmentDao() {
		if(groupAssignmentDao == null)
			groupAssignmentDao = GroupAssignmentDaoFactory.createGroupAssignmentDao();
		return groupAssignmentDao;
	}

	public static ILinkAssignmentDao createLinkAssignmentDao() {
		if(linkAssignmentDao == null)
			linkAssignmentDao = LinkAssignmentDaoFactory.createLinkAssignmentDao();
		return linkAssignmentDao;
	}

	public static IGroupDao createGroupDao() {
		if(groupDao == null)
			groupDao = GroupDaoFactory.createGroupDao();
		return groupDao;
	}

	public static ILinkDao createLinkDao() {
		if(linkDao == null)
			linkDao = LinkDaoFactory.createLinkDao();
		return linkDao;
	}

	public static IGroupMemberDao createGroupMemberDao() {
		if(groupMemberDao == null)
			groupMemberDao = GroupMemberDaoFactory.createGroupMemberDao();
		return groupMemberDao;
	}
	
	public static IParticipationDao createParticipationDao() {
		if(participationDao == null)
			participationDao = ParticipationDaoFactory.createParticipationDao();
		return participationDao;
	}

	public static IMemberRegistrationCodeDao createMemberRegistrationCodeDao() {
		if(memberRegistrationCodeDao == null)
			memberRegistrationCodeDao = MemberRegistrationCodeDaoFactory.createMemberRegistrationCodeDao();
		return memberRegistrationCodeDao;
	}

	public static ITestResultDao createTestResultDao() {
		if(testResultDao == null)
			testResultDao = TestResultDaoFactory.createTestResultDao();
		return testResultDao;
	}
}
