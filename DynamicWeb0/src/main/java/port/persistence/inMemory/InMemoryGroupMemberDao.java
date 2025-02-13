package port.persistence.inMemory;

import java.util.Collection;
import java.util.LinkedList;

import model.GroupMember;
import port.persistence.IGroupMemberDao;
import utils.CollectionsUtils;
import utils.OutUtils;

public class InMemoryGroupMemberDao implements IGroupMemberDao {

	private Collection<GroupMember> members = new LinkedList<>();
	
	public InMemoryGroupMemberDao() {
		init();
	}
	@Override
	public boolean addMemberToGroup(GroupMember aGroupMember) {
		OutUtils.out("GroupMemberDao member added " + aGroupMember.getMemberId());
		return members.add(aGroupMember);
	}

	@Override
	public GroupMember getMemberById(String memberId) {
		return CollectionsUtils.filterOne(members, m -> m.getMemberId().equals(memberId));
	}

	@Override
	public GroupMember getMemberByUserId(String userId) {
		return CollectionsUtils.filterOne(members, m -> m.getUserId().equals(userId));
	}
	
	private void init() {
		GroupMember m0 = GroupMember.create("1", "3");
		this.addMemberToGroup(m0);
	}

}
