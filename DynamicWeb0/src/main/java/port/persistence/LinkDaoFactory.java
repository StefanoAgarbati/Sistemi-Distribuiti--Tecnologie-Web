package port.persistence;

import port.persistence.inMemory.InMemoryLinkDao;

public class LinkDaoFactory {

	public static ILinkDao createLinkDao() {
		if(DaoConfig.linkDaoType == DaoType.MEMORY)
			return new InMemoryLinkDao();
		return  new InMemoryLinkDao(); //default
	}

}
