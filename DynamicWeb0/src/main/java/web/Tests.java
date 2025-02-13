package web;

import java.util.Collection;

import application.AssignmentService;
import application.ServiceFactory;
import application.TestService;
import model.Group;
import model.Link;
import model.Test;

public class Tests {

	private String ownerId;
	private TestService testService;
	private AssignmentService assignmentService;
	
	public Tests(String ownerId) {
		this.ownerId = ownerId;
		this.testService = ServiceFactory.createTestService();
		this.assignmentService = ServiceFactory.createAssignmentService();
	}

	public Collection<Test> getAllTests() {
		return this.testService.getAllTestsByOwner(ownerId);

	}

	public Collection<Group> getGroupAssignedToTest(String testId) {
		return this.assignmentService.getGroupsForTest(testId);
	}

	public Collection<Link> getLinkAssignedToTest(String testId) {
		return assignmentService.getLinksForTest(testId);
	}

	public int getTotalAssignmentsForTest(String testId) {
		int groupAssignments = this.getGroupAssignedToTest(testId).size();
		int linkAssignments = this.getLinkAssignedToTest(testId).size();
		return groupAssignments + linkAssignments;

	}

	public static Tests create(String userId) {
		Tests t = new Tests(userId);
		return t;
	}

}
