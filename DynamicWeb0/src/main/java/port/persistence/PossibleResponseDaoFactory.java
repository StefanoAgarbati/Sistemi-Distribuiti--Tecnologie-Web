package port.persistence;

import port.persistence.inMemory.InMemoryPossibleResponseDao;

public class PossibleResponseDaoFactory {

	public static IPossibleResponseDao createPossibleResponseDao() {
		IPossibleResponseDao instance = new InMemoryPossibleResponseDao();
		if(DaoConfig.possibleReponseDaoType == DaoType.MEMORY)
			return new InMemoryPossibleResponseDao();
		return instance;
		
	}

}
