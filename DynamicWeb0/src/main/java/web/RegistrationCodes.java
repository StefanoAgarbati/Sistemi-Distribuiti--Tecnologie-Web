package web;

import java.util.Collection;

import application.GroupService;
import application.RegistrationCodeService;
import application.ServiceFactory;
import model.Group;
import model.MemberRegistrationCode;

public class RegistrationCodes {

	private String groupId;
	
	private GroupService groupService;
	private RegistrationCodeService registrationCodeService;
	
	public static RegistrationCodes create(String groupId) {
		return new RegistrationCodes(groupId);
	}
	public RegistrationCodes(String groupId) {
		this.groupId = groupId;
		this.groupService = ServiceFactory.createGroupService();
		this.registrationCodeService = ServiceFactory.createRegistrationCodeService();
	}
	public Group getGroup() {
		return this.groupService.getGroupById(groupId);
	}
	public Collection<MemberRegistrationCode> getMemberRegistrationCodes() {
		return this.registrationCodeService.getMemberRegistrationCodeByGroup(groupId);
	}
}
