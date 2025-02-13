package web;

import java.util.Collection;
import java.util.LinkedList;

import application.GroupMemberService;
import application.GroupService;
import application.ServiceFactory;
import model.Group;
import model.GroupMember;
import model.Participation;

public class TakerHome {

	private String userId;
	private GroupMemberService groupMemberService;
	private GroupService groupService;
	
	public TakerHome(String userId) {
		this.userId = userId;
		this.groupMemberService = ServiceFactory.createGroupMemberService();
		this.groupService = ServiceFactory.createGroupService();
	}
	public Collection<Group> getGroups() {
		GroupMember member = this.groupMemberService.getMemberByUserId(userId);
		System.out.println("GroupMember in TakerHome: " + member);
		String memberId = member.getMemberId();
		Collection<Group> groups = getMemberGroups(memberId);
		return groups;
	}

	private Collection<Group> getMemberGroups(String memberId) {
		Collection<Participation> participations = this.groupMemberService.getParticipationsByMember(memberId);
		Collection<Group> groups = new LinkedList<>();
		for(Participation p : participations) {
			String groupId = p.getGroupId();
			Group group = this.groupService.getGroupById(groupId);
			groups.add(group);
		}
		return groups;
	}
}
