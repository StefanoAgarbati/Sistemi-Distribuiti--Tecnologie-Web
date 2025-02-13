package port.persistence;

import port.persistence.inMemory.InMemoryGroupDao;

public class GroupDaoFactory {

	public static IGroupDao createGroupDao() {
		if(DaoConfig.groupDaoType == DaoType.MEMORY)
			return new InMemoryGroupDao();
		return  new InMemoryGroupDao(); //default
	}

}
