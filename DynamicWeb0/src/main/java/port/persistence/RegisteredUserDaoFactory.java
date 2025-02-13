package port.persistence;

import port.persistence.inMemory.InMemoryRegisteredUserDao;

public class RegisteredUserDaoFactory {

	public static IRegisteredUserDao createRegisteredUserDao() {
		IRegisteredUserDao instance = new InMemoryRegisteredUserDao();
		if(DaoConfig.registeredUserDaoType == DaoType.MEMORY) {
			return new InMemoryRegisteredUserDao();
		}
		return instance;
	}

}
