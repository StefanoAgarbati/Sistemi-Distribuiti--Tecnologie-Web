package port.persistence;

import port.persistence.inMemory.InMemoryGroupAssignmentDao;

public class GroupAssignmentDaoFactory {

	public static IGroupAssignmentDao createGroupAssignmentDao() {
		if(DaoConfig.groupAssignmentDaoType == DaoType.MEMORY)
			return new InMemoryGroupAssignmentDao();
		return  new InMemoryGroupAssignmentDao(); //default
	}

}
