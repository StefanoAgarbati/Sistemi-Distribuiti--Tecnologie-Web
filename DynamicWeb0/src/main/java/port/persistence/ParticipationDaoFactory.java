package port.persistence;

import port.persistence.inMemory.InMemoryParticipationDao;

public class ParticipationDaoFactory {

	public static IParticipationDao createParticipationDao() {
		if(DaoConfig.participationDaoType == DaoType.MEMORY)
			return new InMemoryParticipationDao();
		return  new InMemoryParticipationDao(); //default
	}
	
}
