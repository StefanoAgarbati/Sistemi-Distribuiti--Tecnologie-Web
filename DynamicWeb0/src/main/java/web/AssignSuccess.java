package web;

import application.GroupService;
import application.ServiceFactory;
import application.TestService;

public class AssignSuccess {

	private String testId;
	private String groupId;
	private TestService testService;
	private GroupService groupService;
	
	public static AssignSuccess create(String testId, String groupId) {
		return new AssignSuccess(testId, groupId);
	}
	public AssignSuccess(String testId, String groupId) {
		this.testId = testId;
		this.groupId = groupId;
		this.testService = ServiceFactory.createTestService();
		this.groupService = ServiceFactory.createGroupService();
	}
	public String getTestName() {
		return this.testService.getTestById(testId).getName();
	}
	public String getGroupName() {
		return this.groupService.getGroupById(groupId).getName();
	}
}
