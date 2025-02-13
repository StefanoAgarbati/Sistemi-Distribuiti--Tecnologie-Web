package port.persistence;

import port.persistence.inMemory.InMemoryMemberRegistrationCodeDao;

public class MemberRegistrationCodeDaoFactory {

	public static IMemberRegistrationCodeDao createMemberRegistrationCodeDao() {
		if(DaoConfig.memberRegistrationCodeDaoType == DaoType.MEMORY)
			return new InMemoryMemberRegistrationCodeDao();
		return  new InMemoryMemberRegistrationCodeDao(); //default
	}
}
