package port.persistence;

import java.util.Collection;

import model.MemberRegistrationCode;

public interface IMemberRegistrationCodeDao {

	boolean addMemberRegistrationCode(MemberRegistrationCode aCode);
	
	MemberRegistrationCode getMemberRegistrationCodebyId(String codeId);
	
	Collection<MemberRegistrationCode> getMemberRegistrationCodeByGroup(String groupId);
	
}
