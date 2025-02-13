package port.persistence;

import port.persistence.inMemory.InMemoryLinkAssignmentDao;

public class LinkAssignmentDaoFactory {

	public static ILinkAssignmentDao createLinkAssignmentDao() {
		if(DaoConfig.linkAssignmentDaoType == DaoType.MEMORY)
			return new InMemoryLinkAssignmentDao();
		return  new InMemoryLinkAssignmentDao(); //default
	}

}
