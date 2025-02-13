package web;

import java.util.Collection;

import application.AssignmentService;
import application.ServiceFactory;
import application.TestService;
import model.Test;

public class AssignTest {

	private String ownerId;
	private String groupId;
	private TestService testService;
	private AssignmentService assignmentService;
	
	public static AssignTest create(String ownerId, String groupId) {
		return new AssignTest(ownerId, groupId);
	}
	protected AssignTest(String ownerId, String groupId) {
		this.ownerId = ownerId;
		this.groupId= groupId;
		this.testService = ServiceFactory.createTestService();
		this.assignmentService = ServiceFactory.createAssignmentService();
	}
	public Collection<Test> getTests() {
		return this.testService.getAllTestsByOwner(ownerId);
	}
	public boolean isTestAssignedToGroup(String testId) {
		return this.assignmentService.isTestAssignedToGroup(testId, groupId);
	}
	public String getGroupId() {
		return this.groupId;
	}
}
