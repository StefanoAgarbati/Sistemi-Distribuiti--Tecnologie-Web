package port.persistence;

import port.persistence.inMemory.InMemoryGroupMemberDao;

public class GroupMemberDaoFactory {

	public static IGroupMemberDao createGroupMemberDao() {
		if(DaoConfig.groupMemberDaoType == DaoType.MEMORY)
			return new InMemoryGroupMemberDao();
		return new InMemoryGroupMemberDao(); //default
	}
	
}
