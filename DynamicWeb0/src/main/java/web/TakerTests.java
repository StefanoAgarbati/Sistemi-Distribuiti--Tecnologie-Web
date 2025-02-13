package web;

import java.util.Collection;

import application.GroupService;
import application.ServiceFactory;
import application.TestService;
import model.Group;
import model.Test;

public class TakerTests {

	private String groupId;
	private TestService testService;
	private GroupService groupService;
	
	public TakerTests(String groupId) {
		this.groupId = groupId;
		this.testService = ServiceFactory.createTestService();
		this.groupService = ServiceFactory.createGroupService();
	}
	public static TakerTests create(String groupId) {
		return new TakerTests(groupId);
	}
	public Collection<Test> getTests() {
		return this.testService.getTestsAssignedToGroup(this.groupId);
	}
	public Group getGroup() {
		return this.groupService.getGroupById(groupId);
	}
}
