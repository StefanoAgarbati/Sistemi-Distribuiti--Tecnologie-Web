package web;

import java.util.Collection;

import application.GroupMemberService;
import application.GroupService;
import application.RegistrationCodeService;
import application.RegistrationService;
import application.ServiceFactory;
import application.TestService;
import model.Group;
import model.GroupMember;
import model.MemberRegistrationCode;
import model.Participation;
import model.RegisteredUser;
import model.Test;
import utils.OutUtils;

public class EditGroup {
	
	private String groupId;
	private GroupService groupService;
	private GroupMemberService groupMemberService;
	private RegistrationService registrationService;
	private TestService testService;
	private RegistrationCodeService registrationCodeService;
	
	public EditGroup(String groupId) {
		this.groupId = groupId;
		this.groupService = ServiceFactory.createGroupService();
		this.groupMemberService = ServiceFactory.createGroupMemberService();
		this.registrationService = ServiceFactory.createRegistrationService();
		this.testService = ServiceFactory.createTestService();
		this.registrationCodeService = ServiceFactory.createRegistrationCodeService();
	}
	public static EditGroup create(String groupId) {
		return new EditGroup(groupId);
	}
	public Group getGroup() {
		return this.groupService.getGroupById(groupId);
		
	}
	public String getGroupId() {
		return this.groupId;
	}
	public Collection<Test> getTestsAssignedToGroup() {
		return this.testService.getTestsAssignedToGroup(groupId);
	}
	public Collection<Participation> getParticipationsByGroup() {
		return this.groupMemberService.getParticipationsByGroup(groupId);
	}
	public Collection<GroupMember> getMembersByGroup() {
		Collection<GroupMember> members = this.groupMemberService.getMembersByGroup(groupId);
		OutUtils.out("EditGroup getMembersByGroup(): " + members);
		return members;
	}
	public RegisteredUser getUserById(String userId) {
		return this.registrationService.getUserByIdentifier(userId);
	}
	public Collection<MemberRegistrationCode> getMemberRegistrationCodeByGroup() {
		return this.registrationCodeService.getMemberRegistrationCodeByGroup(groupId);
	}
}
