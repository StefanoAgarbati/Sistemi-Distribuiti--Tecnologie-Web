package web;

import java.util.Collection;

import application.GroupService;
import application.ServiceFactory;
import application.TestService;
import model.Group;
import model.Test;

public class Groups {

	private String ownerId;
	private GroupService groupService;
	private TestService testService;
	
	public static Groups create(String ownerId) {
		return new Groups(ownerId);
	}
	protected Groups(String ownerId) {
		this.ownerId = ownerId;
		this.groupService = ServiceFactory.createGroupService();
		this.testService = ServiceFactory.createTestService();
	}
	public Collection<Group> getGroups() {
		return this.groupService.getGroupsByOwner(ownerId);
	}
	public Collection<Test> getTestsAssignedToGroup(String groupId) {
		return this.testService.getTestsAssignedToGroup(groupId);
	}
}
