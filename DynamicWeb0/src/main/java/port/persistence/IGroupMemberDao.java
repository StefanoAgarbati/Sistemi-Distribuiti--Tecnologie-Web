package port.persistence;

import model.GroupMember;

public interface IGroupMemberDao {
	
	boolean addMemberToGroup(GroupMember aGroupMember);
	
	GroupMember getMemberById(String memberId);
	
	GroupMember getMemberByUserId(String userId);
	
}
